package bankimpl;

import bank.CreditInterest;
import bank.DepositAcc;

public class SavingsAcc implements DepositAcc, CreditInterest {

	private int balance;
	
	public SavingsAcc(int balance) {
		super();
		this.balance = balance;
	}

	@Override
	public void createAcc() {
		System.out.println("Creating Savings Account! with balance "+balance);
	}

	@Override
	public void calcInterest() {
		System.out.println("Calculating Interest.\n "+(balance*interestPercSavings/100)+" is your interest");
	}

	@Override
	public void addMonthlyInt() {
		System.out.println("Adding monthly interest of "+(balance*interestPercSavings/1200)+" to your account");
		balance+=(balance*interestPercSavings/1200);
		System.out.println("Your updated balance is "+balance);
	}

	@Override
	public void addHalfYrlyInt() {
		System.out.println("Adding half yearly interest of "+(balance*interestPercSavings/1200)+" to your account");
		balance+=(balance*interestPercSavings/200);
		System.out.println("Your updated balance is "+balance);
	}

	@Override
	public void addAnnualInt() {
		System.out.println("Adding yearly interest of "+(balance*interestPercSavings/100)+" to your account");
		balance+=(balance*interestPercSavings/100);
		System.out.println("Your updated balance is "+balance);
	}

	@Override
	public void withdraw(int amount) {
		balance=balance-amount;
		System.out.println("Withdraw of "+amount+" successful and the updated balance is "+balance);
	}

	@Override
	public void deposit(int amount) {
		balance=balance+amount;
		System.out.println("Deposit of "+amount+" successful and the updated balance is "+balance);
	}

	@Override
	public int getBalance() {
		return balance;
	}

}
