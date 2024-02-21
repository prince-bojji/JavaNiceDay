package week1.OOP.encapsulation;

/*
* Encapsulation - hiding data from direct access (Reduce complexity + increase reusability).
*/

public class Main {
	public static void main(String[] args) {
		// Constructor initialization
		Character_ character = new Character_(123000, 835, 825, 28, 192); 

		/*
		* Accessing Attributes
		* Now we cannot access the attributes of Character_ class because they are private.
		*/
		
		// Setters  as you observe name is not initialized in the constructor we can set it by using setters.
		character.setName("Kaeya");
		
		// Getters we can get the what value we want using getters even it is private.
		int elementalMastery = character.getElementalMastery();
		System.out.println("Elemental Mastery : "+elementalMastery);
			
		// Accessing the method in Character_ Class.
		character.showAttributes();		
	}
}
