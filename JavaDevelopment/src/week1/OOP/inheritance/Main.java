package week1.OOP.inheritance;

/*
 * Inheritance - used to inherit attributes and methods from one class to another.
 */

public class Main {
	public static void main(String[] args) {
		Character_ character = new Character_("Beido", 18700, 1025, 1029, 220, 280);
		Cryo cryo = new Cryo("Kaeya", 12300, 875, 825, 129, 28, "Frostgnaw", "Cryo");
		
		character.showAttributes();
		cryo.showAttributes();
	}
}
