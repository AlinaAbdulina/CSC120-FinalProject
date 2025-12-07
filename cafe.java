import java.util.Scanner;
import java.util.Random;

public class Cafe {
    public static void main(String[] args) {
        // initialize introduction of game 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to --- Cafe!");
        System.out.println("We've been looking for a new hire!");
        System.out.println("You look like you have a lot of time on your hands.. Are you willing to take on the challenge of being our new barista?");

        String accept = scanner.nextLine();
        boolean start = accept.equalsIgnoreCase("yes"); 

        if (start) {
            System.out.println("You're hired!");
        } else {
            System.out.println("Go away then.");
            scanner.close();
            System.exit(0);
        }

        System.out.println("\n" +
            "====================================================\n" +
            "                      -- MENU --\n" +
            "1. Americano    - $4.5\n" +
            "2. Cappuccino   - $3\n" +
            "3. Matcha       - $25\n" +
            "4. Iced Latte   - $5\n" +
            "5. Tea          - $4\n" +
            "====================================================\n");

        // Minimal integration with Customer: spawn one random customer and handle a single serve
        Random rand = new Random();
        String[] names = {"Kai", "Timmy", "Taylor", "Judith", "Chad", "Trisha Paytas", "Seraphina", "Luna", "Dicky", "Miracle"};
        String[] types = {"quietGuy", "karen", "financeBro", "preformativeMale", "finalBoss"};

        String name = names[rand.nextInt(names.length)];
        String type = types[rand.nextInt(types.length)];
        Customer customer = new Customer(name, type, Customer.randomCoffee());

        System.out.println("\nA customer arrives: " + customer.getName() + " (" + customer.getType() + ")");
        System.out.println("They ordered: " + customer.getDesiredCoffee());
        System.out.println("Type the drink you serve or type 'auto' to serve a random drink:");

        String served = scanner.nextLine().trim();
        if (served.equalsIgnoreCase("auto")) {
            served = Customer.randomCoffee().getName();
            System.out.println("You served: " + served);
        }

        boolean correct = served.equalsIgnoreCase(customer.getDesiredCoffee().getName());
        customer.react(correct);

        scanner.close();
    }
}