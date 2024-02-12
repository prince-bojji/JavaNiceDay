package week1.OOP.polymorphism;

/*
 * Subclass - the class who will inherit the attributes and methods from a superclass.
 * extends keyword - used after the class name and it indicates that the class will inherit from another class.
 * super keyword - can only be used by a subclass and it is used to call their super class so we can access their constructors, attributes, and methods.
 */

public class Cryo extends Character_{
	private String skill;
	private String element;
	
	// Constructor Overloading (add the super(arguments); //add attributes
	public Cryo(String name, int hp, int atk, int def, int elementalMastery, int maxStamina, String skill, String element) {
		super(name, hp, atk, def, elementalMastery, maxStamina);
		this.skill = skill;
		this.element = element;
	}
	
	// Methods Overloading (add the super.methodName(); //add functionalities
	public void showAttributes() {
		super.showAttributes();
		System.out.println("Skill : "+skill);
		System.out.println("Element : "+element);
	}
}
