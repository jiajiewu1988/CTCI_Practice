package chapter.two;

import chapter.two.Q2_1;

/**
 * Implement an algorighm to find the kth to last element of a singly linked list
 * @author jerry
 *
 */

public class Q2_2 {	
	
	/**
	 * Use Recursion to find kth last
	 * @param head current node in the list
	 * @param position count of the node from the tail
	 * @param kth the position of the node to look for
	 * @return kth last node
	 */
	public static JNode<String> findKthLast_Recursion(JNode<String> head, IntWrapper position, int kth) {
		if (head == null) {
			return null;
		}
		
		JNode<String> node = findKthLast_Recursion(head.next, position, kth);
		position.value++;
		if (position.value == kth) return head;
		return node;
	}
	
	/**
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public static JNode<String> findKthLast_TwoIterator(JNode<String> head, int k) {
		JNode<String> node1 = head;
		JNode<String> node2 = head;
		for (int i = 0; i < k - 1; i++) {
			node2 = node2.next;
			if (node2 == null) {
				return null;
			}
		}
		
		while(node2.next != null) {
			node1 = node1.next;
			node2 = node2.next;
		}
		
		return node1;
	}
	
	//Tester
	public static void main(String[] args) {
		JNode<String> head = JList_Creator.createList();
		JNode<String> kth = findKthLast_TwoIterator(head, 2);
		System.out.println(kth.data);
	}
	
	static class IntWrapper {
		int value;
		
		public IntWrapper(int value) {
			this.value = value;
		}
	}
}
