package chapter.three;

/**
 * How would you design a stack which, in addition to push and pop, also has a 
 * function min which returns the minimum element? Push, pop, and min should all 
 * operate in O(1) time.
 * @author jerry
 *
 */

public class Q3_2 {
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(3);
		s.push(3);
		s.push(1);
		s.pop();
		System.out.println();
	}
}

class Stack {
	Node stackTop;
	
	public Stack() {};
	
	public void push(int num) {
		Node node = new Node(num);
		if (stackTop == null) {
			stackTop = node;
			stackTop.min = node.data;
		} else {
			if (node.data < stackTop.min) {
				node.min = node.data;
			}
			node.min = stackTop.min;
			node.next = stackTop;
			stackTop = node;
		}
	}
	
	public Node pop() {
		if (stackTop == null) {
			return null;
		} else if (stackTop.next == null) {
			Node temp = new Node(stackTop.data);
			temp.min = stackTop.min;
			stackTop = null;
			return temp;
		} else {
			Node temp = stackTop;
			stackTop = stackTop.next;
			return temp;
		}
	}
	
	public int min() {
		return stackTop.min;
	}
}

class Node {
	int data;
	int min;
	Node next;
	
	public Node() {}
	
	public Node(int data) {
		this.data = data;
		this.min = 0;
	}
}
