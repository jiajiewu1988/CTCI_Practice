package chapter.two;

public class JList<T> {
	class Node {
		Node next = null;
		T data;
		
		public Node(T data) {
			this.data = data;
		}
		
		public T getData() {
			return data;
		}
	}
}
