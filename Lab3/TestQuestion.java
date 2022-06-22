import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestQuestion {

	@Test
	void testConstructor() {
		Question q = new Question("What is Jamie's dog's name?", "Bibbet");
		assertEquals(1, q.getDifficulty());
		assertEquals("What is Jamie's dog's name?", q.getQuestion());
		assertEquals("Bibbet", q.getAnswer());
		
		Question q2 = new Question("","");
		assertEquals(1, q2.getDifficulty());
		assertEquals("", q2.getQuestion());
		assertEquals("", q2.getAnswer());
		
		Question q3 = new Question(null,null);
		assertEquals(1, q3.getDifficulty());
		assertNull(q3.getQuestion());
		assertNull(q3.getAnswer());
	}
	
	@Test
	void testOverloadedConstructor() {
		Question q = new Question("What breed is Bibbet?","Boston Terrier", 3);
		assertEquals(3, q.getDifficulty());
		assertEquals("What breed is Bibbet?", q.getQuestion());
		assertEquals("Boston Terrier", q.getAnswer());
		
		Question q2 = new Question("","",5);
		assertEquals(5, q2.getDifficulty());
		assertEquals("", q2.getQuestion());
		assertEquals("", q2.getAnswer());
		
		Question q3 = new Question(null,null,10);
		assertEquals(10, q3.getDifficulty());
		assertNull(q3.getQuestion());
		assertNull(q3.getAnswer());
		
		Question q4 = new Question("What color are Bibbet's eyes?", "Brown", 11);
		assertEquals(10, q4.getDifficulty());
		Question q5 = new Question("What color is Bibbet?", "Black and White", 0);
		assertEquals(1, q5.getDifficulty());
	}
	
	@Test
	void testIsCorrect() {
		Question q = new Question("What color is Bibbet?", "Black and White", 1);
		assertTrue(q.isCorrect("Black and White"));
		assertTrue(q.isCorrect("black and white"));
		assertFalse(q.isCorrect("white and black"));
		assertFalse(q.isCorrect(""));
		assertFalse(q.isCorrect(null));
		
		Question q2 = new Question("How old is Bibbet", "1");
		assertTrue(q2.isCorrect("1"));
		assertFalse(q2.isCorrect(""));
		assertFalse(q2.isCorrect(null));
	}

	@Test 
	void testToString(){
		Question q = new Question("What color is Bibbet?", "Black and White", 5);
		String result = "What color is Bibbet? Black and White 5";
		assertEquals(result, q.toString());
		
		Question q2 = new Question("How cute is Bibbet?", "The cutest");
		result = "How cute is Bibbet? The cutest 1";
		assertEquals(result, q2.toString());
		
		Question q3 = new Question("","");
		assertEquals("  1", q3.toString());
		
		Question q4 = new Question(null, null, 5);
		assertEquals("null null 5", q4.toString());
	}
	@Test
	void testGetSetQuestion() {
		Question q = new Question("","");
		assertEquals("", q.getQuestion());
		q.setQuestion("What is Bibbet's nickname?");
		assertEquals("What is Bibbet's nickname?", q.getQuestion());
	
		Question q2 = new Question("What is Bibbet's nickname?", "Spooky Boo", 10);
		assertEquals("What is Bibbet's nickname?", q2.getQuestion());
		q2.setQuestion("");
		assertEquals("", q2.getQuestion());
		q2.setQuestion(null);
		assertNull(q2.getQuestion());
		
	}
	@Test
	void testGetSetAnswer() {
		Question q = new Question("","");
		assertEquals("", q.getAnswer());
		q.setAnswer(null);
		assertNull(q.getAnswer());
		
		Question q2 = new Question("What is Bibbet's favorite toy?", "Christmas Hedgehog", 10);
		assertEquals("Christmas Hedgehog", q2.getAnswer());
		q2.setAnswer("Squeaky Fox");
		assertEquals("Squeaky Fox", q2.getAnswer());
	}
	@Test
	void testGetSetDifficulty() {
		Question q = new Question("","");
		assertEquals(1, q.getDifficulty());
		q.setDifficulty(5);
		assertEquals(5, q.getDifficulty());
		q.setDifficulty(-5);
		assertEquals(1, q.getDifficulty());
		q.setDifficulty(15);
		assertEquals(10, q.getDifficulty());
		Question q2 = new Question("What does Bibbet eat?","Kibble", 1);
		assertEquals(1, q2.getDifficulty());
		q.setDifficulty(0);
		assertEquals(1, q2.getDifficulty());
	}
}
