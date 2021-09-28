package bank;

public interface LoanAcc extends Account {

	void repayPrincipal();

	void payInterest(int amount);

	void payPartialPrincipal(int amount);

}
