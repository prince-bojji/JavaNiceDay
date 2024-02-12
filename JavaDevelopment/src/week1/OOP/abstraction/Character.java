package week1.OOP.abstraction;

// Abstract Class - it cannot be instantiated, to access it you need to inherit from another class.
 public abstract class Character { 
	 public String name;
	 
	 public Character(String name) {
		 this.name = name;
	 }

	 /*
	  * Abstract Methods - can only be used inside an abstract class it is a method
	  * without a body needs to  be overridden.
	  */
	  
     public abstract void skill();
     
     public abstract void element();
}
