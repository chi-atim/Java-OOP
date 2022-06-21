import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * A class to test that the methods of the PatternMatcher class work as
 * expected, given specific pieces of input.
 * 
 * @author jmckeescott
 *
 */
class TestPatternMatcher {

	@Test
	void testIsPalindrome() {
		/*
		 * when we call isPalindrome with the following inputs 
		 * we expect the return value to be true
		 */
		assertTrue(PatternMatcher.isPalindrome("racecar"));
		assertTrue(PatternMatcher.isPalindrome("RACECAR"));
		assertTrue(PatternMatcher.isPalindrome("raceCAR"));
		assertTrue(PatternMatcher.isPalindrome("LIVE ON NO EVIL"));
		assertTrue(PatternMatcher.isPalindrome("123321"));
		assertTrue(PatternMatcher.isPalindrome(""));
		assertTrue(PatternMatcher.isPalindrome(" "));
		/*
		 * when we call isPalindrome with the following inputs 
		 * we expect the return value to be false
		 */
		assertFalse(PatternMatcher.isPalindrome("racecars"));
		assertFalse(PatternMatcher.isPalindrome("schedule"));
		assertFalse(PatternMatcher.isPalindrome("123123"));
	}

	@Test
	void testContainsVowel() {
		/*
		 * when we call containsVowel with the following inputs 
		 * we expect the return value to be false
		 */
		assertFalse(PatternMatcher.containsVowel(" "));
		assertFalse(PatternMatcher.containsVowel(""));
		assertFalse(PatternMatcher.containsVowel("123321"));
		assertFalse(PatternMatcher.containsVowel("spy"));
		/*
		 * when we call containsVowel with the following inputs 
		 * we expect the return value to be true
		 */
		assertTrue(PatternMatcher.containsVowel("screech"));
		assertTrue(PatternMatcher.containsVowel("always"));
		assertTrue(PatternMatcher.containsVowel("rift"));
		assertTrue(PatternMatcher.containsVowel("oops"));
		assertTrue(PatternMatcher.containsVowel("us"));
		assertFalse(PatternMatcher.containsVowel("LYFT"));
		assertTrue(PatternMatcher.containsVowel("LEFT"));
		assertTrue(PatternMatcher.containsVowel("AND"));
		assertTrue(PatternMatcher.containsVowel("LIFT"));
		assertTrue(PatternMatcher.containsVowel("ODD"));
		assertTrue(PatternMatcher.containsVowel("LUST"));
	}

	@Test
	void testIsVowel() {
		/*
		 * when we call isVowel with the following inputs 
		 * we expect the return value to be false
		 */
		assertFalse(PatternMatcher.isVowel(' '));
		assertFalse(PatternMatcher.isVowel('z'));
		assertFalse(PatternMatcher.isVowel('Z'));
		/*
		 * when we call isVowel with the following inputs 
		 * we expect the return value to be true
		 */
		assertTrue(PatternMatcher.isVowel('a'));
		assertTrue(PatternMatcher.isVowel('A'));
		assertTrue(PatternMatcher.isVowel('e'));
		assertTrue(PatternMatcher.isVowel('E'));
		assertTrue(PatternMatcher.isVowel('i'));
		assertTrue(PatternMatcher.isVowel('I'));
		assertTrue(PatternMatcher.isVowel('o'));
		assertTrue(PatternMatcher.isVowel('O'));
		assertTrue(PatternMatcher.isVowel('u'));
		assertTrue(PatternMatcher.isVowel('U'));
	}

	@Test
	void testContainsRepeats() {
		/*
		 * when we call containsRepeats with the following inputs 
		 * we expect the return value to be false
		 */
		assertFalse(PatternMatcher.containsRepeats(""));
		assertFalse(PatternMatcher.containsRepeats("abcDE"));
		assertFalse(PatternMatcher.containsRepeats("abcba"));
		assertFalse(PatternMatcher.containsRepeats("1234"));
		assertFalse(PatternMatcher.containsRepeats("oh ho"));
		/*
		 * when we call containsRepeats with the following inputs 
		 * we expect the return value to be true
		 */
		assertTrue(PatternMatcher.containsRepeats("speech"));
		assertTrue(PatternMatcher.containsRepeats("PRETTY"));
		assertTrue(PatternMatcher.containsRepeats("LesS"));
		assertTrue(PatternMatcher.containsRepeats("aabbcde"));
		assertTrue(PatternMatcher.containsRepeats("abcDDEE"));
		assertTrue(PatternMatcher.containsRepeats("abCcDe"));
		assertTrue(PatternMatcher.containsRepeats("1221"));
	}
	@Test
	void testPerformSwap() {
		/*
		 * Each test checks if the expected String is
		 * returned by the call to performSwap with the 
		 * given input
		 */
		assertEquals("lESs", PatternMatcher.performSwap("LesS"));
		assertEquals("", PatternMatcher.performSwap(""));
		assertEquals("PRETTY", PatternMatcher.performSwap("pretty"));
		assertEquals("super", PatternMatcher.performSwap("SUPER"));
		assertEquals(" ", PatternMatcher.performSwap(" "));
		assertEquals("123", PatternMatcher.performSwap("123"));
		assertEquals("Speech", PatternMatcher.performSwap("sPEECH"));
	}
}
