package week1.OOP.encapsulation;

//Class - act as the blueprint or template.
public class Character_ {
	/*
	 * Attributes- these are the global variable inside the class.
	 * Private attributes to avoid direct access in the main class.
	 */
	private String name;
	private int hp;
	private int atk;
	private int def;
	private int elementalMastery;
	private int maxStamina;
	
	// Constructor - it is used to initialize the attributes of an object.
	public Character_(int hp, int atk, int def, int elementalMastery, int maxStamina) {	
		this.hp = hp;  // this keyword - refers to the class itself.
		this.atk = atk;
		this.def = def;
		this.elementalMastery = elementalMastery;
		this.maxStamina = maxStamina;
	}
	
		// Object Methods - are methods inside the object class.
		public void showAttributes() {
			System.out.println("Name : "+name);
			System.out.println("HP   : "+hp);
			System.out.println("ATK  : "+atk);
			System.out.println("DEF  : "+def);
			System.out.println("Elemental Mastery : "+elementalMastery);
			System.out.println("Max Stamina : "+maxStamina);
		}
		
		// Setters - used to set encapsulated variables.
		public void setName(String name) {
			this.name = name;
		}
		
		// Getters - used to get encapsulated variables.
		public int getElementalMastery() { // You can get what ever you wanted using getters.
			return elementalMastery;
		}
}

