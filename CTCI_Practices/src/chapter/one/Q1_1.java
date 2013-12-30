package chapter.one;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 * 
 * @author jerry
 *
 */

public class Q1_1 {
	public static void main(String args[]) {
		//Test Strings
		String x = "ABCDAB";
		if (isUniqueChars(x)) {
			System.out.println("True");
		} else {
			System.out.println("false");
		}
	}
	
	public static boolean isUniqueChars(String str) {
		if (str.length() > 256) return false;
		
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((byte) (checker & (1 << val)) > 0) return false;
			
			checker |= (1 << val);
		}
		
		return true;
	}
	
	
	/**
	 * For the string contains only ASCII chars
	 * @param str
	 * @return
	 */
	public boolean isUniqueChars2(String str) {
		if (str.length() > 256) {
			return false;
		}
		
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
}
