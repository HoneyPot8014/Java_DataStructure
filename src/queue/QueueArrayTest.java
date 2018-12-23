package queue;

public class QueueArrayTest {

	public static void main(String[] args) {
		QueueArray<Integer> queue = new QueueArray<Integer>();
		queue.add(0);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println(queue);
	}
}

class QueueArray<T> {
	private T[] queue;
	private int front;
	private int tail;
	public int size;

	public QueueArray() {
		queue = (T[]) new Object[2];
		front = 0;
		tail = 0;
		size = 0;
	}

	private void resize(int newSize) {
		T[] newQueue = (T[]) new Object[newSize];
		for (int i = 1, j = front + 1; i < size + 1; i++, j++) {
			newQueue[i] = queue[j % queue.length];
		}
		front = 0;
		tail = size;
		queue = newQueue;
	}

	public void add(T item) {
		if ((tail + 1) % queue.length == front) {
			resize(queue.length * 2);
		}
		tail = (tail + 1) % queue.length;
		queue[tail] = item;
		size++;
	}

	public T remove() {
		if (size == 0) {
			return null;
		}
		front = (front + 1) % queue.length;
		T item = queue[front];
		if (size > 0 && size <= queue.length / 4) {
			resize(queue.length / 2);
		}
		size--;
		return (item);
	}

	@Override
	public String toString() {
		if(size == 0) {
			return "";
		}
		String result = "[";
		for(int i = front + 1; i < size + 1; i ++) {
			result += queue[i % queue.length];
			if(i != size) {
				result += ", ";
			}
		}
		return result += "]";
	}

}
