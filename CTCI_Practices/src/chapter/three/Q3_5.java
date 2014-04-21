package chapter.three;

import java.util.Iterator;
import java.util.Stack;

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 * @author jerryl
 *
 */

public class Q3_5 {
	public static void main(String[] args) {
		MyQueue<Integer> myQueue = new MyQueue<Integer>();
		myQueue.offer(1);
		myQueue.offer(2);
		System.out.println(myQueue.poll());
	}
}

class MyQueue<T> {
	private Stack<T> mainStack;
	private Stack<T> shiftStack;
	
	public MyQueue() {
		mainStack = new Stack<T>();
		shiftStack = new Stack<T>();
	}
	
	/**
	 * Running Time O(1)
	 * @param item
	 * @return
	 */
	public T offer(T item) {
		return mainStack.push(item);
	}
	
	/**
	 * Running time is O(n)
	 * @return
	 */
	public T poll() {
		for (int i = 0; i < mainStack.size() - 1; i++) {
			shiftStack.push(mainStack.pop());
		}
		T result = mainStack.pop();
		
		Iterator<T> shiftItr = shiftStack.iterator();
		while (shiftItr.hasNext()) {
			mainStack.push(shiftStack.pop());
		}
		return result;
	}
}