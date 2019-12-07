package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _969_PanCakeSort {

	List<Integer> list = new ArrayList<>();

	public List<Integer> pancakeSort(int[] A) {
		int max;
		for (int i = A.length - 1; i >= 0; i--) {
			max = 0;
			// 查找最大数位置
			for (int j = 0; j <= i; j++)
				max= A[max] > A[j] ? max : j;
			if (max == 0 && i != 0) // 最大数在0位置，翻转一次
				pancake(A, i);
			else if (max != i) { // 最大数不在0位置，先翻转到0位置，再翻转到目标位置。翻转两次
				pancake(A, max);
				pancake(A, i);
			}
		}
		return list;
	}

	public void pancake(int[] A, int k) {
		list.add(k + 1);
		int i = 0;
		while (k > i) {
			swap(A, i, k);
			i++;
			k--;
		}
	}

	private void swap(int[]A, int a, int b) {
		int tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}
}
