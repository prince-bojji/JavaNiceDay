package week1.exercises.submission.exercise2.grace;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Pizza {
    static final int TOPPINGS_PRICE = 25;
    static final int DRINKS_PRICE = 50;
    int pizzaSizeAns;
    int pizzaFlavorAns;
    ArrayList<String> toppings = new ArrayList<String>();
    ArrayList<String> drinks = new ArrayList<String>();

    int pizzaSizeAmt;
    int topTot;
    int drinksTot;
    float Total;

    Pizza() {
    }

    Pizza(int pizzaSizeAns, int pizzaFlavorAns, ArrayList<String> toppings, ArrayList<String> drinks) {
        this.pizzaSizeAns = pizzaSizeAns;
        this.pizzaFlavorAns = pizzaFlavorAns;
        this.toppings = toppings;
        this.drinks = drinks;
    }

    int pizzaSizeAmt(int pizzaNo) {
        int result = 0;

        if (pizzaNo == 1)
            result = 100;
        else if (pizzaNo == 2)
            result = 200;
        else if (pizzaNo == 3)
            result = 300;
        else if (pizzaNo == 4)
            result = 400;

        return result;
    }

    String pizzaFlavor(int flavorNo) {
        String result = "";
        switch (flavorNo) { // switch case statement
            case 1:
                result = "Pepperoni";
                break;
            case 2:
                result = "Vegetarian";
                break;
            case 3:
                result = "Hawaiian";
                break;
            case 4:
                result = "All Meat";
                break;
        }
        return result;
    }

    String pizzaToppings(int toppingsNo) {
        String result = "";
        switch (toppingsNo) {
            case 1:
                result = "Mushroom";
                break;
            case 2:
                result = "Extra Cheese";
                break;
            case 3:
                result = "Sausage";
                break;
            case 4:
                result = "Onion";
                break;
        }
        return result;
    }

    String pizzaDrinks(int drinksNo) {
        String result = "";
        switch (drinksNo) {
            case 1:
                result = "Sprite";
                break;
            case 2:
                result = "Coca-Cola";
                break;
            case 3:
                result = "Juice";
                break;
            case 4:
                result = "Mountain Dew";
                break;
        }
        return result;
    }

    float compute() {
        pizzaSizeAmt = pizzaSizeAmt(pizzaSizeAns);
        topTot = toppings.size() * TOPPINGS_PRICE;
        drinksTot = drinks.size() * DRINKS_PRICE;

        return pizzaSizeAmt + topTot + drinksTot;
    }

    void displayReceipt() {
        // Receipt
        DecimalFormat deci = new DecimalFormat("0.00");
        Total = compute();

        System.out.println("\n\n===============================");
        System.out.println("                        Amount");
        System.out.println("Pizza Size      :   " + pizzaSizeAns + "\t" + deci.format(pizzaSizeAmt));
        System.out.println("Pizza Flavor    :   " + pizzaFlavorAns);
        System.out.println("Toppings        :   " + toppings.size() + "\t" + deci.format(topTot));
        for (String topping : toppings) {
            System.out.println("   " + topping);
        }
        System.out.println("Drinks          :   " + drinks.size() + "\t" + deci.format(drinksTot));
        for (String drink : drinks) {
            System.out.println("   " + drink);
        }
        System.out.println("Total           :       " + deci.format(Total));
    }
}
