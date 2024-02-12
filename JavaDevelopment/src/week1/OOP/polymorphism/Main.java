package week1.OOP.polymorphism;

/*
 * Polymorphism - it an OOP technique that utilizes inheritance to create 1 class and make several classes inherit from that so it can take many forms.
 */

public class Main {
	public static void main(String[] args) {
		Cryo cryo = new Cryo("Kaeya", 12300, 875, 825, 129, 28, "Frostgnaw", "Cryo");
		Hydro hydro = new Hydro("Barbara", 1000, 50, 100, 20, 10, "Let the snow begin", "Hydro");
		Pyro pyro = new Pyro("Amber", 3240, 243, 50, 0, 20, "Explosive Puppet", "Pyro");
		
		cryo.showAttributes();
		hydro.showAttributes();
		pyro.showAttributes();
	}
}
