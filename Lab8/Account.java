/**
 * 
 * @author J. McKee-Scott
 *
 */
public class Account {
	private int number;
	private double balance;

	public Account(int number, double balance) {
		this.number = number;
		this.balance = balance;
	}

	public void deposit(double amount) {
		if (amount > 0)
			balance += amount;
	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance)
			balance -= amount;
	}

	public int getNumber() {
		return number;
	}

	public double getBalance() {
		return balance;
	}

	public String toString() {
		return "Account number: " + this.number + " has balance: $" + this.balance;
	}
}
