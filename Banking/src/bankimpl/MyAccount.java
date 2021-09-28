package bankimpl;

public class MyAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FDAcc fd=new FDAcc(5000);
		fd.createAcc();
		fd.addMonthlyInt();
		fd.calcInterest();
		fd.addAnnualInt();
		fd.addHalfYrlyInt();
		fd.deposit(10000);
		fd.getBalance();
		fd.withdraw(5000);
		fd.getBalance();
		
		System.out.println();
		System.out.println("--------------------------");
		System.out.println();
		SavingsAcc sa=new SavingsAcc(7000);
		sa.createAcc();
		sa.addMonthlyInt();
		sa.calcInterest();
		sa.addAnnualInt();
		sa.addHalfYrlyInt();
		sa.deposit(12000);
		sa.getBalance();
		sa.withdraw(1000);
		sa.getBalance();
		
		
		System.out.println();
		System.out.println("--------------------------");
		System.out.println();
		HousingLoanAcc hl=new HousingLoanAcc(50000);
		hl.createAcc();
		hl.deductMonthlyInt();
		hl.calcInterest();
		hl.deductHalfYrlyInt();
		hl.deductAnnualInt();
		hl.payInterest(1000);
		hl.getBalance();
		hl.payPartialPrincipal(20000);
		hl.getBalance();
		hl.repayPrincipal();
		hl.getBalance();
		
		
		System.out.println();
		System.out.println("--------------------------");
		System.out.println();
		PersonalLoanAcc pl=new PersonalLoanAcc(500000);
		pl.createAcc();
		pl.deductMonthlyInt();
		pl.calcInterest();
		pl.deductHalfYrlyInt();
		pl.deductAnnualInt();
		pl.payInterest(1000);
		pl.getBalance();
		pl.payPartialPrincipal(200000);
		pl.getBalance();
		pl.repayPrincipal();
		pl.getBalance();
	}

}
