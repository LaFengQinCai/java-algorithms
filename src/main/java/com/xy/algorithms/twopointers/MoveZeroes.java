package com.xy.algorithms.twopointers;

import java.util.Arrays;

/**
 * LeetCode 283. 移动零 —— Hot 100 · 双指针。
 *
 * <p>题目：把数组中所有 0 移到末尾，同时保持非零元素的相对顺序。必须原地操作，
 * 不允许拷贝数组，方法无返回值。
 *
 * <p>约束：{@code 1 <= nums.length <= 10^4}，{@code -2^31 <= nums[i] <= 2^31 - 1}。
 *
 * <p>思路：
 * <ol>
 *   <li>最省事的做法：新建一个数组，先把所有非零元素按原顺序放进去，其余位置补 0。
 *       时间 O(n)、空间 O(n)——不满足「原地」要求。</li>
 *   <li>要原地，就用「读指针 + 写指针」：读指针 {@code i} 顺次扫数组，
 *       写指针负责把遇到的非零元素依次往前放。</li>
 *   <li>本实现用计数器表达写指针：{@code zeroCount} 记录目前为止遇到过多少个 0，
 *       于是 {@code i - zeroCount} 恰好就是「下一个非零元素该落的位置」，也就是慢指针。</li>
 *   <li>非零元素往前搬家后，把它原来的位置补 0。遍历结束时 0 自然全部沉到尾部，
 *       非零元素因为是被按遍历顺序依次前移的，相对顺序天然保持不变。</li>
 * </ol>
 *
 * <p>复杂度：时间 O(n)，一次遍历；空间 O(1)，只用了计数器。
 *
 * <p>踩坑记录：
 * <ul>
 *   <li>{@code zeroCount > 0} 这个判断不能少：{@code zeroCount == 0} 时慢指针和读指针重合，
 *       此时执行 {@code nums[i] = 0} 会把刚读到的非零值抹掉，{@code [1,2,3]} 会变成 {@code [0,0,0]}。</li>
 *   <li>想避免这个判断，可以改写成交换：{@code slow == i} 时是自交换，天然安全，无需额外守卫。</li>
 *   <li>{@code i - zeroCount} 是隐式的慢指针；直接声明 {@code int slow = 0} 会让「下一个非零值写在
 *       {@code slow} 处」这个不变量更直观。</li>
 * </ul>
 *
 * <p>Java SE 考点：形参 {@code int[] nums} 传的是数组引用，方法内改元素对调用方可见，
 * 所以返回 {@code void} 就够；不要用 {@code ArrayList} 中转再拷回来，那样空间就不是 O(1) 了。
 *
 * <p>踩坑记录：
 *
 * @see <a href="https://leetcode.cn/problems/move-zeroes/">LeetCode 283. 移动零</a>
 */
public class MoveZeroes {

    /**
     * 原地把所有 0 移到末尾，非零元素相对顺序不变。
     *
     * @param nums 待处理数组，方法返回后即为结果
     */
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else if (zeroCount > 0) {
                nums[i - zeroCount] = nums[i];
                nums[i] = 0;
            }
        }
    }

    /** 本地快速验证入口；正式验证以 {@code MoveZeroesTest} 为准。 */
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums)); // 期望 [1, 3, 12, 0, 0]
    }
}
