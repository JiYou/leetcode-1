package design;

public class RingBuffer {
	public final static int bufferSize = 1024;
	private String[] buffer = new String[bufferSize];
	private int head = 0;
	private int tail = 0;

	private boolean isEmpty() {
		return head == tail;
	}

	private boolean isFull() {
		return (tail + 1) % bufferSize == head;
	}

	private boolean put(String v) {
		if (isFull())
			return false;
		buffer[tail] = v;
		tail = (tail + 1) % bufferSize;
		return true;
	}

	private String get() {
		if (isEmpty())
			return null;
		String result = buffer[head];
		head = (head + 1) % bufferSize;
		return result;
	}


}
