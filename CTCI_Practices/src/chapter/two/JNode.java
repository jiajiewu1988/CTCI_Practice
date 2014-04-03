package chapter.two;

/**
 * Personally constructured node
 * @author jerry
 *
 * @param <T>
 */

public class JNode<T> {
	JNode<T> next;
	T data;
	
	public JNode(JNode<T> next1, T data) {
		this.next = next1;
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
}
