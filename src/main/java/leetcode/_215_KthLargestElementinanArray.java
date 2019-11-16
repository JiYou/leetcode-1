package leetcode;

import com.sun.corba.se.impl.ior.ObjectAdapterIdNumber;

import java.util.PriorityQueue;

public class _215_KthLargestElementinanArray {
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;
		int left = 0, right = nums.length - 1;
		while (true) {
			int index = partition(nums, left, right);
			if (index + 1 == k)
				return index;
			else if (index + 1 > k)
				right = index - 1;
			else
				left = index + 1;
		}
	}

	private int partition(int[] nums, int left, int right) {
		int provit = nums[left];
		int l = left + 1;
		int r = right;

		while (l <= r) {
			if (nums[l] > provit && nums[r] < provit)
				swap(nums, l++, r--);
			if (nums[l] <= provit) l++;
			if (nums[r] >= provit) r--;
		}
		swap(nums, left, r);
		return r;
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public int findKthLargest2(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int num : nums) {
			queue.offer(num);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		return queue.poll();
	}


}
