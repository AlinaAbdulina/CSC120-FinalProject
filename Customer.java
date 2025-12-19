
////customers reactions
//customer comes in radnomly 

//karen final boss complains no matter what and if her order is wrong she blows up the cofee shop.

//karen throws coffee if wrong but huffs and puffs if its right

// This is to randomize customers.
import java.util.Random;

// This is for importing and displaying images GUI.
import java.awt.*;
import javax.swing.*;
/**
 * Represents a customer in the cafe game.
 */
public class Customer {

    private String name;
    private String type; // karen, finalBoss, preformativeMale, financeBro, quietGuy
    private Coffee ordered;

    public Customer(String name, String type, Coffee ordered) {
        this.name = name;
        this.type = type;
        this.ordered = ordered;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Coffee getOrderedCoffee() {
        return ordered;
    }

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
                    showImage("imgs/PerformativeMaleV2.jpg");
                    try {
                        // pauses execution for 1 second
                        Thread.sleep(1000); 
                    } catch (InterruptedException e) {
                        // handle the case where the sleep is interrupted
                        Thread.currentThread().interrupt(); 
                        System.err.println(" ");
                    }
                    System.out.println(name + " sips: \"hmph, not as good as Blank Street..\"");
                } else {
                    System.out.println(name + " sighs: \"yumm this taste very alternative y2k matcha labubu.\"");
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

    public static Coffee randomCoffee() {
        String[] menu = { "Americano", "Cappuccino", "Matcha", "Iced Latte", "Tea"};
        Random rand = new Random();
        return new Coffee(menu[rand.nextInt(menu.length)]);
    }

    // Open a small Swing window to display an image. This runs on the EDT
    // and returns only after the window is created so callers can continue.
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
