### 动态规划
动态规划问题的一般形式就是求最值（最长递增子序列、最小编辑距离）  
求解动态规划的核心问题是穷举：
* 动态规划的穷举存在“重叠子问题”，需要“备忘录” 或 “DP table” 来优化穷举过程，避免哦不必要的计算
* 动态规划问题一定会具备 “最优子结构”
* 列出正确的 “状态转移方程”  
    明确 base case -> 明确 “状态” -> 明确 “选择” -> 定义 dp 数据/函数的定义

| # | Title | Solution |
|---| ----- | -------- |
| 509 | [Fibonacci Number](https://leetcode-cn.com/problems/fibonacci-number/) | [Java](https://github.com/GeorgeCh2/review-self/blob/master/study/leetcode/DynamicProgramming/FibonacciNumber.java)|
|322| [Coin Change](https://leetcode-cn.com/problems/coin-change/) | [Java](https://github.com/GeorgeCh2/review-self/blob/master/study/leetcode/DynamicProgramming/CoinChange.java)|