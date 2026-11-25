package com.xy.algorithms.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 49. 字母异位词分组 —— Hot 100 · 哈希表。
 *
 * <p>题目：给定字符串数组 {@code strs}，把互为字母异位词（字母出现次数完全相同、顺序不同）的字符串
 * 分到同一组，返回所有分组。分组之间、组内元素的顺序都不限。
 *
 * <p>约束：{@code 1 <= strs.length <= 10^4}，{@code 1 <= strs[i].length() <= 100}，
 * {@code strs[i]} 仅含小写英文字母。
 *
 * <p>思路：
 * <ol>
 *   <li>「字母组成完全相同」是等价关系，所以正确分组只有一种，问题就变成：
 *       给每个字符串算一个「与字母顺序无关的指纹」，指纹相同即同组。</li>
 *   <li>指纹取「字符升序排列后的字符串」：异位词排序后必然完全相同，非异位词必然不同。
 *       注意 {@code char[]} 必须转成 {@code String} 才能当 key（数组是引用语义，见踩坑记录）。</li>
 *   <li>用 {@code Map<String, Integer>} 记录「指纹 → 该组在结果 list 中的下标」，一次遍历：
 *       指纹已存在就把字符串追加到对应分组，不存在就新建分组并把新下标写回哈希表。</li>
 *   <li>value 存下标而不是直接存 {@code List}，省一层引用；用 {@code ans.size()} 恰好就是
 *       新分组的合法下标，所以不需要额外维护计数器。</li>
 *   <li>一次遍历、每个字符串只处理一次，因此元素不重不漏；重复字符串指纹相同，
 *       自然并入同一组。</li>
 * </ol>
 *
 * <p>复杂度：时间 O(n · k log k)，瓶颈是对每个字符串排序（k 为字符串最大长度，n 为字符串个数）；
 * 空间 O(n · k)，哈希表与结果各保存一份字符串引用。若把指纹换成「26 个字母的出现次数数组并编码」，
 * 可做到 O(n · k) 时间，代价是每个 key 更长。
 *
 * <p>踩坑记录：
 * <ul>
 *   <li>{@code char[]} 不能直接当 {@code HashMap} 的 key：数组继承 {@code Object} 的
 *       {@code equals}/{@code hashCode}，是引用语义，内容相同的两个数组既不 equals 也不等哈希，
 *       会导致每次都当成新 key。必须 {@code new String(chars)}。</li>
 *   <li>{@code containsKey} 之后再 {@code get} 等于算两次哈希；用局部变量接住 {@code get}
 *       的返回值，只查一次。</li>
 *   <li>{@code List.add} 返回 {@code boolean}，不能链式调用；想链式得用
 *       {@code map.computeIfAbsent(key, k -> new ArrayList<>()).add(s)}，它返回 value 本身。</li>
 *   <li>空串 {@code ""} 的指纹是 {@code ""}，是合法 key，不需要特判。</li>
 *   <li>{@code strs.length == 1} 的特判和主流程重复，属于冗余分支：逻辑只该写一遍。</li>
 *   <li>通配符 {@code import java.util.*} 在企业规范里不允许，用 IDE 的 Optimize Imports 换成显式导入。</li>
 * </ul>
 *
 * <p>Java SE 考点：{@code Map.computeIfAbsent}、{@code List<List<String>>} 嵌套泛型、
 * {@code Arrays.sort(char[])} 与 {@code new String(char[])}、{@code Collection → List} 的
 * {@code new ArrayList<>(map.values())}、泛型不支持基本类型。
 *
 * @see <a href="https://leetcode.cn/problems/group-anagrams/">LeetCode 49. 字母异位词分组</a>
 */
public class GroupAnagrams {

    /**
     * 把异位词分组。
     *
     * @param strs 非空字符串数组
     * @return 分组后的结果，顺序不限
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            String key = signature(str);
            Integer groupIndex = map.get(key);
            if (groupIndex == null) {
                groupIndex = ans.size();
                ans.add(new ArrayList<>());
                map.put(key, groupIndex);
            }
            ans.get(groupIndex).add(str);
        }
        return ans;
    }

    private static String signature(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /** 本地快速验证入口；正式验证以 {@code GroupAnagramsTest} 为准。 */
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = new GroupAnagrams().groupAnagrams(strs);
        System.out.println(result); // 期望 3 组，如 [[bat], [nat, tan], [ate, eat, tea]]
        System.out.println("分组数 = " + result.size());
    }
}
