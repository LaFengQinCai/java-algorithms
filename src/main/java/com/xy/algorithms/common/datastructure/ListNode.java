package com.xy.algorithms.common.datastructure;

import java.util.StringJoiner;

/**
 * 单向链表节点，与 LeetCode 题目给定的 {@code ListNode} 定义保持一致。
 *
 * <p>工程约定：链表、树等基础数据结构全仓库只定义一次，各题解复用，不在每份题解里重复定义。
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 由 {@code int} 序列构造链表，例如 {@code ListNode.of(1, 2, 3)}。
     *
     * @param values 节点值序列
     * @return 头节点；入参为空时返回 {@code null}
     */
    public static ListNode of(int... values) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int value : values) {
            tail.next = new ListNode(value);
            tail = tail.next;
        }
        return dummy.next;
    }

    /**
     * 转为数组，便于测试断言。
     *
     * @return 从头节点开始的节点值数组
     */
    public int[] toArray() {
        int size = 0;
        for (ListNode node = this; node != null; node = node.next) {
            size++;
        }
        int[] values = new int[size];
        int index = 0;
        for (ListNode node = this; node != null; node = node.next) {
            values[index++] = node.val;
        }
        return values;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" -> ", "[", "]");
        for (ListNode node = this; node != null; node = node.next) {
            joiner.add(String.valueOf(node.val));
        }
        return joiner.toString();
    }
}
