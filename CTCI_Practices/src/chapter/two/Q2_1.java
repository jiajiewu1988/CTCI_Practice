package chapter.two;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import chapter.two.JList_Creator;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * 
 * FOLLOW UP
 * 
 * How would you solve this problem if a temporary buffer is not allowed?
 * 
 * 
 * Keys: 
 * 1. Temporary Buffer - HashTable 
 * 	This runs in O(n) time, and O(n) space
 * 
 * 
 * 2. No Temporary Buffer - Two iterators, when one stops at one character, another check for the rest of
 * the linked list.
 * @author jerry
 *
 */

public class Q2_1 {
	 //Create the "FOLLOW UP" linked list
	private static LinkedList<String> list = new LinkedList<String>();
	
	/**
	 * Using additional buffer - hash table to check duplicates
	 * Time - O(n)
	 * Space - O(n)
	 */
	public static void removeDuplicates_Hashtable() {
		createList();
		Hashtable<String, String> check = new Hashtable<String, String>();
		Iterator<String> itr = list.iterator();
		
		while (itr.hasNext()) {
			String s = itr.next();
			if (check.contains(s)) {
				itr.remove();
			} else {
				check.put(s, s);
			}
		}
		
		itr = list.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next());
		}
	}
	
	/**
	 * Use Two Iterators to solve this problem
	 */
	public static JNode<String> removeDuplicates_TwoIterator() {
		JNode<String> head = JList_Creator.createList();
		JNode<String> node = head;
		while (node.next != null) {
			JNode<String> temp = node.next;
			
			while (temp.next != null) {
				if (temp.getData().equals(node.getData())) {
					temp.data = temp.next.data;
					temp.next = temp.next.next;
				} else {
					temp = temp.next;
				}
			}
			
			node = node.next;
		}
		return head;
	}
	
	/**
	 * To Create a "FOLLOW UP" Linked List
	 */
	public static void createList() {
		list.clear();
		list.add("F");
		list.add("O");
		list.add("L");
		list.add("L");
		list.add("O");
		list.add("W");
		list.add(" ");
		list.add("U");
		list.add("P");
	}
	
	//Tester
	public static void main(String[] args) {
		JNode<String> head = removeDuplicates_TwoIterator();
		
		while (head.next != null) {
			System.out.print(head.getData());
			head = head.next;
		}
		System.out.print(head.getData());
		System.out.println();
	}
	
}
