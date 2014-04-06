package chapter.two;

/**
 * You have two numbers represented by a linked list, where each node contains a 
 * single digit. The digits are stored in reverse order, such that the 1's digit is at the 
 * head of the list. Write a function that adds the two numbers and returns the sum
 * as a linked list.
 * 
 * EXAMPLE
 * 
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is , 617 + 295
 * Output: 2 -> 1 -> 9. That is 912
 * 
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * 
 * EXAMPLE
 * 
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295.
 * Output: 9 -> 1 -> 2. That is 912
 * 
 * @author jerry
 *
 */

public class Q2_5 {
	
	/**
	 * Iterates each linked list at the same speed, use a int carry to store the carry number.
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static JNode<Integer> addReverseList(JNode<Integer> n1, JNode<Integer> n2) {
		int carry = 0;
		JNode<Integer> sumHead = null;
		JNode<Integer> sumEnd = sumHead;
		
		while (n1 != null || n2 != null) {
			if (n1 == null) {
				sumEnd.next = new JNode<Integer>(new Integer(n2.data.intValue() + carry));
				sumEnd = sumEnd.next;
				n2 = n2.next;
				carry = 0;
			} else if (n2 == null) {
				sumEnd.next = new JNode<Integer>(new Integer(n1.data.intValue() + carry));
				sumEnd = sumEnd.next;
				n1 = n1.next;
				carry = 0;
			} else {
				int tempSum = n1.data.intValue() + n2.data.intValue() + carry;
				carry = tempSum / 10;
				tempSum = tempSum % 10;
				if (sumHead == null) {
					sumHead = new JNode<Integer>(tempSum);
					sumEnd = sumHead;
				} else {
					sumEnd.next = new JNode<Integer>(tempSum);
					sumEnd = sumEnd.next;
				}
				n1 = n1.next;
				n2 = n2.next;
			}
		}
		
		return sumHead;
	}
	
	//Tester
	public static void main(String[] args) {
		JNode<Integer> n1 = new JNode<Integer>(7);
		JNode<Integer> temp = n1;
		temp.next = new JNode<Integer>(1);
		temp = temp.next;
		temp.next = new JNode<Integer>(6);
		
		JNode<Integer> n2 = new JNode<Integer>(5);
		temp = n2;
		temp.next = new JNode<Integer>(9);
		temp = temp.next;
		temp.next = new JNode<Integer>(2);
		
		JNode<Integer> sum = addReverseList(n1, n2);
		while (sum != null) {
			System.out.print(sum.data.intValue() + "->");
			sum = sum.next;
		}
		System.out.print("null\n");
	}
}
