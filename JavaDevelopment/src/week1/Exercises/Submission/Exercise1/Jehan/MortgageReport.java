package week1.Exercises.Submission.Exercise1.Jehan;

import java.text.NumberFormat;

public class MortgageReport {
	
	private final NumberFormat currency;
	private MortgageCalculator calculator;

	public MortgageReport(MortgageCalculator calculator) {
		this.calculator = calculator;
		currency = NumberFormat.getCompactNumberInstance();
	}

	public void printMortgage() {
	    double mortgage = calculator.calculateMortgage();
	    String mortgageFormatted = currency.format(mortgage);
	    System.out.println();
	    System.out.println("MORTGAGE");
	    System.out.println("--------");
	    System.out.println("Monthly Payments: " + mortgageFormatted);
	}

	public void printPaymentSchedule() {
	    System.out.println();
	    System.out.println("PAYMENT SCHEDULE");
	    System.out.println("----------------");
	    
	    for(double balance: calculator.getRemainingBalances())
	    	 System.out.println(currency.format(balance));
	    }

}
