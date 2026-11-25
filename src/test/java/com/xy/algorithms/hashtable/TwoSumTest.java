package com.xy.algorithms.hashtable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * {@link TwoSum} 的单元测试。测试类与被测类同包、同名加 {@code Test} 后缀。
 */
@DisplayName("LeetCode 1. 两数之和")
class TwoSumTest {

    private final TwoSum solution = new TwoSum();

    static Stream<Arguments> twoSumCases() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1}),
                Arguments.of(new int[]{-1, -2, -3, -4, -5}, -8, new int[]{2, 4}),
                Arguments.of(new int[]{0, 4, 3, 0}, 0, new int[]{0, 3})
        );
    }

    @ParameterizedTest(name = "case {index}")
    @MethodSource("twoSumCases")
    @DisplayName("返回的下标合法、不重复，且两数之和等于 target")
    void shouldReturnValidIndices(int[] nums, int target, int[] expected) {
        int[] actual = solution.twoSum(nums, target);

        assertEquals(2, actual.length, "必须返回恰好两个下标");
        assertNotEquals(actual[0], actual[1], "同一元素不可重复使用");
        for (int index : actual) {
            assertTrue(index >= 0 && index < nums.length, "下标越界: " + index);
        }
        assertEquals(target, nums[actual[0]] + nums[actual[1]], "两数之和必须等于 target");
        assertArrayEquals(sorted(expected), sorted(actual), "返回的下标集合不符合预期");
    }

    @Test
    @DisplayName("下标顺序不限，返回 [1,0] 也算正确")
    void shouldAcceptAnyIndexOrder() {
        int[] actual = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0, 1}, sorted(actual), "实际: " + Arrays.toString(actual));
    }

    private static int[] sorted(int[] pair) {
        return new int[]{Math.min(pair[0], pair[1]), Math.max(pair[0], pair[1])};
    }
}
