package week1.OOP.abstraction;

/*
 * Abstraction- it is an OOP technique that hide certain details and only show the important information.
 */

public class Main {
	public static void main(String[] args) {
		Cryo cryo = new Cryo("Kaeya");
		
		cryo.printName();
		cryo.element();
		cryo.skill();
	}
}
