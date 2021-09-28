package bankimpl;

import bank.DebitInterest;
import bank.LoanAcc;

public class HousingLoanAcc implements LoanAcc, DebitInterest {

	private int balance;
	
	public int getBalance() {
		return balance;
	}

	public HousingLoanAcc(int balance) {
		super();
		this.balance = balance;
	}

	@Override
	public void createAcc() {
		System.out.println("Creating Housing Loan Account! with Principal "+balance);
	}

	@Override
	public void calcInterest() {
		System.out.println("Calculating Interest.\n "+(balance*interestpercHomeLoan/100)+" is your interest");
	}

	@Override
	public void deductMonthlyInt() {
		System.out.println("Deducting monthly interest of "+(balance*interestpercHomeLoan/1200)+" from your account");
		balance-=(balance*interestpercHomeLoan/1200);
		System.out.println("Your updated balance is "+balance);
	}

	@Override
	public void deductHalfYrlyInt() {
		System.out.println("Deducting half yearly interest of "+(balance*interestpercHomeLoan/1200)+" from your account");
		balance-=(balance*interestpercHomeLoan/200);
		System.out.println("Your updated balance is "+balance);
	}

	@Override
	public void deductAnnualInt() {
		System.out.println("Deducting yearly interest of "+(balance*interestpercHomeLoan/100)+" from your account");
		balance-=(balance*interestpercHomeLoan/100);
		System.out.println("Your updated balance is "+balance);
	}

	@Override
	public void repayPrincipal() {
		balance=0;
		System.out.println("Principal repaid fully. Your balance is "+balance);
	}

	@Override
	public void payInterest(int amount) {
		balance=balance-amount;
		System.out.println("Repay of interest amount"+amount+" successful and the updated balance is "+balance);
	}

	@Override
	public void payPartialPrincipal(int amount) {
		balance=balance-amount;
		System.out.println("Repay of partial Principal amount"+amount+" successful and the updated balance is "+balance);
	}

}
