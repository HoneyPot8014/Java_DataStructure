package list;

public class DListTest {

	public static void main(String[] args) {
		DList<Integer> dList = new DList<>();
		dList.add(0);
		dList.add(1);
		dList.addLast(5);
		dList.add(2);
		dList.addFirst(3);
		dList.add(4, 3);
		dList.delete(1);
		dList.deleteFirst();
		dList.deleteLast();
		for (int i = 0; i < dList.size; i++) {
			System.out.println(dList.get(i));
		}
		System.out.println("--------------size---------------");
		System.out.println(dList.size);
	}

}

class DList<T> {

	Node<T> header;
	int size;

	public T get(int index) {
		Node<T> node = header;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node.item;
	}

	public void add(T item) {
		if (size == 0) {
			header = new Node<T>(item);
			size++;
			return;
		}
		Node<T> node = header;
		Node<T> preNode = header;
		for (int i = 0; i < size; i++) {
			preNode = node;
			if (node.next == null) {
				Node<T> newNode = new Node<T>(item);
				node.next = newNode;
				preNode.pre = preNode;
				size++;
				break;
			}
			node = node.next;
		}
	}

	public void add(T item, int index) {
		if (size == 0) {
			header = new Node<T>(item);
			size++;
			return;
		}
		Node<T> node = header;
		Node<T> preNode = header;
		for (int i = 0; i < index; i++) {
			preNode = node;
			node = node.next;
		}
		Node<T> newNode = new Node<T>(item);
		preNode.next = newNode;
		newNode.next = node;
		newNode.pre = preNode;
		size++;
	}

	public void addFirst(T item) {
		Node<T> newNode = new Node<T>(item);
		newNode.next = header;
		header.pre = newNode;
		header = newNode;
		size++;
	}

	public void addLast(T item) {
		Node<T> node = header;
		for (int i = 0; i < size; i++) {
			if (node.next == null) {
				Node<T> newNode = new Node<T>(item);
				node.next = newNode;
				newNode.pre = node;
				size++;
				break;
			}
			node = node.next;
		}
	}

	public void delete(int index) {
		if (index == 0) {
			header = header.next;
		}
		Node<T> node = header;
		Node<T> preNode = header;
		for (int i = 0; i < index; i++) {
			preNode = node;
			node = node.next;
		}
		preNode.next = node.next;
		size--;
	}

	public void deleteFirst() {
		if (header != null) {
			header = header.next;
			header.pre = null;
			size--;
		}
	}

	public void deleteLast() {
		Node<T> node = header;
		Node<T> preNode = header;
		for (int i = 0; i < size; i++) {
			if (node.next == null) {
				preNode.next = null;
				node = null;
				size--;
				return;
			}
			preNode = node;
			node = node.next;
		}
	}

	class Node<T> {
		private T item;
		private Node<T> pre;
		private Node<T> next;

		public Node(T item) {
			this.item = item;
			this.pre = null;
			this.next = null;
		}
	}
}
