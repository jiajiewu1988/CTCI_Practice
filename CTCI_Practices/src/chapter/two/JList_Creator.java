package chapter.two;

/**
 * For Creating a "FOLLOW UP" list for other questions
 * @author jerry
 *
 * @param <T>
 */

public class JList_Creator {
	private static JNode<String> head;
	
	public static JNode<String> createList() {
		head = new JNode<String>(null, "F");
		JNode<String> temp = head;
		temp.next = new JNode<String>(null, "O");
		temp = temp.next;
		temp.next = new JNode<String>(null, "L");
		temp = temp.next;
		temp.next = new JNode<String>(null, "L");
		temp = temp.next;
		temp.next = new JNode<String>(null, "O");
		temp = temp.next;
		temp.next = new JNode<String>(null, "W");
		temp = temp.next;
		temp.next = new JNode<String>(null, " ");
		temp = temp.next;
		temp.next = new JNode<String>(null, "U");
		temp = temp.next;
		temp.next = new JNode<String>(null, "P");
		temp = temp.next;
		
		return head;
	}
}
