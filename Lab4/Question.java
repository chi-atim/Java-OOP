
public class Question {
	private String question, answer;
	private int difficulty;
	
	public Question(String question, String answer) {
		this(question, answer, 1);
	}
	public Question(String question, String answer, int difficulty) {
		this.question = question;
		this.answer = answer;
		if(difficulty < 1)
			this.difficulty = 1;
		else if(difficulty > 10)
			this.difficulty = 10;
		else
			this.difficulty = difficulty;
	}
	public boolean isCorrect(String attemptedAnswer) {
		return this.answer.equalsIgnoreCase(attemptedAnswer);
	}
	public String toString() {
		return this.question + " " + this.answer + " " + this.difficulty;
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
		if(difficulty < 1)
			this.difficulty = 1;
		else if(difficulty > 10)
			this.difficulty = 10;
		else
			this.difficulty = difficulty;
	}
	public String display() {
		return question + " (Difficulty: "+ difficulty + ")";
	}
}
