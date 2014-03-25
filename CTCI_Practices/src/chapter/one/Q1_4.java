package chapter.one;

/**
 * 
 * @author jerry
 * The Key to solve this problem is doing the char array from the end to start, so replace procedures
 * can be done in place, and no extra spaces needed. The time complexity is O(n)
 */

public class Q1_4 {
	
	public static char[] replaceSpace(char[] str, int trueLength) {
		int i = str.length - 1, j = trueLength - 1;
		while (i >= 0 && j >= 0) {
			if (str[j] != ' ') {
				str[i] = str[j];
			} else {
				str[i] = '0';
				str[i-1] = '2';
				str[i-2] = '%';
				i = i - 2;
			}
			i--;
			j--;
		}
		return str;
	}
	
	
	//Tester
	public static void main(String[] args) {
		String input = "Mr John Smith    ";
		char[] inputCharArray = input.toCharArray();
		
		inputCharArray = replaceSpace(inputCharArray, 13);
		for (int i = 0; i < inputCharArray.length; i++) {
			System.out.print(inputCharArray[i]);
		}
		System.out.println();
	}

}
