import java.util.Random;
import java.util.Scanner;

/**
 * The main class for the Cafe Cafe game.
 * <p>
 * This class contains the game loop where a player is the barista,
 * serves customers, and reacts to their responses
 * introduction, barista creation, menu display, customer generation, order serving,
 * and barista reactions.
 */
public class Cafe {
    
    /**
     * The main method that starts the Cafe Cafe game.
     * <p>
     * It initializes the game, prompts the player to accept the barista role,
     * creates a Barista object, displays the menu, spawns random customers,
     * processes orders, and handles barista reactions. The game loop continues
     * until the player chooses to quit or the barista quits.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // initialize introduction of game 
        Scanner scanner = new Scanner(System.in);
        System.out.println("░░      ░░░░      ░░░        ░░        ░░░░░░░░░      ░░░░      ░░░        ░░        ░\r\n" + //
                        "▒  ▒▒▒▒  ▒▒  ▒▒▒▒  ▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒  ▒▒  ▒▒▒▒  ▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒\r\n" + //
                        "▓  ▓▓▓▓▓▓▓▓  ▓▓▓▓  ▓▓      ▓▓▓▓      ▓▓▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓▓▓  ▓▓▓▓  ▓▓      ▓▓▓▓      ▓▓▓\r\n" + //
                        "█  ████  ██        ██  ████████  ██████████████  ████  ██        ██  ████████  ███████\r\n" + //
                        "██      ███  ████  ██  ████████        █████████      ███  ████  ██  ████████        █\r\n" + //
                        "                                                                                      ");
        System.out.println("Welcome to Cafe Cafe!");
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

        // Ask the player for their barista name
        System.out.println("Please enter your name as the barista (or press Enter to use 'Barista'):");
        String baristaName = scanner.nextLine().trim();
        if (baristaName.isEmpty()) {
            baristaName = "Barista";
        }
        Barista barista = new Barista(baristaName);

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
        String[] types = {"quietGuy", "karen", "financeBro", "performativeMale", "finalBoss"};

        boolean cafeOpen = true;

        while (cafeOpen){
        
        String name = names[rand.nextInt(names.length)];
        String type = types[rand.nextInt(types.length)];
        Customer customer = new Customer(name, type, Customer.randomCoffee());

        System.out.println("\nA customer arrives: " + customer.getName() + " (" + customer.getType() + ")");
        // barista greets the arriving customer
        barista.greet(customer);
        System.out.println("They ordered: " + customer.getOrderedCoffee());
        System.out.println("Type the drink you serve (press Enter or type 'auto' to serve a random drink):");

        String servedInput = scanner.nextLine();
        String served;
        if (servedInput == null || servedInput.trim().isEmpty() || servedInput.trim().equalsIgnoreCase("auto")) {
            served = Customer.randomCoffee().getName();
            System.out.println("You served: " + served);
        } else {
            served = servedInput.trim();
        }

        boolean correct = served.equalsIgnoreCase(customer.getOrderedCoffee().getName());
        customer.react(correct);

        // Let the player choose one of 8 barista reactions (not tied to correctness)
        System.out.println();
        System.out.println("Choose the barista's reaction to the customer's response:");
        System.out.println("1) \"You're welcome!\" \n2) \"Have a great day!\" \n3) \"See you next time!\" \n4) \"I’m sorry about that\" \n5) \"Ugh, I'm so done with this job...I QUIETT\" \n6) No reaction \n7) Side-eye \n8) Smile");
        String reactInput = scanner.nextLine().trim();
        int reactChoice = 6; // default: no reaction
        if (!reactInput.isEmpty()) {
            try {
                reactChoice = Integer.parseInt(reactInput);
            } catch (NumberFormatException e) {
                // keep default if parsing fails
                reactChoice = 6;
            }
        }
        barista.react(reactChoice, customer);
        // if player chose reaction 5 (barista quits), end the game immediately
        if (reactChoice == 5) {
            System.out.println("Cafe is closed forever...");
            break;
        }

        System.out.println("Serve another Customer? (yes/no)"); //add quit
        String another = scanner.nextLine().trim();
        if (another.equalsIgnoreCase("no") ){
            cafeOpen = false;
            System.out.println("Cafe is Closed for the day. Goodbye!");
            }
        }

        scanner.close();
    }
}   