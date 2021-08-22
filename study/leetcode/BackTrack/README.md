### 回溯算法
解决一个回溯问题，实际上就是一个决策树的遍历过程
1. 路径（已经做的选择）
2. 选择列表 （当前可以做出的选择）
3. 结束条件 （遍历到树的底层）

回溯算法的核心：
```java
    for 选择 in 选择列表:
        # 做选择
        将该选择从选择列表移除
        路径.add(选择)
        backtrack(路径, 选择列表)
        路径.remove(选择)
        将该选择再加入选择列表
```

回溯算法不像动态规划存在重叠子问题可以优化，回溯算法就是纯暴力穷举，复杂度一般都很高。

| # | Title | Solution |
|---| ----- | -------- |
| 46 | [Permutations](https://leetcode-cn.com/problems/permutations/) | [Java](https://github.com/GeorgeCh2/review-self/blob/master/study/leetcode/BackTrack/Permutations.java)|