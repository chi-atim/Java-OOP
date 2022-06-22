import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * This is a class that inherits JPanel class and creates Panels which contains a tool for calculating statistics about a input text.
 * @author Chiemi Mita
 * @since 2019-03-07
 */
public class TextStatPanel extends JPanel{

	private JPanel organizer, statsBox, infoBox, checkBox;
	private JButton computeButton, checkWordButton;
	private JLabel wordLabel, aveLabel, vowelLabel, checkWordLabel;
	private JTextArea textArea;
	private JTextField wordOutput, aveOutput, vowelOutput, checkWordInput, checkWordOutput;
	
	/**
	 * This is a constructor
	 */
	public TextStatPanel() {

		organizer = new JPanel();		
		organizer.setLayout(new BorderLayout());
		organizer.setBorder(BorderFactory.createLoweredBevelBorder());
		organizer.setPreferredSize(new Dimension(500, 250));
				
		createInputbox();
		createInfoBox();
		
		computeButton = new JButton("Compute Statistics");
		computeButton.addActionListener(new ComputeListener());
		organizer.add(computeButton, BorderLayout.SOUTH);
		
		add(organizer);
	}
	/**
	 * This is a method for creating a panel of input box
	 */
	public void createInputbox() {
		JPanel inputBox = new JPanel();
		inputBox.setLayout(new BorderLayout());
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		inputBox.add(scrollPane);
		organizer.add(inputBox, BorderLayout.CENTER);
	}
	/**
	 * This is a method for creating a panel of information box
	 */
	public void createInfoBox() {
		infoBox = new JPanel();
		infoBox.setLayout(new GridLayout(2, 1));
		createStatsBox();
		createCheckBox();	
		
		infoBox.add(statsBox);
		infoBox.add(checkBox);
	
		organizer.add(infoBox, BorderLayout.EAST);	
	}
	
	public void createStatsBox() {
		statsBox = new JPanel();
		statsBox.setBackground(new Color(240, 255, 255));
		statsBox.setLayout(new GridLayout(3, 2));
		statsBox.setBorder(BorderFactory.createTitledBorder("Statistics"));
			
		wordLabelField();
		aveLabelField();
		vowelLabelField();
	}
	
	/**
	 * This is a method for creating words count labeled field
	 */
	public void wordLabelField() {
		wordLabel = new JLabel("Number of words:");
		wordOutput = new JTextField();
		wordOutput.setEditable(false);
		wordOutput.setBackground(Color.WHITE);
		statsBox.add(wordLabel);
		statsBox.add(wordOutput);
	}
	/**
	 * This is a method for creating average words length labeled field
	 */
	public void aveLabelField() {
		aveLabel = new JLabel("Average word length:");
		aveOutput = new JTextField();
		aveOutput.setEditable(false);
		aveOutput.setBackground(Color.WHITE);
		statsBox.add(aveLabel);
		statsBox.add(aveOutput);
	}
	/**
	 * This is a method for creating vowels count labeled field
	 */
	public void vowelLabelField() {
		vowelLabel = new JLabel("Number of vowels:");
		vowelOutput = new JTextField();
		vowelOutput.setEditable(false);
		vowelOutput.setBackground(Color.WHITE);
		statsBox.add(vowelLabel);	
		statsBox.add(vowelOutput);
	}	
	
	/**
	 * This is an event listener which generates when compute button is pressed
	 */
	private class ComputeListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			String input = textArea.getText().trim();
			
			wordOutput.setText(String.valueOf(wordCount(input)));
			aveOutput.setText(String.valueOf(aveLength(input)));
			vowelOutput.setText(String.valueOf(vowelCount(input)));
		}
		/**
		 * This is a method for counting the number of words
		 * @param input String which user entered
		 * @return int a number of words
		 */
		public int wordCount(String input) {
			String[] inputArray = input.split("\\W+");
			return inputArray.length;
		}
		/**
		 * This is a method for computing the average word length
		 * @param input String which user entered
		 * @return double an average word length
		 */
		public double aveLength(String input) {
			double total = 0;
			String[] inputArray = input.split("\\W+");
			for(String str: inputArray) {
				total += str.length();
			}
			return total / inputArray.length;
		}
		/**
		 * This is a method for counting the number of vowels
		 * @param input String which user entered
		 * @return int a number of vowels
		 */
		public int vowelCount(String input) {
			int vResult = 0;
			
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i)=='a' || (input.charAt(i) == 'i') || (input.charAt(i) == 'u') || (input.charAt(i) == 'e') || (input.charAt(i) == 'o') )
					vResult ++;
			}
			return vResult;
		}
	}
	/**
	 * This is a method for creating a panel of A word CheckBox
	 */
	public void createCheckBox() {
		checkBox = new JPanel();
		checkBox.setBackground(new Color(255, 240, 255));
		checkBox.setBorder(BorderFactory.createTitledBorder("Check Box"));
		
		checkBox.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		checkWordLabel = new JLabel("A word to check:");
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.5;
		checkBox.add(checkWordLabel,c);	
		
		checkWordInput = new JTextField(10);
		c.gridx = 1;
		c.gridy = 0;
		checkBox.add(checkWordInput, c);
		
		checkWordOutput = new JTextField();
		checkWordOutput.setEditable(false);
		checkWordOutput.setBackground(new Color(255, 240, 255));
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		checkWordOutput.setHorizontalAlignment(JTextField.CENTER);
		checkBox.add(checkWordOutput, c);
		
		checkWordButton = new JButton("Check");
		checkWordButton.addActionListener(new CheckWordListener());
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 2;
		checkBox.add(checkWordButton, c);		
	}
	/**
	 * This is an event listener which generates when check button is pressed
	 */
	private class CheckWordListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			String input = textArea.getText().trim();
			String word = checkWordInput.getText();
			String[] inputArray = input.split("\\W+");
			int result=0;
			
			if (word.length()>0) {
				for(String str: inputArray) {
					if(str.toLowerCase().contains(word.toLowerCase()))
						result++;
				}
			}
			checkWordOutput.setText(result + " words contains " + "\"" + word + "\"");
		}
	}
		
}
