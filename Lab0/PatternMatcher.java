import java.util.Scanner;
/**
 * This is a class that contains methods that check various patterns
 * @author Chiemi Mita
 * @since 2019-01-10
 */
public class PatternMatcher {
	/**
	 * This is a method that checks if a string is a palindrome
	 * @param str the string to check
	 * @return true if str is a palindrome, false otherwise
	 */
	public static boolean isPalindrome(String str) {
		str = str.toLowerCase();
		for (int i = 0; i < str.length()/2; i++) {
			if (str.charAt(i) != str.charAt(str.length()-i-1))
				return false;
		}
		return true;
	}
	/**
	 * This is a method that checks if a string contains a vowel
	 * @param str the string to check
	 * @return true if str contains at least one vowel, false otherwise
	 */
	public static boolean containsVowel(String str) {
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a'||str.charAt(i) == 'i'||str.charAt(i) == 'u'||str.charAt(i) == 'e'||str.charAt(i) == 'o')
				return true;
		}
		return false;
	}	
	/**
	 * This is a method that checks if a char is a vowel
	 * @param ch the char to check
	 * @return true if ch is a vowel, false otherwise
	 */
	public static boolean isVowel(char ch) {
		ch = Character.toLowerCase(ch);
		if (ch == 'a'||ch == 'i'||ch == 'u'||ch == 'e'||ch == 'o') {
			return true;
		}
		return false;
	}	
	/**
	 * This is a method that checks if a string has a char that is repeated consecutively
	 * @param str the string to check
	 * @return true if str contains two of the same letter in a row, false otherwise
	 */
	public static boolean containsRepeats(String str) {
		str = str.toLowerCase();
		for (int i = 0; i < str.length()-1; i++) {
			if (str.charAt(i) == str.charAt(i+1))
				return true;
		}
		return false;
	}	
	/**
	 * This is a method that accepts a string and swap the case of each char
	 * @param str the string to perform
	 * @return a new string that has all the original characters of the first string, but with the opposite capitalization
	 */
	public static String performSwap(String str) {
		String result ="";
		for (int i = 0; i < str.length(); i++) {
			if (Character.isUpperCase(str.charAt(i))) {
				result += Character.toLowerCase(str.charAt(i));
			}
			else{
				result += Character.toUpperCase(str.charAt(i));
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);		
		System.out.println("Enter the string to check: ");
		String str = input.nextLine();
		
		String result = "The string: " + str;
		if (isPalindrome(str)){
			result += "\nis a palindrome.";
		}
		else {
			result += "\nis not a palindrome.";
		}
		
		if (containsVowel(str)){
			result += "\ncontains at least one vowel.";
		}
		else {
			result += "\ndoes not contain a vowel";
		}
		
		if (containsRepeats(str)){
			result += "\nhas repeats.";
		}
		else {
			result += "\nhas no repeats.";
		}		
		result += "\n" +str + " becomes: " + performSwap(str);
		System.out.println(result);
		input.close();
	}
}