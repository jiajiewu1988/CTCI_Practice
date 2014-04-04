package chapter.two;

/**
 * Implement an algorithm to delete a node in the middle of a singly linked list,
 * given only access to that node.
 * 
 * EXAMPLE
 * 
 * Input: the node c from the linked list a -> b -> c -> d -> e
 * Result: nothing is returned, but the new linked list looks like a -> b -> d -> e 
 * @author jerry
 *
 */

public class Q2_3 {
	
	/**
	 * Construct a -> b -> c -> d -> e list
	 * @return a -> b -> c -> d -> e list
	 */
	public static JNode<String> create() {
		JNode<String> head = new JNode<String>("a");
		JNode<String> temp = head;
		temp.next = new JNode<String>("b");
		temp = temp.next;
		temp.next = new JNode<String>("c");
		temp = temp.next;
		temp.next = new JNode<String>("d");
		temp = temp.next;
		temp.next = new JNode<String>("e");
		
		return head;
	}
	
	/**
	 * Remove a given node in a singly linked list
	 * @param node
	 * @return
	 */
	public static JNode<String> removeMiddle(JNode<String> node) {
		//if current node is not the tail
		if (node.next != null) {
			node.data = node.next.data;
			node.next = node.next.next;
		} else {
			//delete the tail
			node = null;
		}
		return node;
	}
	
	//Tester
	public static void main(String[] args) {
		JNode<String> head = create();
		JNode<String> middle = head.next.next;
		
		removeMiddle(middle);
		
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		
		System.out.println();
	}

}
