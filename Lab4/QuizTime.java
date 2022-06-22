
public class QuizTime {

	public static void main(String[] args) {
		Quiz firstQuiz = new Quiz(3);
		Quiz secondQuiz = new Quiz(1);
		
		Quiz thirdQuiz = new Quiz(3);
		
		firstQuiz.add(new Question("What color is Mars?", "red", 5));
		firstQuiz.add(new Question("What color is the sky?", "blue"));
		firstQuiz.add(new Question("What color is the grass?", "green"));
		firstQuiz.add(new Question("What color is the sun?", "yellow", 2));
		firstQuiz.add(new Question("What color is an orange?", "orange"));
		firstQuiz.add(new Question("What color is Love?", "red", 10));
		firstQuiz.add(new Question("What color is a ghost?", "white", 4));
		firstQuiz.add(new Question("What color is Anger?", "red", 10));
		firstQuiz.add(new Question("What color is Pain?", "red", 10));

		secondQuiz.add(new Question("Who are you?", "Me", 10));

		
		thirdQuiz.add(new FillInQuestion("The color _white_ is the most common color found on flags.",2));
		thirdQuiz.add(new NumericQuestion("17.2 - 15.1", "2.1", 1, 0.5));
		
		Question qq = new FillInQuestion("What are correct _colors o_f ants?",1);
		MultiChoiceQuestion mq = new MultiChoiceQuestion("What are correct colors of ants?",1);
		NumericQuestion nq =new Fruit("aaaaa","aa", 1, 23);
		Question qqq =(Question) mq;
		Question fr= (Fruit)nq;
		
		System.out.println(qqq.display());
		
		thirdQuiz.add(mq);
		mq.addChoice("Black", true);
		mq.addChoice("Green", false);
		mq.addChoice("Orange", false);
		mq.addChoice("Red", true);

		
		System.out.println(qq instanceof Question);
		System.out.println(mq instanceof MultiChoiceQuestion);
		System.out.println(nq instanceof Question);
		System.out.println(qq instanceof FillInQuestion);
		System.out.println(qq instanceof Question);
		System.out.println(qq instanceof FillInQuestion);
	}

}