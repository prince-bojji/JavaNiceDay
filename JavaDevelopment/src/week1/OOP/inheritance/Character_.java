package week1.OOP.inheritance;

// Superclass - the class where we will inherit the attributes and methods from one class to another.
public class Character_ {
	// Attributes - these are the global variable inside the class.
	private String name;
	private int hp;
	private int atk;
	private int def;
	private int elementalMastery;
	private int maxStamina;
	
	// Constructor - it is used to initialize the attributes of an object.
	public Character_(String name, int hp, int atk, int def, int elementalMastery, int maxStamina) {
		this.name = name;	//. this keyword- refers to the class itself
		this.hp = hp;  
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
}

