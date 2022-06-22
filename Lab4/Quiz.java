import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
	private ArrayList<Question> questionList;
	private int score;
	private static int total = 0;

	public Quiz(int size) {
		if (size > 25)
			size = 25;
		if (size <= 0)
			size = 1;
		questionList = new ArrayList<Question>(size);
		score = 0;
		total++;
	}

	public static int getTotalNumberQuizzes() {
		return total;
	}
	public void add(Question q) {
		if (questionList.size() < 25)
			questionList.add(q);
	}	
	public int getScore() {
		return score;
	}

	public void giveQuiz(int minDifficulty, int maxDifficulty) {
		Scanner scan = new Scanner(System.in);
		for (Question q : questionList) {
			if (q.getDifficulty() >= minDifficulty && q.getDifficulty() <= maxDifficulty) {
				System.out.println(q.display());
				String answer = scan.nextLine();
				if (q.isCorrect(answer)) {
					score++;
					System.out.println("Correct!");
				}else System.out.println("Incorrect!");
			}
		}
		System.out.println("Your score is: " + this.score);
		this.score = 0; 
	}
	public void giveQuiz() {
		giveQuiz(1, 10);
		this.score = 0;
	}
}
