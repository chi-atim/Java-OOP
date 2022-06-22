import java.util.ArrayList;

public class QuizTime {
	public static void main(String[] args) {
		Question q1 = new Question("Who is Brad Pitt's job?", "actor",1);
		Question q2 = new Question("Is Brad Pitt currently married?","no",2);
		Question q3 = new Question("What color are Brad Pitt's eyes?", "blue",3);
		Question q4 = new Question("How old is Brad Pitt?", "55",4);
		Question q5 = new Question("What is Brad Pitt's birth month?", "december",5);
		Question q6 = new Question("What is the first name of Brad Pitt's first wife?", "jennifer",6);
		Question q7 = new Question("What is the name of the character Brad Pitt played in Fight Club?", "tyler",7);
		Question q8 = new Question("What is Brad Pitt's first name?", "william ",8);
		Question q9 = new Question("Which state of the US is Brad Pitt from originally?", "oklahoma",9);
		Question q10 = new Question("What is the first name of Brad Pitt's mother?", "jane",10);
		
		Quiz quiz1 = new Quiz(5);
		quiz1.add(q1);
		quiz1.add(q2);
		quiz1.add(q3);
		quiz1.add(q4);
		quiz1.add(q5);
		quiz1.giveQuiz();
		
		Quiz quiz2 = new Quiz(5);
		quiz2.add(q6);
		quiz2.add(q7);
		quiz2.add(q8);
		quiz2.add(q9);
		quiz2.add(q10);
		System.out.println("You have "+ Quiz.getNumOfQuizzes() + " quizzes to do");
		quiz2.giveQuiz(8, 10);

	}

}
