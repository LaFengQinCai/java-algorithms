package com.xy.algorithms.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1. 两数之和 —— Hot 100 · 哈希表。
 *
 * <p>题目：给定整数数组 {@code nums} 和目标值 {@code target}，返回和为 {@code target} 的两个数的下标。
 * 保证有且仅有一个答案，同一元素不可重复使用，下标顺序不限。
 *
 * <p>约束：{@code 2 <= nums.length <= 10^4}，{@code -10^9 <= nums[i], target <= 10^9}。
 *
 * <p>思路：
 * <ol>
 *   <li>暴力解法：枚举所有 {@code i < j}，判断 {@code nums[i] + nums[j] == target}，
 *       时间 O(n²)、空间 O(1)。</li>
 *   <li>换个视角：固定 {@code nums[i]}，要找的那个数其实算得出来——{@code target - nums[i]}。</li>
 *   <li>问题就变成「这个数之前出现过吗，下标是几」。把「值 → 下标」放进哈希表，
 *       原本 O(n) 的查找降到均摊 O(1)。</li>
 *   <li>一次遍历即可：每步先查表（表里存的都是 {@code i} 之前的元素），命中直接返回，
 *       未命中再把当前元素入库。因为只查「之前」的元素，同一元素不会被复用，
 *       {@code [3,3]} 这类用例也正确。</li>
 * </ol>
 *
 * <p>复杂度：时间 O(n)，每个元素至多一次 {@code get}、一次 {@code put}，两者均摊 O(1)；
 * 空间 O(n)，哈希表最坏存下 n 个元素——本质是拿空间换时间。
 *
 * <p>踩坑记录：
 * <ul>
 *   <li>「先查后存」而不是「先全存后查」：后者会让 {@code [3,3]} 匹配到同一个下标，返回 {@code [0,0]}。</li>
 *   <li>{@code map.get(k)} 返回 {@code Integer}，没命中返回 {@code null}；直接赋给 {@code int}
 *       会因自动拆箱抛 NPE。</li>
 *   <li>{@code containsKey} 之后再 {@code get} 等于把哈希算两遍；用局部变量接住 {@code get}
 *       的返回值，只查一次。</li>
 *   <li>题目保证有解，末尾不要静默 {@code return null}；抛 {@code IllegalArgumentException}
 *       让「前提被破坏」当场暴露，而不是让调用方在别处 NPE。</li>
 *   <li>注释掉的暴力法不算实现：抽成私有方法 {@code twoSumBruteForce} 才能编译、能被对拍测试覆盖。</li>
 * </ul>
 *
 * <p>Java SE 考点：{@code int} 与 {@code Integer} 的自动装箱/拆箱、{@code HashMap} 的均摊 O(1) 查找、
 * 数组引用传参、接口类型 {@code Map} 声明变量 + 实现类 {@code HashMap} 实例化。
 *
 * @see <a href="https://leetcode.cn/problems/two-sum/">LeetCode 1. 两数之和</a>
 */
public class TwoSum {

    /**
     * 求两数之和为目标值的下标。
     *
     * @param nums   非空整数数组
     * @param target 目标值
     * @return 长度为 2 的下标数组
     */
    private int[] twoSumBruteForce(int[] nums, int target) {
        // 暴力
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("题目必然有解，不应该跑到此处");
    }

    public int[] twoSum(int[] nums, int target) {
        // 哈希表
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                return new int[]{index, i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("题目必然有解，不应该跑到此处");
    }

    /** 本地快速验证入口；正式验证以 {@code TwoSumTest} 为准。 */
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target))); // 期望 [0, 1]
    }
}
