package list;

public class SListTest {

	public static void main(String[] args) {
		SList<Integer> sList = new SList<>();
		sList.add(1);
		sList.addLast(2);
		sList.addFirst(5);
		sList.deleteFirst();
		sList.delete(0);
		sList.add(7);
		sList.delete(0);
		sList.addLast(10);
		sList.addFirst(5);
		sList.deleteLast();
		for (int i = 0; i < sList.size; i++) {
			System.out.println(sList.get(i));
		}
	}
}

class SList<T> {

	private Node<T> header;
	public int size;

	public SList() {
		header = null;
		size = 0;
	}

	public T get(int index) {
		if (index == 0) {
			return header.item;
		} else {
			Node<T> node = header;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node.item;
		}
	}

	public void add(T item) {
		if (header == null) {
			header = new Node<T>(item);
			size++;
			return;
		}

		Node<T> node = header;
		for (int i = 0; i < size; i++) {
			if (node.next == null) {
				node.next = new Node<T>(item);
				size++;
				break;
			}
			node = node.next;
		}
	}

	public void addFirst(T item) {
		Node<T> newItem = new Node<T>(item);
		newItem.next = header;
		header = newItem;
		size++;
	}

	public void addLast(T item) {
		Node<T> node = header;
		for (int i = 0; i < size; i++) {
			if (node.next == null) {
				node.next = new Node<T>(item);
				size++;
				break;
			}
			node = node.next;
		}
	}

	public void deleteFirst() {
		header = header.next;
		size--;
	}

	public void delete(int index) {
		if (index == 0) {
			deleteFirst();
			return;
		}
		Node<T> node = header;
		Node<T> preNode = null;
		for (int i = 0; i < index; i++) {
			preNode = node;
			node = node.next;
		}
		preNode.next = node.next;
		size--;
	}

	public void deleteLast() {
		Node<T> node = header;
		Node<T> preNode = null;
		for (int i = 0; i < size; i++) {
			if (node.next == null) {
				node = null;
				preNode.next = null;
				size --;
				break;
			}
			preNode = node;
			node = node.next;
		}
	}

	class Node<T> {
		T item;
		Node<T> next;

		public Node(T item) {
			this.item = item;
			next = null;
		}
	}

}
