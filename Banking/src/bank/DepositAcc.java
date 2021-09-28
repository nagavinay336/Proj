package bank;

public interface DepositAcc extends Account {

	void withdraw(int amount);

	void deposit(int amount);

	int getBalance();
}
