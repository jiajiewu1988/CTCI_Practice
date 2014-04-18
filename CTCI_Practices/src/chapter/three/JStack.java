package chapter.three;

public class JStack<T> {
	class Node<T> {
		Node<T> next;
		T data;
		
		Node(T data) {
			this.data = data;
		}
	}
	
	Node<T> top;
	
	public void push(T data) {
		if (top == null) {
			top = new Node<T>(data);
		} else {
			Node<T> newTop = new Node<T>(data);
			newTop.next = top;
			top = newTop;
		}
	}
	
	public Node<T> pop() {
		Node<T> popNode = top;
		if (popNode == null) 
			return null;
		else {
			top = top.next;
		}
		return popNode;
	}
	
	public T peek() {
		if (top == null) 
			return null;
		else 
			return top.data;
	}
}
