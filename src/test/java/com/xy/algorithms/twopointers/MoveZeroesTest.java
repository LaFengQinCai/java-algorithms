package com.xy.algorithms.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * {@link MoveZeroes} 的单元测试。原地修改类题目：调用后断言入参数组本身。
 */
@DisplayName("LeetCode 283. 移动零")
class MoveZeroesTest {

    private final MoveZeroes solution = new MoveZeroes();

    static Stream<Arguments> moveZeroesCases() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}),
                Arguments.of(new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{0, 0, 0}, new int[]{0, 0, 0}),
                Arguments.of(new int[]{1, 0, 0, 2, 5}, new int[]{1, 2, 5, 0, 0}),
                Arguments.of(new int[]{-1, 0, -2, 0}, new int[]{-1, -2, 0, 0})
        );
    }

    @ParameterizedTest(name = "case {index}")
    @MethodSource("moveZeroesCases")
    @DisplayName("零全部靠后，非零元素相对顺序不变")
    void shouldMoveZeroesToEnd(int[] nums, int[] expected) {
        solution.moveZeroes(nums);
        assertArrayEquals(expected, nums, "实际: " + Arrays.toString(nums));
    }

    @Test
    @DisplayName("单个非零元素保持不变")
    void shouldKeepSingleNonZeroElement() {
        int[] nums = {7};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{7}, nums);
    }
}
