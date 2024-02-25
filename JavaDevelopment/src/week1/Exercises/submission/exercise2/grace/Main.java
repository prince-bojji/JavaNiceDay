package week1.Exercises.submission.exercise2.grace;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static String name;
    static int pizzaNum;
    static int[] pizzaSize = { 100, 200, 300, 400 };
    static Scanner sc = new Scanner(System.in);

    static void print(String stmt) {
        System.out.print(stmt);
    }

    static void println(String stmt) {
        System.out.println(stmt);
    }

    static void makePizza() {
        print("How many pizza would you like to buy?  ");
        pizzaNum = sc.nextInt();

        Pizza[] pizza = new Pizza[pizzaNum];

        for (int pizzaNo = 0; pizzaNo < pizza.length; pizzaNo++) {
            int pizzaSizeAns;
            int pizzaSizeAmt;
            int pizzaFlavorAns;
            String pizzaFlavor;
            char toppingsAns;
            int[] chosenTops = new int[4];
            ArrayList<String> toppings = new ArrayList<String>();
            ArrayList<String> drinks = new ArrayList<String>();

            // Object instantiation
            pizza[pizzaNo] = new Pizza();

            println("\nPizza #" + (pizzaNo + 1));

            println("Pizza Size  ");

            println("[1] 10\" - 100php");
            println("[2] 12\" - 200php");
            println("[3] 14\" - 300php");
            println("[4] 16\" - 400php");

            print("Chosen Pizza Size    :   ");
            pizzaSizeAns = sc.nextInt();

            pizzaSizeAmt = pizza[pizzaNo].pizzaSizeAmt(pizzaSizeAns);
            println("Amount: " + pizzaSizeAmt + "\n");

            println("Pizza Flavor ");

            println("[1] Pepperoni");
            println("[2] Vegetarian");
            println("[3] Hawaiian");
            println("[4] All Meat");

            print("Chosen Pizza Flavor  :   ");
            pizzaFlavorAns = sc.nextInt();
            sc.nextLine();
            pizzaFlavor = pizza[pizzaNo].pizzaFlavor(pizzaFlavorAns);
            println("Flavor: " + pizzaFlavor + "\n");

            print("Do you want to add toppings? ");
            toppingsAns = sc.next().charAt(0);

            if (toppingsAns == 'Y' || toppingsAns == 'y') {
                int toppingNo = 0;
                while (toppingsAns == 'Y' || toppingsAns == 'y') {
                    println("\nPizza Toppings");
                    println("[1] Mushroom");
                    println("[2] Extra Cheese");
                    println("[3] Sausage");
                    println("[4] Onion");

                    print("Chosen toppings  :   ");
                    int topans = sc.nextInt();

                    // Check for duplicate topping
                    boolean topFound = false;
                    for (int topping : chosenTops) {
                        if (topping == topans) {
                            topFound = true;
                            break;
                        }
                    }

                    if (topFound == true)
                        println("Already ordered.");
                    else {
                        chosenTops[toppingNo] = topans;
                        toppingNo++;
                    }

                    print("\nDo you want another topping?");
                    toppingsAns = sc.next().charAt(0);
                }
            } else {
                println("No toppings.");
            }

            for (int topping : chosenTops) {
                if (topping != 0) {
                    String topName = pizza[pizzaNo].pizzaToppings(topping);
                    println("Toppings: " + topName);
                    toppings.add(topName);
                }
            }

            print("\nDo you want to add drinks? ");
            toppingsAns = sc.next().charAt(0);

            if (toppingsAns == 'Y' || toppingsAns == 'y') {
                while (toppingsAns == 'Y' || toppingsAns == 'y') { // while
                    println("Pizza Toppings");
                    println("[1] Coca-Cola");
                    println("[2] Sprite");
                    println("[3] Juice");
                    println("[4] Mountain Dew");

                    print("Chosen drinks  :   ");
                    int drinkans = sc.nextInt();

                    String drink = pizza[pizzaNo].pizzaDrinks(drinkans);
                    println("Drinks: " + drink);
                    drinks.add(drink);

                    print("\nDo you want another drink?");
                    toppingsAns = sc.next().charAt(0);
                }
            } else {
                println("No drinks");
            }

            pizza[pizzaNo] = new Pizza(pizzaSizeAns, pizzaFlavorAns, toppings, drinks);

            for (int x : chosenTops) {
                System.out.println(x);
            }
        }

        float TotalBill = 0;

        for (int i = 0; i < pizza.length; i++) {
            pizza[i].displayReceipt();
            TotalBill += pizza[i].Total;
        }
        DecimalFormat deci = new DecimalFormat("0.00");
        println("\nTotal Bill :   " + deci.format(TotalBill) + "\n\n");
    }

    public static void main(String[] args) {
        char ans;

        print("Please Enter Your Name   : ");
        name = sc.nextLine();
        println("Welcome, " + name.replace(name.substring(0, 1), name.substring(0, 1).toUpperCase()) + "!");

        print("Do You Want To Buy Pizza?    ");
        ans = sc.next().charAt(0);

        if (ans == 'Y' || ans == 'y') {
            makePizza();
        } else {
            print("Are you sure you do not want to order?   ");
            ans = sc.next().charAt(0);

            if (ans == 'N' || ans == 'n') {
                makePizza();
            } else
                System.exit(0);
        }
    }
}
