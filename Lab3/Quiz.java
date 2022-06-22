import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
	private int score, numOfQuestions;
	private static int numOfQuizzes=0;
	private ArrayList<Question> quiz;

	public Quiz(int numOfQuestions) {
		this.numOfQuestions=numOfQuestions;
		this.quiz = new ArrayList<Question>(numOfQuestions);
		numOfQuizzes ++;
	}
	public int getNumOfQuestions() {
		return numOfQuestions;
	}
	public void setNumOfQuestions(int numOfQuestions) {
		this.numOfQuestions = numOfQuestions;
	}
	public int getScore() {
		return score;
	}
	public static int getNumOfQuizzes() {
		return numOfQuizzes;
	}
	public void add(Question q) {
		if (numOfQuestions<25)
			quiz.add(q);
	}
	public void giveQuiz() {
		score=0;
		Scanner sc = new Scanner(System.in);
		for(Question q : quiz){
			System.out.println( q.getQuestion()+" (Difficulty: "+ q.getDifficulty() + ")");
			String input = sc.nextLine();
			if(input.equalsIgnoreCase(q.getAnswer())) {
				System.out.println("Correct!");
				this.score ++;
			}else
				System.out.println("Incorrect!");
		}
		System.out.println("Your score is: " + this.score);
	}
	public void giveQuiz(int min, int max){
		score = 0;
		for(int i=0; i<quiz.size(); i++){
			if(quiz.get(i).getDifficulty()<min || quiz.get(i).getDifficulty()>max)
				quiz.remove(i);
		}
		giveQuiz();
	}
}
