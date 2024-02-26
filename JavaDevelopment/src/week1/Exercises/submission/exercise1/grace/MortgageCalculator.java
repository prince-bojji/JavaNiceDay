package week1.exercises.submission.exercise1.grace;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Mortgage Calculator
 * 
 * @author Grace
 * 
 */
public class MortgageCalculator {

    // Minimum values
    final static int MIN_PRINCIPAL = 1000;
    final static int MIN_ANNUAL_INTEREST = 1;
    final static int MIN_PERIOD = 1;

    // Maximum values
    final static int MAX_PRINCIPAL = 1000000;
    final static int MAX_ANNUAL_INTEREST = 30;
    final static int MAX_PERIOD = 30;

    /**
     * Implementing method
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input values
        int principal = getInput(scanner, "principal", MIN_PRINCIPAL, MAX_PRINCIPAL);
        int annualInterestRate = getInput(scanner, "interest", MIN_ANNUAL_INTEREST, MAX_ANNUAL_INTEREST);
        int period = getInput(scanner, "period", MIN_PERIOD, MAX_PERIOD);

        // Calculate mortgage
        double mortgage = calculateMortgage(principal, annualInterestRate, period);

        // Format and display the results
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Mortgage: $" + df.format(mortgage));

        scanner.close();
    }

    /**
     * Gets user input and evaluates the value if w/n the defined range
     * 
     * @params Scanner scanner, String variable, int minVal, int maxVal
     * @return valid value
     */
    static int getInput(Scanner scanner, String variable, int minVal, int maxVal) {

        int value = displayPromt(scanner, variable);

        if (checkValue(minVal, maxVal, value) == true)
            return value;
        else
            return value = getInput(scanner, variable, minVal, maxVal);
    }

    /**
     * Prompts user input based on indicated variable
     * 
     * @params Scanner input, String variable
     * @return raw value
     */
    static int displayPromt(Scanner scanner, String variable) {
        switch (variable) {
            case "principal":
                System.out.println("Principal: ");
                break;

            case "interest":
                System.out.println("Interest: ");
                break;

            case "period":
                System.out.println("Period: ");
                break;
        }

        int value = scanner.nextInt();
        return value;
    }

    /**
     * Checks if values are w/n range of defined values for minimum and maximum
     * 
     * @params raw value, minimum and maximum values
     * @return boolean, for validity result
     */
    static boolean checkValue(int minValidVal, int maxValidVal, int value) {
        if (value >= minValidVal && value <= maxValidVal)
            return true;
        else
            return false;
    }

    /**
     * Calculates Mortage
     * 
     * @params principal, annual interest, period
     * @return mortgage
     */
    static double calculateMortgage(int principal, int annualInterestRate, int period) {
        int totalMonths = period * 12;
        double monthlyInterest = ((double) annualInterestRate / 100) / 12;

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, totalMonths))
                / (Math.pow(1 + monthlyInterest, totalMonths) - 1);

        return mortgage;
    }
}
