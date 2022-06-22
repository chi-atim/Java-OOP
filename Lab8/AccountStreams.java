import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountStreams {
	public static void main (String[] args) {
		
		//Stream operations for the file "accountSmall.txt"
		String filename1 = "accountsSmall.txt";
		
		Stream<Account> accountStreamSmall1 = AccountParser.getCollection(filename1).stream();		
		long resultSmall1 = accountStreamSmall1
				.filter(a -> a.getBalance() > 1000000)
				.count();
					
		Stream<Account> accountStreamSmall2 = AccountParser.getCollection(filename1).stream();
		double resultSmall2 = accountStreamSmall2
				.filter(a -> a.getBalance() < 1000)
				.mapToDouble(a -> a.getBalance())
				.sum();
				
		Stream<Account> accountStreamSmall3 = AccountParser.getCollection(filename1).stream();
		double resultSmall3 = accountStreamSmall3
				.max(Comparator.comparing(Account::getBalance))
				.get().getBalance();
		
		Stream<Account> accountStreamSmall4 = AccountParser.getCollection(filename1).stream();
		List<Integer> resultSmall4 = accountStreamSmall4
				.filter(a -> a.getBalance() < 25)
				.limit(10)
				.map(a->a.getNumber())
				.collect(Collectors.toList());		

		//Stream operations for the file "account.txt"
		String filename2 = "accounts.txt";
		Stream<Account> accountStreamBig1 = AccountParser.getCollection(filename2).stream();		
		long resultBig1 = accountStreamBig1
				.filter(a -> a.getBalance() > 1000000)
				.count();
					
		Stream<Account> accountStreamBig2 = AccountParser.getCollection(filename2).stream();
		double resultBig2 = accountStreamBig2
				.filter(a -> a.getBalance() < 1000)
				.mapToDouble(a -> a.getBalance())
				.sum();
				
		Stream<Account> accountStreamBig3 = AccountParser.getCollection(filename2).stream();
		double resultBig3 = accountStreamBig3
				.max(Comparator.comparing(Account::getBalance))
				.get().getBalance();
		
		Stream<Account> accountStreamBig4 = AccountParser.getCollection(filename2).stream();
		List<Integer> resultBig4 = accountStreamBig4
				.filter(a -> a.getBalance() < 25)
				.limit(10)
				.map(a->a.getNumber())
				.collect(Collectors.toList());		
		
		//Print out results of the Stream operations for the file "acountSmall.txt"
		System.out.println(resultSmall1 + " accounts have more than $1,000,000.00 in them.");
		System.out.println(resultSmall2 + " is the sum of the balances of all accounts with a balance under $1000.00");
		System.out.println("The largest account balance is: $" + resultSmall3);
		System.out.print("The Account number for the first 10 accounts with balances under $25.00 are ");
		resultSmall4.forEach(n -> System.out.println(n));		
		
		System.out.println("*****************************************************************************************");
		
		//Print out results of the Stream operations for the file "account.txt"
		System.out.println(resultBig1 + " accounts have more than $1,000,000.00 in them.");
		System.out.println(resultBig2 + " is the sum of the balances of all accounts with a balance under $1000.00");
		System.out.println("The largest account balance is: $" + resultBig3);
		System.out.print("The Account number for the first 10 accounts with balances under $25.00 are ");
		resultBig4.forEach(n -> System.out.println(n));
		
	}
}
