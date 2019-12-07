package leetcode;

public class _622_MyCircularQueue {
	private int size;
	private int head;
	private int tail;
	private int[] queue;

	public _622_MyCircularQueue(int size) {
		this.size = size + 1;
		queue = new int[this.size];
	}

	public boolean isFull() {
		return (tail + 1) % size == head;
	}

	public boolean isEmpty() {
		return head == tail;
	}

	public boolean enQueue(int val) {
		if (isFull())
			return false;
		queue[tail] = val;
		tail = (tail + 1) % size;
		return true;
	}

	public boolean deQueue() {
		if (isEmpty())
			return false;
		head = (head + 1) % size;
		return true;
	}

	public int front() {
		if (isEmpty())
			return -1;
		return queue[head];
	}

	public int rear() {
		if (isEmpty())
			return -1;
		return queue[(tail - 1 + size) % size];
	}
}
