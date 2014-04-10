package chapter.two;

/**
 * Implement a function to check if a linked list is a palindrome.
 * @author jerry
 *
 */

public class Q2_7 {
	
	/**
	 * Using recursive to solve palindrome
	 * @param head
	 * @param length
	 * @return
	 */
	public static boolean isPalindrome_recursive(JNode<Integer> head, int length) {
		if (length <= 1) return true;
		
		boolean result = isPalindrome_recursive(head.next, length - 2);
		if (!result) return false;
		
		JNode<Integer> compareingIterator = head;
		while ((length - 1) > 0) {
			compareingIterator = compareingIterator.next;
			length--;
		}
		if (head.data.intValue() == compareingIterator.data.intValue()) 
			return true;
		return false;
	}
	
	
	public static JNode<Integer> isPalindrome_TwoIterator(JNode<Integer> head) {
		//Implementation
		
		return head;
	}
	
	public static int getLength(JNode<Integer> head) {
		int count = 0;
		while (head != null) {
			head = head.next;
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		JNode<Integer> head = new JNode<Integer>(new Integer(0));
		JNode<Integer> temp = head;
		temp.next = new JNode<Integer>(new Integer(1));
		temp = temp.next;
		temp.next = new JNode<Integer>(new Integer(2));
		temp = temp.next;
		temp.next = new JNode<Integer>(new Integer(2));
		temp = temp.next;
		temp.next = new JNode<Integer>(new Integer(1));
		temp = temp.next;
		temp.next = new JNode<Integer>(new Integer(0));
		
		System.out.println(isPalindrome_recursive(head, getLength(head)) ? "true" : "false");
	}
}
