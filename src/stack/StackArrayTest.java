package stack;

public class StackArrayTest {
	
	public static void main(String[] args) {
		StackArray<Integer> stack = new StackArray<>();
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.pop();
		stack.pop();
		System.out.println(stack);
	}

}

class StackArray<T> {

	private T[] stack;
	private int topPosition;

	public StackArray() {
		stack = (T[]) new Object[1];
		topPosition = -1;
	}

	private void resize(int size) {
		T[] newArray = (T[]) new Object[size];
		if (size >= topPosition + 1) {
			for (int i = 0; i < topPosition + 1; i++) {
				newArray[i] = stack[i];
			}
		} else {
			for (int i = 0; i < size; i++) {
				newArray[i] = stack[i];
			}
		}
		stack = newArray;
	}

	public void push(T item) {
		if(topPosition <= stack.length) {
			resize(stack.length * 2);
			stack[++topPosition] = item;
			return;
		} else {
			stack[++topPosition] = item;
		}
	}
	
	public void pop() {
		if(topPosition == -1) {
			return;
		}
		stack[topPosition] = null;
		topPosition--;
	}

	@Override
	public String toString() {
		if(topPosition == -1) {
			return "";
		}
		String result = "[";
		for(int i = 0; i < topPosition + 1; i++) {
			result += stack[i];
			if(i != topPosition) {
				result += ", ";
			}
		}
		return result += "]";
	}
	
	

}
