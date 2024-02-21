package week1.exercises.submission.exercise1.jehan;

import java.util.Scanner;
import java.text.DecimalFormat;

public class MortgageCalculator {
    private int principal;
	private float annualInterest;
	private byte years;

	private final static byte PERCENT = 100;
	private final static byte MONTHS_IN_YEAR = 12;

	public MortgageCalculator(int principal, float annualInterest, byte years) {
		this.principal = principal;
		this.annualInterest = annualInterest;
		this.years = years;
	}
	
	//Driver
    public static void main(String[] args){
        int principal = (int) readNumber("Principal: ", 1000, 1000000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);

        var calculator = new MortgageCalculator(principal, annualInterest, years);
        calculator.printMortgage();
    }

	//Validate user input for a number between min and max values.
    public static double readNumber(String prompt, double min, double max) {
        Scanner s = new Scanner(System.in);
		double value;
	    while (true) {
	        System.out.print(prompt);
	        value = s.nextFloat();
	        if (value >= min && value <= max)
	            break;
	        System.out.println("Enter a value between "+ min + " and " + max);
	    }
	    return value;
	}

	//Calculate the total monthly payment (mortgage).
	public double calculateMortgage() {
	    float monthlyInterest = getMonthlyInterest();
	    short numberOfPayments = getNumberOfPayments();
	
		double mortgage = principal
	            * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
	            / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
		
		return mortgage;
	}
	
	//Calculate the monthly interest rate.
	private float getMonthlyInterest() {
		float monthlyInterest = annualInterest / MortgageCalculator.PERCENT / MortgageCalculator.MONTHS_IN_YEAR;
		return monthlyInterest;
	}
	
	//Calculate the number of payments.
	private short getNumberOfPayments() {
		short  numberOfPayments = (short)(years * MortgageCalculator.MONTHS_IN_YEAR);
		return numberOfPayments;
	}
	
	//Get years
	public short getYears() {
		return years;
	}
    
	//Display result (mortgage)
    public void printMortgage(){
		DecimalFormat decimalFormat = new DecimalFormat("$#.##");
		double mortgage = calculateMortgage();
		String mortgageFormatted = decimalFormat.format(mortgage);
		System.out.println("MORTGAGE: " + mortgageFormatted);
    }
}
