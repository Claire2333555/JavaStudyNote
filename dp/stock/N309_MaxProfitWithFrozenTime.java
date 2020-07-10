class N309_MaxProfitWithFrozenTime {
	public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
		int len = prices.length;
		int[][] dp = new int[len][3];
		dp[0][0] = -prices[0];
		dp[0][1] = 0;
		dp[0][2] = Integer.MIN_VALUE;
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
			dp[i][2] = dp[i - 1][0] + prices[i];
		}
		return Math.max(dp[len - 1][1], dp[len - 1][2]);
	}
}