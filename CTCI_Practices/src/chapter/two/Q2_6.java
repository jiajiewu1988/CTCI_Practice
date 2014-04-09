package chapter.two;

/**
 * Given an circular linked list, implement an algorithm which returns the node at
 * the beginning of the loop. 
 * 
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a nodes's next pointer points
 * to an earlier node, so as to make a loop in the linked list;
 * 
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * Output: C
 * 
 * 
 * @author jerry
 *
 */

public class Q2_6 {
	public static JNode<String> findLoopHead(JNode<String> head) {
		JNode<String> slowRunner = head;
		JNode<String> fastRunner = head;
		
		while (fastRunner != null && fastRunner.next != null) {
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
			if (slowRunner.equals(fastRunner)) {
				break;
			}
		}
		
		JNode<String> collisionPoint1 = slowRunner;
		JNode<String> anotherInterator = head;
		
		while (!(anotherInterator.equals(collisionPoint1))) {
			collisionPoint1 = collisionPoint1.next;
			anotherInterator = anotherInterator.next;
		}
		
		return anotherInterator;
	}
	
	public static void main(String[] args) {
		JNode<String> head = new JNode<String>("A");
		JNode<String> temp = head;
		temp.next = new JNode<String>("B");
		temp = temp.next;
		temp.next = new JNode<String>("C");
		temp = temp.next;
		JNode<String> cNode = temp;
		temp.next = new JNode<String>("D");
		temp = temp.next;
		temp.next = new JNode<String>("E");
		temp.next.next = cNode;
		
		JNode<String> loopHead = findLoopHead(head);
		System.out.println(loopHead.data);
	}
}
