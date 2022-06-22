
public class NumericQuestion extends Question{
	private double tolerance;

	public NumericQuestion(String question, String answer, int difficulty, double tolerance) {
		super(question,answer,difficulty);
		this.tolerance=tolerance;
	}
	public double getTolerance() {
		return tolerance;
	}
	public void setTolerance(double tolerance) {
		this.tolerance = tolerance;
	}
	@Override
	public boolean isCorrect(String answer) {
		double givenAnswer = Double.parseDouble(super.getAnswer());
		double correctAnswer = Double.parseDouble(answer);
		if(Math.abs(givenAnswer-correctAnswer) <= tolerance)
			return true;
		return false;
	}

}
