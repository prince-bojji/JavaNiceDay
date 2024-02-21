package week1.exercises.submission.exercise2.jehan;

public class Main {
 	public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal: ", 1000, 1000000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        var calculator = new MortgageCalculator(principal, annualInterest, years);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }  
}

