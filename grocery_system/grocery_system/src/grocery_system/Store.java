package grocery_system;

import java.util.Scanner;

// Define the Store class
public class Store {
    Scanner input = new Scanner(System.in);

    // Instance variables
    private final String name;
    private final int length = 100;
    private Products[] Product = new Products[length];
    private USERS[] Users = new USERS[length];
    private int counterUser = 0;
    private int counterProduct = 0;

    // Constructor
    public Store(String name) {
        this.name = name;
    }

   
    // Getter method for the name variable
    public String getName() {
        return name;
    }

    
    // Check if a product with the given ID exists in the Product array
    public boolean isExit(int x) {
        for (int i = 0; i < counterProduct; i++) {
            if (Product[i].getID() == x) {
                return true;
            }
        }
        return false;
    }

    
    // Add a product to the Product array
    public void addProduct(Products z) {
        if (counterProduct < Product.length) {
            Product[counterProduct++] = z;
        } else {
            System.out.println("Sorry we can't add this product!");
        }
    }

    
    // Remove a product with the given ID from the Product array
    public boolean removeProduct(int c) {
        if (isExit(c)) {
            for (int i = 0; i < counterProduct; i++) {
                if (Product[i].getID() == c) {
                    Product[i] = Product[counterProduct - 1];
                    Product[counterProduct - 1] = null;
                    counterProduct--;
                    return true;
                }
            }
        }
        return false;
    }

   
    // Calculate the total price of a list of products for a given customer
    public double totalPrice(USERS costmer, Products[] List) {
        double total = 0;
        if (costmer instanceof Customer) {
            for (Products ofelement : List) {
                double n;
                n = ofelement.getPrice();
                total += n;
            }
            if (((Customer) costmer).getCounter() > 2) {
                total -= ((total * 25) / 100);
                if (total < 0) {
                    total = total * -1;
                }
                return total;
            }
            if (total < 0) {
                total = total * -1;
            }
        }
        return total;
    }
}

/**
 * Allows a customer to purchase a list of products, prints the total price, and removes the products from the store.
 * @param u the user making the purchase
 * @param List the list of products being purchased
 */
public void Buy(USERS u, Products[] List) {
    // Check if the user is a customer
    if (u instanceof Customer) {
        // Check if all products in the list exist in the store
        for (Products p : List) {
            if (p != null) {
                if (isExit(p.getID()) == false) {
                    System.out.printf("Sorry the product %s does not exist in the store :\\", p.getName());
                    return;
                }
            }
        }

        // Print special or new customer message
        System.out.println();
        ((Customer) u).Speacialornew();
        
        // Calculate total price
        double a = totalPrice(u, List);

        // Print purchased products
        Print(u, List);

        // Print total price with or without discount
        if (((Customer) u).getCounter() > 2) {
            System.out.println("Total price (After Discount):" + a + "SR");
        } else {
            System.out.println("Total price :" + a + "SR");
        }

        // Print thank you message and remove purchased products
        System.out.println("thank you for coming ^-^");
        for (Products p : List) {
            if (removeProduct(p.getID()));
            continue;
        }
    } else {
        // Print error message if the user is not a customer
        System.out.println(" Sorry only Customer can buy the products >_< ");
    }
}

/**
 * Adds a user to the system.
 * @param user the user to be added
 */
public void addUSERS(USERS user) {
    // Check if there is room to add the user
    if (counterUser < Users.length) {
        Users[counterUser++] = user;
    } else {
        System.out.println("Sorry, we can't add this user!");
    }
}

/**
 * Prompts the user to enter a user ID and opens the manager's frame if the user ID belongs to a manager.
 */
public void managerremove() {
    System.out.println("\n Enter your User ID: ");

    // Check if the user entered a valid integer user ID
    if (input.hasNextInt()) {
        int n = input.nextInt();
        for (USERS a : Users) {
            if (a != null && n > 1000) {
                // Check if the user ID belongs to a manager and open the manager's frame
                if (n == a.getID()) {
                    if (a instanceof Manager) {
                        new Frame(this);
                        System.out.println("Successfully login (; ");
                        break;
                    } else {
                        System.out.println("You can't remove products, only admin can remove products #_#");
                        break;
                    }
                }

            } else {
                // Print error message if the user ID does not belong to a manager
                System.out.println("Sorry, the entry ID is not the same as Grocery Manager >_<  [" + n + "] ");
                break;
            }
        }
    } else {
        // Print error message if the user does not enter a valid integer
        System.out.println("Sorry, the input is incorrect, we only accept valid numbers ^_^ ");
    }
}
    
   public void printUsers() {
    // Print a list of all users in the system
    System.out.println("The users are:");
    for (USERS u : Users) {
        // Check the type of each user and print their information accordingly
        if (u instanceof Customer) {
            System.out.println(((Customer) u).toString());
        } else if (u instanceof Employee) {
            System.out.println(((Employee) u).toString());
        } else if (u instanceof Manager) {
            System.out.println(((Manager) u).toString());
        }
    }
}


public void printUserProducts(USERS u, Products[] productList) {
    // Print the products bought by a specific customer
    if (u instanceof Customer) {
        System.out.println(((Customer) u).toString());
        System.out.println("Bought:");
        for (Products p : productList) {
            System.out.println(p);
        }
    }
}


public void printProducts() {
    // Print all products in the system
    System.out.println("The store contains " + counterProduct + " product(s):");
    for (int i = 0; i < counterProduct; i++) {
        System.out.println(Product[i]);
    }
}


public void printCustomers() {
    // Print a list of all customers in the system
    System.out.println("The customers are:");
    for (USERS u : Users) {
        if (u instanceof Customer) {
            System.out.println(((Customer) u).toString());
        }
    }
}


public String toString() {
    // Return a string representation of the store's name and all products in the system
    String s = "";
    for (int i = 0; i < counterProduct; i++) {
        s += Product[i] + " \n ";
    }
    return "Store name: " + name + " \nProducts: \n" + s;
}


