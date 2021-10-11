/**
 * 买卖股票
 * @author georgechou
 * @link https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BuyAndSellStock {
	public int maxProfit(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxPrice = 0;

		// 一次遍历
		for (int price : prices) {
			if (price < minPrice) {
				minPrice = price;
			} else if (price - minPrice > maxPrice) {
				maxPrice = price -minPrice;
			}
		}

		return maxPrice;
	}
}
