package week1.OOP.objectsClass;

/*
* Object - is an instance of a class.
* Instantiation - the process of creating objects.
*/

public class Main {
	public static void main(String[] args) {
		// Constructor initialization
		Character_ character = new Character_("Kaeya", 123000, 835, 825, 28, 192); 

		/*
		* Accessing Attributes
		* character.name = "Kaeya";
		* character.hp = 12300;
		* character.atk = 835;
		* character.def = 825;
		* character.elementalMastery = 28;
		* character.maxStamina = 192;
		* 
		* It's better to make a constructor than initializing it individually.
		*/

		// Accessing method in Character_ Class.
		character.showAttributes(); 	
	}
}
