package chapter.one;

/**
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become 
 * a2b1c5a3. If the "compressed" string would not become smaller than the 
 * original string, your method should return the original string.
 *
 */
public class Q1_5 {
	public static void main(String args[]) {
		String s = "aabcccccaaa";
		String s2 = "abcedfsjflskc,dksla";
		System.out.println(compress_version1(s));
	}
	
	/**
	 * My own solution, time complexity O(n + k^2) cuz string concatenation is O(n^2)
	 * Thoughts: 
	 * 1. loop around the original string, and look for continuous chars
	 * 2. when find continuous chars, use string concatenation to build the result
	 * 
	 * @param s
	 * @return
	 */
	public static String compress_version1(String s) {
		if (s.length() == 0) return s;
		
		int count = 1;
		//char[] result = new char[s.length()];
		String result = "";
		char lastChar = s.charAt(0);
		
		for (int i = 1; i < s.length(); i++) {
			if (lastChar == s.charAt(i)) count++;
			else {
				//String concatenation operates in O(n^2) time
				result = result.concat(Character.toString(lastChar) + Integer.toString(count));
				count = 1;
			}
			
			if (i == s.length() - 1) {
				result = result.concat(Character.toString(s.charAt(i)) + Integer.toString(count));
			}
			
			lastChar = s.charAt(i);
		}
		
		if (s.length() > result.length()) return result;
		else return s;
	}
	
	/**
	 * Use StringBuffer to do concatenation
	 * @param s
	 * @return
	 */
	public static String compress_stringbuffer(String s) {
		//Check if compressed string is longer than original string
		if (countCompression(s) >= s.length()) return s;
		
		StringBuffer mystr = new StringBuffer();
		char last = s.charAt(0);
		int count = 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == last) {
				count++;
			} else {
				mystr.append(last);
				mystr.append(count);
				count = 1;
				last = s.charAt(i);
			}
		}
		
		mystr.append(last);
		mystr.append(count);
		return mystr.toString();
	}
	
	
	//Keys from CTCI solutions P-177
	
	/**
	 * Count the length of the compressed string.
	 * @param s
	 * @return
	 */
	public static int countCompression(String s) {
		char last = s.charAt(0);
		int size = 0;
		int count = 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == last) {
				count++;
			} else {
				last = s.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		
		size += 1 + String.valueOf(count).length();
		return size;
	}
}
