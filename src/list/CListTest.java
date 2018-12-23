package list;

public class CListTest {

	public static void main(String[] args) {
		CList<Integer> cList = new CList<>();
		cList.add(0);
		cList.add(1);
		cList.add(2);
		cList.delete();

		System.out.println(cList);
		System.out.println("-------size-------");
		System.out.println(cList.size);
	}
}

class CList<T> {

	private Node<T> last;
	public int size;

	public CList() {
		last = null;
		size = 0;
	}

	public void add(T item) {
		Node<T> newNode = new Node<T>(item);
		if (last == null) {
			newNode.next = newNode;
			last = newNode;
			size++;
			return;
		}
		Node<T> node = last;
		for (int i = 0; i < size; i++) {
			if (node.next == last) {
				node.next = newNode;
				newNode.next = last;
				size++;
				break;
			}
			node = node.next;
		}
	}

	public void delete() {
		if (last == null) {
			return;
		}
		Node<T> node = last;
		Node<T> preNode = last;
		for (int i = 0; i < size; i++) {
			if (node.next == last) {
				preNode.next = last;
				size--;
				break;
			}
			preNode = node;
			node = node.next;
		}
	}

	@Override
	public String toString() {
		String result = "[";
		Node<T> node = last;
		for (int i = 0; i < size; i++) {
			result += node.item;
			if (i != size - 1) {
				result += ", ";
			}
			node = node.next;
		}
		return result += "]";
	}

	class Node<T> {
		private T item;
		private Node<T> next;

		public Node(T itme) {
			this.item = itme;
			next = null;
		}
	}
}
