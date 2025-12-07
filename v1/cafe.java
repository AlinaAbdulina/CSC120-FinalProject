public class cafe{
    public static void main(String[] args) {
        System.out.println("Welcome to --- Cafe!");
        System.out.println("You are the barista and your task is to survive the day.");
        // call customer.java for first customer 
        System.out.println("");
    }
}

class MenuItem {
    String name;
    double price;

    MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class CafeMenu {
    public static void main(String[] args) {
        // array of objects in menu 
        MenuItem[] menu = {
            new MenuItem("Espresso", 2.50),
            new MenuItem("Cappuccino", 3.25),
            new MenuItem("Latte", 3.75),
            new MenuItem("Mocha", 4.00),
            new MenuItem("Tea", 2.00),
            new MenuItem("Croissant", 2.75),
            new MenuItem("Muffin", 2.50),
            new MenuItem("Bagel", 2.25),
            new MenuItem("Sandwich", 5.50),
            new MenuItem("Salad", 6.00)
        };

        // Print the menu
        System.out.println("Welcome to -- Café!");
        System.out.println("Today's Menu:");
        for (MenuItem item : menu) {
            System.out.println(item.name + " - $" + item.price);
        }
    }
}