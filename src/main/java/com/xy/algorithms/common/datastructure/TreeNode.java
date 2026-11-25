package com.xy.algorithms.common.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树节点，与 LeetCode 题目给定的 {@code TreeNode} 定义保持一致。
 *
 * <p>构造与序列化均采用 LeetCode 的层序写法，{@code null} 表示空位，
 * 例如 {@code TreeNode.of(3, 9, 20, null, null, 15, 7)}。
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 按 LeetCode 层序序列构造二叉树。
     *
     * @param values 层序节点值，{@code null} 表示该位置为空
     * @return 根节点；入参为空或首元素为 {@code null} 时返回 {@code null}
     */
    public static TreeNode of(Integer... values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(values[0]);
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int index = 1;
        while (index < values.length && !queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (index < values.length) {
                Integer leftValue = values[index++];
                if (leftValue != null) {
                    current.left = new TreeNode(leftValue);
                    queue.offer(current.left);
                }
            }
            if (index < values.length) {
                Integer rightValue = values[index++];
                if (rightValue != null) {
                    current.right = new TreeNode(rightValue);
                    queue.offer(current.right);
                }
            }
        }
        return root;
    }

    /**
     * 按 LeetCode 层序格式序列化，并去掉尾部的空位，便于测试断言。
     *
     * @return 层序节点值数组
     */
    public Integer[] toArray() {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                result.add(null);
                continue;
            }
            result.add(current.val);
            queue.offer(current.left);
            queue.offer(current.right);
        }
        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }
        return result.toArray(new Integer[0]);
    }

    @Override
    public String toString() {
        return java.util.Arrays.toString(toArray());
    }
}
