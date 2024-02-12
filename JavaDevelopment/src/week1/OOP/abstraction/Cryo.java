package week1.OOP.abstraction;

public class Cryo extends Character{
	
	public Cryo(String name) {
		super(name);
	}
	
	public void skill() {
		System.out.println("Skill : Frostgnaw");
	}
	
	public void element() {
		System.out.println("Element : Cryo");
	}
	
	public void printName() {
		System.out.println("Name : "+name);
	}
}
