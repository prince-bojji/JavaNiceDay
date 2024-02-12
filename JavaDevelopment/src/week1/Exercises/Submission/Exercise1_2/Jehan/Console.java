package week1.Exercises.Submission.Exercise1_2.Jehan;

import java.util.Scanner;

public class Console {

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
}
