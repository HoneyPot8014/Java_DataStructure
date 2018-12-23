package stack;

public class StackListTest {
	
	public static void main(String[] args) {
		StackList<Integer> stack = new StackList<Integer>();
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.pop();
		System.out.println(stack);
	}

}

class StackList<T> {

	private Node<T> header;
	public int size;

	public StackList() {
		header = null;
		size = 0;
	}

	public void push(T item) {
		if (size == 0) {
			Node<T> newNode = new Node<T>(item);
			header = newNode;
			size++;
			return;
		}
		Node<T> node = header;
		for (int i = 0; i < size; i++) {
			if(node.next == null) {
				Node<T> newNode = new Node<T>(item);
				node.next = newNode;
				size++;
				break;
			}
			node = node.next;
		}
	}
	
	public void pop() {
		if(size == 0) {
			return;
		}
		Node<T> node = header;
		Node<T> preNode = header;
		for(int i = 0; i < size; i++) {
			if(node.next == null) {
				preNode.next = null;
				node = null;
				size --;
				break;
			}
			preNode = node;
			node = node.next;
		}
	}
	
	@Override
	public String toString() {
		if(size == 0) {
			return "";
		}
		String result = "[";
		Node<T> node = header;
		for(int i = 0; i < size; i++) {
			result += node.item;
			if(i != size - 1) {
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
		}
	}
}
