// This is to randomize customers.
import java.util.Random;
import javax.swing.*;


/**
 * Represents a customer in the Cafe game.
 * <p>
 * Each customer has a name, a type, and an ordered coffee. The customer can react
 * differently depending on their type and whether they received the correct order.
 */
public class Customer {

    /** The name of the customer. */
    private String name;

     /** The type of customer (e.g., karen, finalBoss, performativeMale, financeBro, quietGuy). */
    private String type;

    /** The coffee this customer has ordered. */
    private Coffee ordered;

    /**
     * Constructs a new Customer with the specified name, type, and their coffee order
     *
     * @param name the name of the customer
     * @param type the type of customer
     * @param ordered the coffee this customer has ordered
     */
    public Customer(String name, String type, Coffee ordered) {
        this.name = name;
        this.type = type;
        this.ordered = ordered;
    }

     /**
     * Returns the customer's name.
     *
     * @return the customer's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the customer's type.
     *
     * @return the type of customer
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the coffee the customer ordered.
     *
     * @return the ordered Coffee object
     */
    public Coffee getOrderedCoffee() {
        return ordered;
    }

    /**
     * Makes the customer react based on whether the order was correct.
     *
     * @param correct true if the customer received the correct coffee, false otherwise
     */
    public void react(boolean correct) {
        switch (type) {
            case "karen":
                if (correct) {
                    System.out.println(name + " reluctantly nods: \"Fine… this is correct.\"");
                } else {
                    System.out.println(name + " throws the drink at the barista! \"This is WRONG! I am leaving a BAD review on YELP.\"");
                }
                break;

            case "finalBoss":
                if (correct) {
                    System.out.println(name + " growls and the aura in the cafe shifts suddenly: \"Good enough.\"");
                } else {
                    System.out.println(name + "'s aura darkens, the lights in the cafe turns off, you hear something ticking...");
                    showImage("imgs/KARENWCOFFEE.jpg");
                    System.out.println("You messed with the wrong person...");
                     try {
                        // pauses execution for 3 seconds
                        Thread.sleep(3000); 
                    } catch (InterruptedException e) {
                        // handle the case where the sleep is interrupted
                        Thread.currentThread().interrupt(); 
                        System.err.println(" ");
                    }
                    System.out.println("Next time you won't make a silly mistake like this...");
                    showImage("imgs/KARENV2.jpg");
                    try {
                        // pauses execution for 3 seconds
                        Thread.sleep(3000); 
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); 
                        System.err.println(" ");
                    }
                    showImage("imgs/REDBUTTON.jpg");
                    try {
                        // pauses execution for 2 seconds
                        Thread.sleep(2000); 
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); 
                        System.err.println(" ");
                    }
                    System.out.println("            .-'''-.        .-'''-.                        ___   \r\n" + //
                                                "           '   _    \\     '   _    \\                   .'/   \\  \r\n" + //
                                                "/|       /   /` '.   \\  /   /` '.   \\  __  __   ___   / /     \\ \r\n" + //
                                                "||      .   |     \\  ' .   |     \\  ' |  |/  `.'   `. | |     | \r\n" + //
                                                "||      |   '      |  '|   '      |  '|   .-.  .-.   '| |     | \r\n" + //
                                                "||  __  \\    \\     / / \\    \\     / / |  |  |  |  |  ||/`.   .' \r\n" + //
                                                "||/'__ '.`.   ` ..' /   `.   ` ..' /  |  |  |  |  |  | `.|   |  \r\n" + //
                                                "|:/`  '. '  '-...-'`       '-...-'`   |  |  |  |  |  |  ||___|  \r\n" + //
                                                "||     | |                            |  |  |  |  |  |  |/___/  \r\n" + //
                                                "||\\    / '                            |__|  |__|  |__|  .'.--.  \r\n" + //
                                                "|/\\'..' /                                              | |    | \r\n" + //
                                                "'  `'-'`                                               \\_\\    / \r\n" + //
                                                "                                                        `''--'  ");
                    showImage("imgs/explode!!!.gif");
                    System.out.println("The cafe exploded... Better luck next time.");
                    System.out.println("");
                    try {
                        // pauses execution for 10 seconds
                        Thread.sleep(10000); 
                    } catch (InterruptedException e) {
                        // handle the case where the sleep is interrupted
                        Thread.currentThread().interrupt(); 
                        System.err.println(" ");
                    }
                    System.exit(0);
                }
                break;

            case "performativeMale":
                if (correct) {
                    System.out.println(name + " sips: \"yum\"");
                } else {
                    System.out.println(name + " sighs: \"yumm.\"");
                }
                break;

            case "financeBro":
                if (correct) {
                    System.out.println(name + " nods approvingly: \"Solid.\"");
                } else {
                    System.out.println(name + " ugh: \"I expected better service…\"");
                }
                break;

            case "quietGuy":
                if (correct) {
                    System.out.println(name + " smiles quietly.");
                } else {
                    System.out.println(name + " frowns but says nothing.");
                }
                break;

            default:
                System.out.println(name + " reacts normally.");
        }
    }

     /**
     * Returns a random Coffee object from the menu.
     *
     * @return a random Coffee
     */
    public static Coffee randomCoffee() {
        String[] menu = { "Americano", "Cappuccino", "Matcha", "Iced Latte", "Tea"};
        Random rand = new Random();
        return new Coffee(menu[rand.nextInt(menu.length)]);
    }

    /**
     * Open a small Swing window to display an image of customer reaction.
     * <p>
     * This method is private and runs on the Event Dispatch Thread (EDT). It pauses
     * and returns only after the window is created so callers can continue.
     *
     * @param path the file path of the image to display
     */
    private void showImage(String path) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                ImageIcon icon = new ImageIcon(path);
                if (icon.getIconWidth() <= 0) {
                    System.out.println("Image not found or invalid: " + path);
                    return;
                }
                JFrame f = new JFrame("Customer Reaction");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JLabel lbl = new JLabel(icon);
                f.getContentPane().add(lbl);
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            });
        } catch (Exception ex) {
            System.out.println("Could not display image: " + ex.getMessage());
        }
    }
}