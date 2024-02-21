package week1.exercises.submission.exercise2.jehan;

import java.text.DecimalFormat;

public class MortgageReport {
	
	private MortgageCalculator calculator;
	DecimalFormat decimalFormat = new DecimalFormat("$#.##");

	public MortgageReport(MortgageCalculator calculator) {
		this.calculator = calculator;
	}

	public void printMortgage() {
	    double mortgage = calculator.calculateMortgage();
	    String mortgageFormatted = decimalFormat.format(mortgage);
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
	    	 System.out.println(decimalFormat.format(balance));
	}
	
}
