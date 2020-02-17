import java.util.PriorityQueue;

public class Main {
	public static void main(String[] agrs) {

		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.offer(10);
		queue.offer(15);
		queue.offer(30);
		queue.offer(20);
		queue.offer(5);
	/*	System.out.println("Initial PriorityQueue: " + queue);
		System.out.println("The element at the head of the"
			+ " queue is: " + queue.poll());
		System.out.println("Final PriorityQueue: " + queue);*/


		int[] a = new int[] {5, 10, 20, 1, 15, 28};
		System.out.println("Test: " + find(a, 2));
	}

	public static int find(int[] nums, int k) {
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
