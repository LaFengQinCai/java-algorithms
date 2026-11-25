# java-algorithms

LeetCode 刷题仓库，按企业项目规范组织代码：Java 21 + Maven + JUnit 5。
目标是在刷题过程中同时沉淀**算法思想**与**Java 工程习惯**（面向 Java 后端 + Agent 方向面试）。

---

## 1. 目录结构

```
java-algorithms
├── pom.xml                     构建描述
├── .editorconfig               统一编码/缩进/换行
├── README.md                   工程约定（本文件）
├── docs/
│   └── roadmap.md              Hot 100 路线图与打卡清单
└── src
    ├── main/java/com/xy/algorithms
    │   ├── common/datastructure    ListNode / TreeNode 等基础结构，全仓库唯一来源
    │   ├── hashtable               哈希表
    │   ├── twopointers             双指针
    │   ├── slidingwindow           滑动窗口
    │   ├── substring               子串
    │   ├── array                   普通数组
    │   ├── matrix                  矩阵
    │   ├── linkedlist              链表
    │   ├── binarytree              二叉树
    │   ├── graph                   图论
    │   ├── backtracking            回溯
    │   ├── binarysearch            二分查找
    │   ├── stack                   栈
    │   ├── heap                    堆
    │   ├── greedy                  贪心算法
    │   ├── dynamicprogramming      动态规划
    │   │   └── multidimensional    多维动态规划
    │   └── technique               技巧
    └── test/java/com/xy/algorithms 与 main 一一对应（不新建目录层级）
```

---

## 2. 命名规范

| 元素 | 规范 | 反例 | 正例 |
| --- | --- | --- | --- |
| 根包 | 反向域名 + 项目名，全小写 | `org.example`、`leetcode` | `com.xy.algorithms` |
| 分类包 | 全小写、单数名词，不用连字符/下划线/数字 | `two_pointers`、`DP`、`topic1` | `twopointers`、`dynamicprogramming` |
| 题解类 | PascalCase，用题目的英文名描述职责，**不加题号前缀** | `P0001TwoSum`、`LC1`、`Solution1` | `TwoSum`、`GroupAnagrams` |
| 公共结构类 | PascalCase，与 LC 给定定义同名 | `Node1`、`MyTree` | `ListNode`、`TreeNode` |
| 方法 | camelCase，动词开头，与题面方法签名保持一致 | `doIt`、`f`、`calc` | `twoSum`、`mergeTwoLists` |
| 变量/字段 | camelCase，语义完整，避免 `a`/`b`/`tmp1` | `res`、`m` | `left`、`indexByValue` |
| 常量/不可变集合 | `UPPER_SNAKE_CASE` | `maxLen` | `MAX_CAPACITY` |
| 测试类 | 被测类名 + `Test`，与被测类**同包** | `TestTwoSum`、`TwoSumTestcase` | `TwoSumTest` |
| 测试方法 | `should` + 被测行为，中文意图放 `@DisplayName` | `test1`、`caseA` | `shouldReturnValidIndices` |
| 题号 | 只出现在 Javadoc 与 `docs/roadmap.md` | 类名里写 `P0001` | `LeetCode 1. 两数之和` |
| 文档 | 小写 kebab-case | `RoadMap.md`、`热度100.md` | `roadmap.md` |

> 核心取舍：**类名描述职责，题号交给文档**。这样二刷时按类名就能回忆起解法，而不是先背编号。

---

## 3. 单题标准结构

主类（`src/main/java/com/xy/algorithms/<分类>/<题目>.java`）：

```java
package com.xy.algorithms.hashtable;

/**
 * LeetCode 1. 两数之和 —— Hot 100 · 哈希表。
 *
 * <p>题目：给定 nums 与 target，返回和为 target 的两个下标（唯一解，元素不可复用）。
 * <p>约束：2 <= nums.length <= 10^4；-10^9 <= nums[i], target <= 10^9。
 * <p>目标复杂度：时间 O(n)，空间 O(n)。
 * <p>思路：
 * <p>踩坑记录：
 *
 * @see <a href="https://leetcode.cn/problems/two-sum/">LeetCode 1. 两数之和</a>
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // 实现
    }

    /** 本地快速验证入口；正式验证以 TwoSumTest 为准。 */
    public static void main(String[] args) {
        // 样例
    }
}
```

测试类（`src/test/java/com/xy/algorithms/<分类>/<题目>Test.java`）必须覆盖：

- 题目样例 1 组
- 边界：空/单元素/全相同/极值（`Integer.MAX_VALUE`、溢出场景）
- 结果顺序无关时用集合或排序后断言，不要依赖返回顺序

Javadoc 的「思路」「踩坑记录」在 AC 之后必须补完——这是二刷和面试复述的唯一依赖。

---

## 4. 运行与验证

```bash
mvn -B test                                     # 全量
mvn -B -Dtest=TwoSumTest test                   # 单题
mvn -B -Dtest=TwoSumTest#shouldReturnValidIndices test   # 单个用例
```

Windows 控制台中文乱码时，先执行一次（只影响当前终端；IntelliJ 内置运行不需要）：

```powershell
$env:MAVEN_OPTS='-Dstdout.encoding=UTF-8 -Dstderr.encoding=UTF-8'
```

IDE 里也可以直接 run `main` 方法随手验样例。改完代码记得让 IDE 重新加载 Maven 项目（右侧 Maven 面板 → Reload）。

---

## 5. 提交规范

采用 Conventional Commits，type 取 `feat|fix|test|docs|refactor`，scope 用分类包名：

```
feat(hashtable): two-sum 哈希表一次遍历 O(n)
fix(linkedlist): 修正入环点计算，快慢指针相遇后再同速走
test(binarytree): 补充空树与单节点用例
docs(roadmap): 勾选二叉树专题 15 题
```

一次提交只做一件事：新题解、补测试、补文档分开提交，方便日后 `git log --oneline -- <分类>` 复盘。

---

## 6. 刷题流程（每题固定 6 步）

1. 读题，先不动键盘，纸上写 3 分钟思路（用什么结构、核心不变量是什么）。
2. 卡住就提问，按「提示阶梯」给：先问方向 → 再给关键不变量 → 最后才给代码。
3. 写实现，跑 `mvn -Dtest=XxxTest test` 到绿灯。
4. Code review：边界、命名、复杂度、Java 惯用法（`Map.computeIfAbsent`、`ArrayDeque` 代替 `Stack`、`record`、`switch` 模式匹配等）。
5. 补 Javadoc：思路 / 复杂度 / 踩坑。
6. 勾选 `docs/roadmap.md`，提交。

复习节奏：当天 + 24 小时 + 7 天 + 21 天。二刷仍卡住的题，在 Javadoc「踩坑记录」里写清卡在哪一步。
