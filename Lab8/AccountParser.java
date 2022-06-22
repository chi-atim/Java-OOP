import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountParser {

	public static ArrayList<Account> getCollection(String filename){

		ArrayList<Account> accList = new ArrayList<Account>();
		Scanner scan = null;
		String fileLine;
		try {
			scan = new Scanner(new File(filename));
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}		
		
		while(scan.hasNextLine()) {
			fileLine = scan.nextLine();	
			try {
				accList.add(createAccount(fileLine));
			}catch (InvalidBalanceException e) {
				System.out.println(e.getMessage());
			}catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}
		}
		scan.close();
		return accList;
	}
	public static Account createAccount(String fileLine) throws InvalidBalanceException,NumberFormatException{
		Account acc = null;
		String[] file = fileLine.split("\\s");
		int aNum = Integer.parseInt(file[0]);
		int aBal = Integer.parseInt(file[1]);
		
		if(aBal<0) {
			throw new InvalidBalanceException("Invalid Balance! Balance cannot be negative!");
		}else {				
			acc = new Account(aNum, aBal);
		}
		return acc;
	}
}
