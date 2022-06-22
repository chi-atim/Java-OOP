import java.util.ArrayList;

public class MultiChoiceQuestion extends Question {
	private ArrayList<String> choices;

	public MultiChoiceQuestion(String question, int difficulty) {
		super(question, "", difficulty);
		choices = new ArrayList<String>();
	}
	@Override
	public String display() {
		String str = super.display()+"\n";
		for (int i = 0 ; i < choices.size(); i++) {
			str += String.valueOf(i+1) + ". "+ choices.get(i) + "\n";
		}		
		str += "Enter correct choices. For example, if you think 1 and 2 are correct enter 12";
		return str;
	}
	public void addChoice(String answer, boolean correct){
		choices.add(answer);
		if(correct) {
			//super.setAnswer(super.getAnswer()+String.valueOf(choices.size()));
			String choiceString = "" + choices.size();
			this.setAnswer(choiceString);
		}
	}
}
