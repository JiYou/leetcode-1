package leetcode;

public class _714_MaxProfit {
	public int maxProfit(int[] prices, int fee) {
		int noHold = 0, hold = -prices[0];

		for (int i = 1; i < prices.length; i++) {
			int tmp = noHold;
			noHold = Math.max(noHold, hold + prices[i] - fee);
			hold = Math.max(hold, tmp - prices[i]);
		}
		return noHold;
	}
}
