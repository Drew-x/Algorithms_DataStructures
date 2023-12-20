import java.util.*;
import java.math.*;

public class LongestPalindrom {

	static int resultStart;
	static int resultLength;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String word = "babad";
		
		System.out.println(longestPalindrome(word));
		int x = Integer.MAX_VALUE;
		System.out.println(x);
	}
	
	public static String longestPalindrome(String word) {
		
		//char[] letters = word.toCharArray();
		if (word.length() <2) {
			//String text = String.valueOf(word);
			
			return word;
		}
		
		for (int i = 0; i < word.length(); i++) {
			//System.out.println(letters[i]);
			expandRange(word, i,i);
			expandRange(word, i,i+1);
		}
		
		return word.substring(resultStart, resultStart + resultLength);
	}
	
	private static void expandRange(String letters, int i, int i2) {
		
		while (i >= 0 && i2 < letters.length() && letters.charAt(i) == letters.charAt(i2)) {
			System.out.println("word:"+letters+ " i1: "+ i +" i2: "+ i2+"---- "+ "char at I : "+ letters.charAt(i)+ "     char at I2 : "+ letters.charAt(i2));
			i--;
			i2++;
		}
		
		if (resultLength < i2 - i - 1) {
			resultStart = i+ 1;
			resultLength = i2 - i -1;
		}
	}

	public static Deque<Character> checker(Deque<Character> deque) {
		
		//boolean no = false;
		
		Deque<Character> x = new LinkedList<Character>();
		while (!deque.isEmpty() ) {
			System.out.println(x);
			x = isPalindrom(deque);
			deque.pollLast();
			deque.pollFirst();
			System.out.println("in");
		}
		System.out.println(x.toString());
		return x;
	}
	
	public static Deque<Character> isPalindrom(Deque<Character> letters) {
		
		if( letters.size() ==1 || letters.size() == 0) {
			System.out.println(letters);
			return letters;
		}
		
		if(letters.peekFirst().equals(letters.peekLast())) {
			letters.pollFirst();
			letters.pollLast();
			return isPalindrom(letters);
		}
		
		
		return letters;
		
	}

}
