/**
 * Represents coffee  in the Cafe game.
 * <p>
 * Each Coffee (object) has a name and can be displayed or retrieved.
 */
public class Coffee {

     /** The name of the coffee (e.g., Americano, Cappuccino). */
    private String name;

    /**
     * Constructs a new Coffee with the specified name.
     *
     * @param name the name of the coffee
     */
    public Coffee(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the coffee.
     *
     * @return the coffee's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a string representation of the Coffee object.
     * <p>
     * Overrides the default toString() method to return the coffee's name.
     *
     * @return the name of the coffee
     */
    @Override
    public String toString() {
        return name;
    }
}