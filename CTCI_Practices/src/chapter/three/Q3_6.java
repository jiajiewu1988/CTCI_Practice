package chapter.three;

import java.util.Stack;

/**
 * Write a program to sort a stack in ascending order (with biggest items on top).
 * You may use additional stacks to hold items, but you may not copy the elements
 * into any other data structure (such as an array). The stack supports the following
 * operations: push, pop, peek, and isEmpty
 * @author jerryl
 *
 */

public class Q3_6 {
	
	public static Stack<Integer> sortStack(Stack<Integer> originalStack) {
		Stack<Integer> finalStack = new Stack<Integer>();
		while (!originalStack.empty()) {
			int temp = originalStack.pop().intValue();
			if (finalStack.empty()) {
				finalStack.push(temp);
			} else {
				int count = 0;
				while (!finalStack.empty()) {
					if (temp > finalStack.peek()) {
						break;
					}
					originalStack.push(finalStack.pop());
					count++;
				}
				finalStack.push(temp);
				while (count-- > 0) {
					finalStack.push(originalStack.pop());
				}
			}
		}
		return finalStack;
	}
	
	//Tester
	public static void main(String[] args) {
		Stack<Integer> s1 = new Stack<Integer>();
		
		s1.push(1);
		s1.push(3);
		s1.push(2);
		s1.push(54);
		s1.push(33);
		
		Stack<Integer> s2 = sortStack(s1);
		System.out.println();
	}
	
	
}
