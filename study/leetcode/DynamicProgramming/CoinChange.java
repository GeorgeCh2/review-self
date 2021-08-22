class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // dp table
        int[] dp = new int[amount + 1];
        // 即使只存在面额为1的硬币，硬币最多也不会超过 amount
        Arrays.fill(dp, amount + 1);

        // basecase
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }

                // 子问题
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}