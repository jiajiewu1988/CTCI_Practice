package chapter.three;

/**
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack
 * exceeds some threshold. Implement a data structure SetOfStacks that mimics
 * this. SetOfStacks should be composed of several stacks and should create a 
 * new stack once the previous one exceeds capacity. SetOfStacks.push() and 
 * SetOfStacks.pop() should behave identically to a single stack(that is, pop()
 * should return the same values as it would if there were just a single stack).
 * 
 * FOLLOW UP (Not Implemented)
 * 
 * Implement a function popAt(int index) which performs a pop operation on
 * a specific sub-stack)
 * @author jerry
 *
 */

public class Q3_3 {
	public static void main(String[] args) {
		SetOfStacks<Integer> s = new SetOfStacks<Integer>();
		s.push(new Integer(1));
		s.push(new Integer(1));
		s.push(new Integer(1));
		s.push(new Integer(1));
		s.push(new Integer(1));
		s.push(new Integer(2));
		s.push(new Integer(2));
		s.push(new Integer(2));
		s.pop();
		s.pop();
		s.pop();
		System.out.println();
	}
}

/**
 * Sets of stacks is a stack of stacks. The data of each node is a stack with maximum
 * length - 5.
 *  
 * push() calls Stack3.push() to push an element into a stack with length <= 5. Otherwise,
 * create a new stack, and push elements into the newly created stack.
 * 
 * pop() calls Stack3.pop() to pop data.
 * @author jerryl
 *
 * @param <T>
 */
class SetOfStacks<T> {
	private Node3<Stack3<T>> currentStack;
	private int currentStackLength; //suppose each stack contains no more than 5 elements
	
	public SetOfStacks() {
		currentStack = new Node3<Stack3<T>>();
		currentStack.data = new Stack3<T>();
		currentStackLength = 0;
	}
	
	public T push(T data) {
		
		if (currentStackLength < 5) {
			currentStack.data.push(data);
		} else {
			Node3<Stack3<T>> newStackNode = new Node3<Stack3<T>>();
			newStackNode.data = new Stack3<T>();
			currentStackLength = 0;
			newStackNode.data.push(data);
			newStackNode.next = currentStack;
			currentStack = newStackNode;
		}
		
		currentStackLength++;
		return data;
	}
	
	public T pop() {
		if (currentStackLength > 1) {
			currentStackLength--;
			return currentStack.data.pop();
		} else {
			if (currentStack.next == null) {
				currentStackLength = 0;
				return currentStack.data.pop();
			} else {
				T temp = currentStack.data.pop();
				currentStack = currentStack.next;
				currentStackLength = 5;
				return temp;
			}
		}
	}
}

class Stack3<T> {
	Node3<T> top;

	public void push(T data) {
		Node3<T> node = new Node3<T>(data);
		node.next = top;
		top = node;
	}
	
	public T pop() {
		if (top == null) return null;
		
		T result = top.data;
		top = top.next;
		return result;
	}
}

class Node3<T> {
	T data;
	Node3<T> next;
	
	public Node3() {}
	
	public Node3(T data) {
		this.data = data;
	}
}