
public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "abccba";
		
		
		System.out.println(isPalindrome(text));
	}
	
	public static boolean isPalindrome(String text) {
		
		if(text.length() == 0 || text.length() == 1) {
			
			return true;
		}
		
		if (text.charAt(0) == text.charAt(text.length() -1 )) {
			
			return isPalindrome(text.substring(1, text.length() -1));
		//return isPalindrome(text.substring(1));  
		}
		
		
		return false;
	}

}
