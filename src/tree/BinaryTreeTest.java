package tree;

public interface BinaryTreeTest {

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		Node<Integer> root = new Node<Integer>(0, null, null);
		Node<Integer> rootLeft = new Node<Integer>(1, null, null);
		Node<Integer> rootRight = new Node<Integer>(2, null, null);
		Node<Integer> rootLeftLeft = new Node<Integer>(3, null, null);
		Node<Integer> rootLeftRight = new Node<>(4, null, null);
		Node<Integer> rootRightLeft = new Node<>(5, null, null);
		Node<Integer> rootRightRight = new Node<>(6, null, null);
		root.setLeft(rootLeft);
		root.setRight(rootRight);
		rootLeft.setLeft(rootLeftLeft);
		rootLeft.setRight(rootLeftRight);
		rootRight.setLeft(rootRightLeft);
		rootRight.setRight(rootRightLeft);
		tree.setRoot(root);
		System.out.println("---------PREORDER------------");
		tree.preOrder(root, 0);
		System.out.println("---------INORDER-------------");
		tree.inOrder(root, 0);
		System.out.println("---------PREORDER------------");
		tree.preOrder(root, 0);
	}
}

class BinaryTree<T extends Comparable<T>> {

	private Node<T> root;

	public BinaryTree() {
		this.root = null;
	}

	public void preOrder(Node<T> node, int degree) {
		if (node != null) {
			System.out.print("degree : " + ++degree +" item : " + node.getItem() + "\n");
			if (node.getLeft() != null) {
				System.out.print("left // ");
				preOrder(node.getLeft(), degree);
			}
			if (node.getRight() != null) {
				System.out.print("right // ");
				preOrder(node.getRight(), degree);
			}
		}
	}

	public void inOrder(Node<T> node, int degree) {
		if (node != null) {
			if (node.getLeft() != null) {
				System.out.print("degree : " + degree + " left // ");
				inOrder(node.getLeft(), degree + 1);
			}
			System.out.println("degree : " + degree + " item : " + node.getItem() + " // ");
			if (node.getRight() != null) {
				System.out.print("right : ");
				inOrder(node.getRight(), degree + 1);
			}
		}
	}
	
	public void postOrder(Node<T> node, int degree) {
		if(node != null) {
			if(node.getLeft() != null) {
				System.out.print("degree" + degree + "left // ");
				postOrder(node.getLeft(), degree + 1);
			}
			if(node.getRight() != null) {
				System.out.print("degree : " + degree + "right // ");
				postOrder(node.getRight(), degree + 1);
			}
			System.out.println("degree + " + degree + "item : " + node.getItem());
		}
	}

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public Boolean isEmpty() {
		return root == null;
	}
}

class Node<T> {
	private T item;
	private Node<T> left;
	private Node<T> right;

	public Node(T item, Node<T> left, Node<T> right) {
		this.item = item;
		this.left = left;
		this.right = right;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

}
