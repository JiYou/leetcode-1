package leetcode;

import java.util.Stack;

public class _901_StockSpanner {
	private Stack<Integer> prices, weights;

	public _901_StockSpanner() {
		prices = new Stack<>();
		weights = new Stack<>();
	}

	public int next(int price) {
		int w = 1;
		while (!prices.isEmpty() && prices.peek() < price) {
			prices.pop();
			w += weights.pop();
		}

		prices.push(price);
		weights.push(w);
		return w;
	}
}
