public class Barista {
    private String name;

    public Barista(String name) {
        this.name = name;
    }

    /**
     * Short greeting when a customer arrives.
     */
    public void greet(Customer customer) {
        System.out.println(name + ": Welcome to Cafe Cafe, what can I get for you today?");
    }

    /**
     * React using one of 8 fixed choices. This is independent of whether the order
     * was correct or the customer's type.
     *
     * Choices:
     * 1) "You're welcome!"
     * 2) "Have a great day!"
     * 3) "See you next time!"
     * 4) "I’m sorry about that"
     * 5) "Ugh, I'm so done with this job..."
     * 6) No reaction
     * 7) Side-eye
     * 8) Smile
     */
    public void react(int choice, Customer customer) {
        String cName = customer.getName();
        switch (choice) {
            case 1:
                System.out.println(name + ": You're welcome!");
                break;
            case 2:
                System.out.println(name + ": Have a great day!");
                break;
            case 3:
                System.out.println(name + ": See you next time!");
                break;
            case 4:
                System.out.println(name + ": I’m sorry about that");
                break;
            case 5:
                System.out.println(name + ": Ugh, I'm so done with this job...");
                break;
            case 6:
                // no reaction: print nothing (or a blank line)
                System.out.println("");
                break;
            case 7:
                System.out.println(name + ": (side-eye)");
                break;
            case 8:
                System.out.println(name + ": (smiles)");
                break;
            default:
                System.out.println(name + ": (nods)");
        }
    }

}
