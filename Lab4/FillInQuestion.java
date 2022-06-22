 public class FillInQuestion extends Question {

	 public FillInQuestion (String statement, int difficulty) {
		super(
				statement.substring(0, statement.indexOf('_')+1)+statement.substring(statement.lastIndexOf('_')),
				statement.substring(statement.indexOf('_')+1,statement.lastIndexOf('_')),
				difficulty);
	}
	
}
