
////customers reactions
//customer comes in radnomly 

//karen final boss complains no matter what and if her order is wrong she blows up the cofee shop.

//karen throws coffee if wrong but huffs and puffs if its right

//walk out of store 
//customer cant pick up coffee until its ready

//bariasta can quit

import java.util.Random;

/**
 * Represents a customer in the cafe game.
 * Each customer has a name, type of person, and a desired coffee.
 * Customers react differently depending on their type and whether the drink is
 * correct.
 */
public class Customer {

    private String name;
    private String type; // karen, finalBoss, preformativeMale, financeBro, quietGuy
    private Coffee desired;

    public Customer(String name, String type, Coffee desired) {
        this.name = name;
        this.type = type;
        this.desired = desired;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Coffee getDesiredCoffee() {
        return desired;
    }

    /**
     * Reacts to the coffee being served.
     *
     * @param correct true if the coffee served matches the desired coffee, false
     *                otherwise
     */
    public void react(boolean correct) {
        switch (type) {
            case "karen":
                if (correct) {
                    System.out.println(name + " reluctantly nods: \"Fine… this is correct.\"");
                } else {
                    System.out.println(name + " throws the drink at the barista! \"This is wrongggggg!\"");
                }
                break;

            case "finalBoss":
                if (correct) {
                    System.out.println(name + " smirks: \"Acceptable.\"");
                } else {
                    System.out.println(name + " whispers hmmm...");
                    System.out.println(" BOOM! The cafe is destroyed!");
                }
                break;

            case "preformativeMale":
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
     * Returns a random Coffee object for placeholder orders.
     *
     * @return a random Coffee
     */
    public static Coffee randomCoffee() {
        String[] menu = { "Latte", "Mocha", "Black Coffee", "Cappuccino", "Tea", "Matcha" };
        Random rand = new Random();
        return new Coffee(menu[rand.nextInt(menu.length)]);
    }
}