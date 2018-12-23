package queue;

public class QueueListTest {

	public static void main(String[] args) {
		QueueList<Integer> queue = new QueueList<Integer>();
		queue.add(0);
		queue.add(1);
		queue.add(2);
		queue.remove();
		System.out.println(queue);
	}
}

class QueueList<T> {

	private Node<T> header;
	private Node<T> tail;
	private int size;


	public QueueList() {
		this.header = null;
		this.size = 0;
	}

	public void add(T item) {
		Node<T> newNode = new Node<T>(item);
		if (header == null) {
			header = newNode;
			tail = newNode;
			size++;
			return;
		}
		tail.next = newNode;
		tail = newNode;
		size++;
	}
	
	public T remove() {
		if(size == 0) {
			return null;
		}
		T item = header.item;
		header = header.next;
		size --;
		return item;
	}
	
	@Override
	public String toString() {
		if (size == 0) {
			return "";
		}
		String result = "[";
		Node<T> node = header;
		for(int i = 0; i < size; i++) {
			result += node.item;
			if(node.next != null) {
				result += ", ";
			}
			node = node.next;
		}
		return result += "]";
	}

	class Node<T> {
		private T item;
		private Node<T> next;

		public Node(T item) {
			this.item = item;
			this.next = null;
		}
	}
}
