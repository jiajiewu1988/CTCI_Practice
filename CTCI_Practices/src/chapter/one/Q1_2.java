package chapter.one;

/**
 * Implement a function void reverse(char* str) in C or C++ which reverses a null-terminated string
 * @author jerry
 *
 */

public class Q1_2 {
	
	
	public static char[] reverse(char[] str) {
		char temp;
		for (int i = 0; i <= str.length/2; i++) {
			temp = str[i];
			int reversePosition = str.length - 1 - i;
			str[i] = str[reversePosition];
			str[reversePosition] = temp;
		}
		return str;
	}
	
	//Tester
	public static void main(String[] args) {
		char[] str = {'1','2','3','4','5','6','7'};
		str = reverse(str);
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i] + " ");
		}
		System.out.println();
	}
	
}
