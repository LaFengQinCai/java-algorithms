package com.xy.algorithms.hashtable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * {@link GroupAnagrams} 的单元测试。
 *
 * <p>返回值是「分组的集合」，分组之间和组内顺序都不限，所以不能直接比较 List 结构，改为校验三条不变量：
 * 组内互为异位词、元素不重不漏、分组数量正确。三条同时成立，就等价于分组正确
 * （异位关系是等价关系，分组方式唯一）。
 */
@DisplayName("LeetCode 49. 字母异位词分组")
class GroupAnagramsTest {

    private final GroupAnagrams solution = new GroupAnagrams();

    static Stream<Arguments> groupAnagramsCases() {
        return Stream.of(
                Arguments.of(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}, 3),
                Arguments.of(new String[]{"a"}, 1),
                Arguments.of(new String[]{""}, 1),
                Arguments.of(new String[]{"", ""}, 1),
                Arguments.of(new String[]{"abc", "bca", "cab", "xyz"}, 2),
                Arguments.of(new String[]{"aa", "aa", "b"}, 2),
                Arguments.of(new String[]{"abc", "def"}, 2),
                Arguments.of(new String[]{"ab", "ba", "abc", "cba", "ab"}, 2)
        );
    }

    @ParameterizedTest(name = "case {index}")
    @MethodSource("groupAnagramsCases")
    @DisplayName("组内互为异位词、元素不重不漏、分组数正确")
    void shouldGroupAnagrams(String[] strs, int expectedGroupCount) {
        List<List<String>> actual = solution.groupAnagrams(strs);

        assertNotNull(actual, "返回值不能为 null");
        assertEquals(expectedGroupCount, actual.size(), "分组数不对，实际分组: " + actual);

        for (List<String> group : actual) {
            assertFalse(group.isEmpty(), "不应出现空分组，实际分组: " + actual);
            String signature = signatureOf(group.get(0));
            for (String word : group) {
                assertEquals(signature, signatureOf(word),
                        "同组内必须互为异位词，违规分组: " + group);
            }
        }

        assertEquals(sortedCopyOf(strs), flattenAndSort(actual),
                "所有输入字符串必须恰好出现一次，实际分组: " + actual);
    }

    @Test
    @DisplayName("只有一个分组时，组内顺序任意但内容必须齐全")
    void shouldContainAllWordsWhenSingleGroup() {
        String[] strs = {"abc", "bca", "cab"};
        List<List<String>> actual = solution.groupAnagrams(strs);

        assertEquals(1, actual.size());
        assertEquals(sortedCopyOf(strs), flattenAndSort(actual));
    }

    /** 异位词签名：字符排序后拼回字符串。 */
    private static String signatureOf(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static List<String> sortedCopyOf(String[] strs) {
        List<String> sorted = new ArrayList<>(Arrays.asList(strs));
        Collections.sort(sorted);
        return sorted;
    }

    private static List<String> flattenAndSort(List<List<String>> groups) {
        List<String> flattened = new ArrayList<>();
        groups.forEach(flattened::addAll);
        Collections.sort(flattened);
        return flattened;
    }
}
