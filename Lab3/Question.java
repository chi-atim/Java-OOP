/**
 * This is a class that simulates short-answer style questions to be placed on a quiz.
 */
public class Question {
	private String question, answer;
	private int difficulty;

	public Question(String question, String answer, int difficulty) {
		this.question=question;
		this.answer=answer;
		if(difficulty<1)
			this.difficulty=1;
		else if (difficulty>10)
			this.difficulty=10;
		else
			this.difficulty=difficulty;
	}

	public Question(String question, String answer) {
		this(question, answer, 1);
	}
	public String getQuestion() {
		return question;
	}	
	public void setQuestion(String question) {
		this.question = question;
	}	
	public String getAnswer() {
		return answer;
	}	
	public void setAnswer(String answer) {
		this.answer = answer;
	}	
	public int getDifficulty() {
		return difficulty;
	}
	
	public void setDifficulty(int difficulty) {
		if(difficulty<1)
			this.difficulty=1;
		else if (difficulty>10)
			this.difficulty=10;
		else
			this.difficulty=difficulty;
	}
	
	public String toString() {
		String result = this.question + " " + this.answer + " "+ this.difficulty;
		return result;
	}
	
	public boolean isCorrect(String attemptedAnswer) {
		return answer.equalsIgnoreCase(attemptedAnswer);
	}
}
