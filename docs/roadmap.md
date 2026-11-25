# Hot 100 路线图

> 按 LeetCode 热题 100 的 17 个官方专题分组，顺序即建议刷题顺序。
> 刷完一题把 `[ ]` 改成 `[x]`，并在题目后面用「——」补一句核心思想（≤12 字）。
> 二刷时只看本清单的核心思想就能回忆解法；题解类名不带题号前缀，题号只在这里和 Javadoc 出现。
> 官方题单若增删，直接在对应专题追加或删除条目。

**进度：3 / 99**（已完成 / 清单条目）

---

## 1. 哈希表 · `com.xy.algorithms.hashtable`

- [x] `TwoSum` · 1. 两数之和 —— 边查边存，用 Map 把「找配对」降到 O(1)
- [x] `GroupAnagrams` · 49. 字母异位词分组 —— 排序后的串做指纹当 key，一次遍历按指纹归组
- [ ] `LongestConsecutiveSequence` · 128. 最长连续序列

## 2. 双指针 · `com.xy.algorithms.twopointers`

- [x] `MoveZeroes` · 283. 移动零 —— 慢指针 + 零计数器，非零元素按序前移，尾部补零
- [ ] `ContainerWithMostWater` · 11. 盛最多水的容器
- [ ] `ThreeSum` · 15. 三数之和
- [ ] `TrappingRainWater` · 42. 接雨水

## 3. 滑动窗口 · `com.xy.algorithms.slidingwindow`

- [ ] `LongestSubstringWithoutRepeatingCharacters` · 3. 无重复字符的最长子串
- [ ] `FindAllAnagramsInAString` · 438. 找到字符串中所有字母异位词

## 4. 子串 · `com.xy.algorithms.substring`

- [ ] `SubarraySumEqualsK` · 560. 和为 K 的子数组
- [ ] `SlidingWindowMaximum` · 239. 滑动窗口最大值
- [ ] `MinimumWindowSubstring` · 76. 最小覆盖子串

## 5. 普通数组 · `com.xy.algorithms.array`

- [ ] `MaximumSubarray` · 53. 最大子数组和
- [ ] `MergeIntervals` · 56. 合并区间
- [ ] `RotateArray` · 189. 轮转数组
- [ ] `ProductOfArrayExceptSelf` · 238. 除自身以外数组的乘积
- [ ] `FirstMissingPositive` · 41. 缺失的第一个正数

## 6. 矩阵 · `com.xy.algorithms.matrix`

- [ ] `SetMatrixZeroes` · 73. 矩阵置零
- [ ] `SpiralMatrix` · 54. 螺旋矩阵
- [ ] `RotateImage` · 48. 旋转图像
- [ ] `SearchMatrixII` · 240. 搜索二维矩阵 II

## 7. 链表 · `com.xy.algorithms.linkedlist`

- [ ] `IntersectionOfTwoLinkedLists` · 160. 相交链表
- [ ] `ReverseLinkedList` · 206. 反转链表
- [ ] `PalindromeLinkedList` · 234. 回文链表
- [ ] `LinkedListCycle` · 141. 环形链表
- [ ] `LinkedListCycleII` · 142. 环形链表 II
- [ ] `MergeTwoSortedLists` · 21. 合并两个有序链表
- [ ] `AddTwoNumbers` · 2. 两数相加
- [ ] `RemoveNthNodeFromEnd` · 19. 删除链表的倒数第 N 个结点
- [ ] `SwapNodesInPairs` · 24. 两两交换链表中的节点
- [ ] `ReverseNodesInKGroup` · 25. K 个一组翻转链表
- [ ] `CopyListWithRandomPointer` · 138. 随机链表的复制
- [ ] `SortList` · 148. 排序链表
- [ ] `MergeKSortedLists` · 23. 合并 K 个升序链表
- [ ] `LruCache` · 146. LRU 缓存

## 8. 二叉树 · `com.xy.algorithms.binarytree`

- [ ] `BinaryTreeInorderTraversal` · 94. 二叉树的中序遍历
- [ ] `MaximumDepthOfBinaryTree` · 104. 二叉树的最大深度
- [ ] `InvertBinaryTree` · 226. 翻转二叉树
- [ ] `SymmetricTree` · 101. 对称二叉树
- [ ] `DiameterOfBinaryTree` · 543. 二叉树的直径
- [ ] `BinaryTreeLevelOrderTraversal` · 102. 二叉树的层序遍历
- [ ] `ConvertSortedArrayToBst` · 108. 将有序数组转换为二叉搜索树
- [ ] `ValidateBinarySearchTree` · 98. 验证二叉搜索树
- [ ] `KthSmallestElementInBst` · 230. 二叉搜索树中第 K 小的元素
- [ ] `BinaryTreeRightSideView` · 199. 二叉树的右视图
- [ ] `FlattenBinaryTreeToLinkedList` · 114. 二叉树展开为链表
- [ ] `ConstructTreeFromPreorderAndInorder` · 105. 从前序与中序遍历序列构造二叉树
- [ ] `PathSumIII` · 437. 路径总和 III
- [ ] `LowestCommonAncestorOfBinaryTree` · 236. 二叉树的最近公共祖先
- [ ] `BinaryTreeMaximumPathSum` · 124. 二叉树中的最大路径和

## 9. 图论 · `com.xy.algorithms.graph`

- [ ] `NumberOfIslands` · 200. 岛屿数量
- [ ] `RottingOranges` · 994. 腐烂的橘子
- [ ] `CourseSchedule` · 207. 课程表
- [ ] `ImplementTrie` · 208. 实现 Trie（前缀树）

## 10. 回溯 · `com.xy.algorithms.backtracking`

- [ ] `Permutations` · 46. 全排列
- [ ] `Subsets` · 78. 子集
- [ ] `LetterCombinationsOfPhoneNumber` · 17. 电话号码的字母组合
- [ ] `CombinationSum` · 39. 组合总和
- [ ] `GenerateParentheses` · 22. 括号生成
- [ ] `WordSearch` · 79. 单词搜索
- [ ] `PalindromePartitioning` · 131. 分割回文串
- [ ] `NQueens` · 51. N 皇后

## 11. 二分查找 · `com.xy.algorithms.binarysearch`

- [ ] `SearchInsertPosition` · 35. 搜索插入位置
- [ ] `SearchMatrix` · 74. 搜索二维矩阵
- [ ] `FindFirstAndLastPosition` · 34. 在排序数组中查找元素的第一个和最后一个位置
- [ ] `SearchInRotatedSortedArray` · 33. 搜索旋转排序数组
- [ ] `FindMinimumInRotatedSortedArray` · 153. 寻找旋转排序数组中的最小值
- [ ] `MedianOfTwoSortedArrays` · 4. 寻找两个正序数组的中位数

## 12. 栈 · `com.xy.algorithms.stack`

- [ ] `ValidParentheses` · 20. 有效的括号
- [ ] `MinStack` · 155. 最小栈
- [ ] `DecodeString` · 394. 字符串解码
- [ ] `DailyTemperatures` · 739. 每日温度
- [ ] `LargestRectangleInHistogram` · 84. 柱状图中最大的矩形

## 13. 堆 · `com.xy.algorithms.heap`

- [ ] `KthLargestElementInArray` · 215. 数组中的第 K 个最大元素
- [ ] `TopKFrequentElements` · 347. 前 K 个高频元素
- [ ] `FindMedianFromDataStream` · 295. 数据流的中位数

## 14. 贪心算法 · `com.xy.algorithms.greedy`

- [ ] `BestTimeToBuyAndSellStock` · 121. 买卖股票的最佳时机
- [ ] `JumpGame` · 55. 跳跃游戏
- [ ] `JumpGameII` · 45. 跳跃游戏 II
- [ ] `PartitionLabels` · 763. 划分字母区间

## 15. 动态规划 · `com.xy.algorithms.dynamicprogramming`

- [ ] `ClimbingStairs` · 70. 爬楼梯
- [ ] `PascalsTriangle` · 118. 杨辉三角
- [ ] `HouseRobber` · 198. 打家劫舍
- [ ] `PerfectSquares` · 279. 完全平方数
- [ ] `CoinChange` · 322. 零钱兑换
- [ ] `WordBreak` · 139. 单词拆分
- [ ] `LongestIncreasingSubsequence` · 300. 最长递增子序列
- [ ] `MaximumProductSubarray` · 152. 乘积最大子数组
- [ ] `PartitionEqualSubsetSum` · 416. 分割等和子集

## 16. 多维动态规划 · `com.xy.algorithms.dynamicprogramming.multidimensional`

- [ ] `UniquePaths` · 62. 不同路径
- [ ] `MinimumPathSum` · 64. 最小路径和
- [ ] `LongestPalindromicSubstring` · 5. 最长回文子串
- [ ] `LongestCommonSubsequence` · 1143. 最长公共子序列
- [ ] `EditDistance` · 72. 编辑距离

## 17. 技巧 · `com.xy.algorithms.technique`

- [ ] `SingleNumber` · 136. 只出现一次的数字
- [ ] `MajorityElement` · 169. 多数元素
- [ ] `SortColors` · 75. 颜色分类
- [ ] `NextPermutation` · 31. 下一个排列
- [ ] `FindTheDuplicateNumber` · 287. 寻找重复数
