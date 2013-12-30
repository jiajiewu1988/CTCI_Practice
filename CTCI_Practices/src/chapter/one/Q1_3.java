package chapter.one;

/**
 * Given 2 strings write a method to decide if one is a permutation of the other.
 * 
 * Notes:
 * 1. This question asks about anagram comparison
 * 2. Anagram comparison - 回文构词法 ：由颠倒字母顺序组成的单词
 * 
 * Solution 1 - Sort the strings
 * Solution 2 - Check if two strings have identical character counts
 *
 */
public class Q1_3 {
	public static void main(String args[]) {
	}
	
	//Solution 1 - sort strings
	public String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	
	public boolean permutation1(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		
		return sort(str1).equals(sort(str2));
	}
	//end of solution 1
	
	
	//Solution 2 - check char counts
	public boolean permutation2(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		
		int[] charCounts = new int[256];
		
		char[] str1Array = str1.toCharArray();
		for (char c : str1Array) {
			charCounts[c]++;
		}
		
		for (int i = 0; i < str2.length(); i++) {
			int c = (int) str2.charAt(i);
			
			if (--charCounts[c] < 0) return false;
		}
		return true;
	}
	//end of solution 2
}
