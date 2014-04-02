package chapter.one;

/**
 * Assume you have the method isSubstring which checks if one word is a substring of another.
 * Given 2 strings s1 and s2. Write code to check if s2 is a rotation of s1 using only one 
 * call of isSubstring
 * @author jerry
 *
 *Keys: If s2 is a rotation of s1, then s2 is a substring of s1+s1
 */

public class Q1_8 {

	public static boolean isRotation(String s1, String s2) {
		String s = s1 + s1;
		if (isSubstring(s, s2)) return true;
		return false;
	}
	
	public static boolean isSubstring(String s1, String s2) {
		if (s1.contains(s2)) return true;
		return false;
	}
}
