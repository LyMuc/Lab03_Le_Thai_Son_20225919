public class Cart {
    public static final int MAX_ITEMS = 30;

    private DigitalVideoDisc[] orderedItems = new DigitalVideoDisc[MAX_ITEMS];
    private int itemsCount;
    private Authentication userRole;

    public Cart() {
        userRole = Authentication.Customer;
    }

    public void setUserRole(Authentication role) {
        this.userRole = role;
    }

    public float calculateTotalCost() {
        float total = 0.00f;
        for (int i = 0; i < itemsCount; i++) {
            total += orderedItems[i].getPrice();
        }
        return total;
    }

    public void displayCart() {
        StringBuilder output = new StringBuilder("************ CART ************\nItems list:\n");
        for (int i = 0; i < itemsCount; i++) {
            output.append(i + 1)
                  .append(".[").append(orderedItems[i].getName()).append("] - [")
                  .append(orderedItems[i].getGenre()).append("] - [")
                  .append(orderedItems[i].getProducer()).append("] - [")
                  .append(orderedItems[i].getDuration()).append("]: ")
                  .append(orderedItems[i].getPrice()).append(" $\n");
        }
        output.append("Total: ").append(calculateTotalCost()).append(" $\n");
        output.append("******************************\n");
        System.out.println(output);
    }

    public void findById(int id) {
        if (id > itemsCount) {
            System.out.println("No item found!");
        } else {
            System.out.println("Result: " + "[" + orderedItems[id - 1].getName() + "] - [" +
                               orderedItems[id - 1].getGenre() + "] - [" +
                               orderedItems[id - 1].getProducer() + "] - [" +
                               orderedItems[id - 1].getDuration() + "]: " +
                               orderedItems[id - 1].getPrice() + " $\n");
        }
    }

    public int addDiscToCart(DigitalVideoDisc disc) {
        if (userRole != Authentication.Customer) {
            System.out.println("You do not have permission to add items to the cart.");
            return 0;
        }
        if (itemsCount == MAX_ITEMS) {
            System.out.println("Cart is almost full. Cannot add more items.");
            return 0;
        }
        orderedItems[itemsCount] = disc;
        itemsCount++;
        System.out.println("DVD \"" + disc.getName() + "\" has been added!");
        return 1;
    }

    public int removeDiscFromCart(DigitalVideoDisc disc) {
        if (userRole != Authentication.Customer) {
            System.out.println("You do not have permission to remove items from the cart.");
            return 0;
        }
        if (orderedItems[0] == null) {
            System.out.println("Your cart is empty!");
            return 0;
        }
        for (int i = 0; i < itemsCount; i++) {
            if (orderedItems[i].equals(disc)) {
                for (int j = i; j < itemsCount - 1; j++) {
                    orderedItems[j] = orderedItems[j + 1];
                }
                orderedItems[itemsCount - 1] = null;
                itemsCount--;
                System.out.println("DVD \"" + disc.getName() + "\" removed successfully!");
                return 1;
            }
        }
        System.out.println("No matching DVD found!");
        return 0;
    }

    public void searchByName(String name) {
        for (int i = 0; i < itemsCount; i++) {
            if (orderedItems[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Result: " + "[" + orderedItems[i].getName() + "] - [" +
                                   orderedItems[i].getGenre() + "] - [" +
                                   orderedItems[i].getProducer() + "] - [" +
                                   orderedItems[i].getDuration() + "]: " +
                                   orderedItems[i].getPrice() + " $\n");
                return;
            }
        }
        System.out.println("No item found!");
    }

    public int addMultipleDiscsToCart(DigitalVideoDisc... discs) {
        if (userRole != Authentication.Customer) {
            System.out.println("You do not have permission to add items to the cart.");
            return 0;
        }
        int addedCount = 0;
        for (DigitalVideoDisc disc : discs) {
            if (itemsCount == MAX_ITEMS) {
                System.out.println("Cart is almost full. Cannot add more items.");
                break;
            }
            orderedItems[itemsCount] = disc;
            itemsCount++;
            System.out.println("DVD \"" + disc.getName() + "\" has been added!");
            addedCount++;
        }
        return addedCount;
    }

    public int addTwoDiscsToCart(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        if (userRole != Authentication.Customer) {
            System.out.println("You do not have permission to add items to the cart.");
            return 0;
        }
        if (itemsCount + 1 >= MAX_ITEMS) {
            System.out.println("Cart is almost full. Cannot add more items.");
            return 0;
        }
        orderedItems[itemsCount] = disc1;
        itemsCount++;
        System.out.println("DVD \"" + disc1.getName() + "\" has been added!");

        orderedItems[itemsCount] = disc2;
        itemsCount++;
        System.out.println("DVD \"" + disc2.getName() + "\" has been added!");
        return 2;
    }
}
