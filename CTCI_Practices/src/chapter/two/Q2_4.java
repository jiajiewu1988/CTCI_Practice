package chapter.two;

import chapter.two.JList_Creator;

/**
 * Write code to partition a linked list around a value x, such that all nodes less than
 * x come before all nodes greater than or equal to x
 * @author jerry
 *
 */

public class Q2_4 {
	
	/**
	 * To Create two separate linked lists
	 *   - one contains nodes <= x
	 *   - one contains nodes > x
	 * 
	 * At the end, append the head of the great list to the tail of the small list
	 * @param head
	 * @param x
	 * @return
	 */
	public static JNode<String> partition(JNode<String> head, String x) {
		JNode<String> smaller = null, greater = null, smallHead = null, greatHead = null;
		
		while (head != null) {
			if (head.data.compareToIgnoreCase(x) <= 0) {
				if (smallHead == null) {
					smallHead = head;
					smaller = smallHead;
				} else {
					smaller.next = head;
					smaller = smaller.next;
				}
			} else {
				if (greatHead == null) {
					greatHead = head;
					greater = greatHead;
				} else {
					greater.next = head;
					greater = greater.next;
				}
			}
			head = head.next;
		}
		
		if (smallHead == null) {
			return greatHead;
		} else {
			smaller.next = greatHead;
			return smallHead;
		}
	}
	
	//Tester
	public static void main(String[] args) {
		JNode<String> head = JList_Creator.createList();
		JNode<String> partitionNode = partition(head, "l");
		
		while (partitionNode != null) {
			System.out.print(partitionNode.data + ",");
			partitionNode = partitionNode.next;
		}
		
		System.out.println();
	}
}
