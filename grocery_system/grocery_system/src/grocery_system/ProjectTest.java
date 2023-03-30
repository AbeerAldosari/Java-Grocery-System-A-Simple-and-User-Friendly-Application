package grocery_system;

import java.io.FileNotFoundException;
//import java.util.Formatter;
import java.util.Scanner;
public static void main(String[] args) throws FileNotFoundException {		

    Scanner input = new Scanner(System.in);

    // Read product information from file
    input = new Scanner(new java.io.File("products.txt"));
    Store s = new Store("Test file \n");
    System.out.println("Welcome to " + s.getName());
    System.out.println();
    while (input.hasNext()) {
        // Read each line from the file
        String Line = input.nextLine();
        // Get the last index of space
        int index = Line.lastIndexOf(" ");
        // Extract product name			
        String name = Line.substring(0, index);
        // Extract product price and convert it to double
        double price = Double.parseDouble(Line.substring(index + 1));

        // Add the product to the store
        s.addProduct(new Products(name, price));
    }
    // Print all the products in the store
    s.PrintProducts();
    System.out.println("\n");

    // Read customer information from file
    input = new Scanner(new java.io.File("Costumer.txt"));
    while (input.hasNext()) {
        // Read each line from the file
        String name = input.next();
        // Add the customer to the store
        s.addUSERS(new Customer(name));
    }

    // Read employee information from file
    input = new Scanner(new java.io.File("Employee.txt"));
    while (input.hasNext()) {
        // Read each line from the file
        String Line = input.nextLine();
        // Get the last index of space
        int index = Line.lastIndexOf(" ");
        // Extract employee name
        String name = Line.substring(0, index);
        // Extract employee salary and convert it to double
        double salary = Double.parseDouble(Line.substring(index + 1));
        // Add the employee to the store
        s.addUSERS(new Employee(name, salary));
    }

    // Read manager data from file "Manager.txt"
    input = new Scanner(new java.io.File("Manager.txt"));
    while (input.hasNext()) {
        String line = input.nextLine();
        int index = line.lastIndexOf(" "); 
        String name = line.substring(0, index);  
        double salary = Double.parseDouble(line.substring(index + 1));
        s.addUSERS(new Manager(name, salary));
    }
    s.printuser();

    System.out.println("\n");
    
    // Create store objects
    Products p1 = new Products("phone", 5000);
    Products p2 = new Products("Airpods", 3000);
    Products p3 = new Products("Charger", 150);
    Products p4 = new Products("kinder", 10);
    Products p5 = new Products("bear", 50);
    Products p6 = new Products("water", 5);
    Products p7 = new Products("gum", 1);
    Products p8 = new Products("laptop", 6000);

    USERS U = new Employee("mohammed", 7500);
    USERS U1 = new Customer("srar");
    USERS U2 = new Employee("abeer", 1500);
    USERS U3 = new Customer("nora");
    USERS U4 = new Manager("razan", 15000);
    USERS U5 = new Customer("shumukh");

    Store mystore = new Store("Happy Store");

    // Add users to the store
    mystore.addUSERS(U);
    mystore.addUSERS(U1);
    mystore.addUSERS(U2);
    mystore.addUSERS(U3);
    mystore.addUSERS(U4);
    mystore.addUSERS(U5);

    // Add products to the store 
    mystore.addProduct(p1);
    mystore.addProduct(p2);
    mystore.addProduct(p3);
    mystore.addProduct(p4);
    mystore.addProduct(p5);
    mystore.addProduct(p6);
    mystore.addProduct(p7);
    mystore.addProduct(p8);


// print the users and products
System.out.println("Welcome to " + mystore.getName()); // print store name
mystore.PrintProducts(); // print all available products
System.out.println("\n");
mystore.printuser(); // print all users (employees and customers)
System.out.println("\n");

// increase the salary and add bonus
System.out.println("Increase all salaries by 25%."); 
System.out.println("Before increase:");
System.out.println(U); // print user (employee) before salary increase
((Employee) U).updateSalary(25); // increase salary of employee U by 25%
System.out.println("After increase:");
System.out.println(U); // print user (employee) after salary increase
System.out.println("Before increase:");
System.out.println(U2); // print user (employee) before salary increase
((Employee) U2).updateSalary(25); // increase salary of employee U2 by 25%
System.out.println("After increase:");
System.out.println(U2); // print user (employee) after salary increase
System.out.println("\n");

// demonstrate 3 correct buy operations
// buy operation 1
System.out.println("Store before 3 correct buy operations: " + mystore.getName()); // print store name before buy operation
mystore.PrintProducts(); // print all available products before buy operation
System.out.println("\n");
Products[] buy1 = new Products[2];
buy1[0] = p4;
buy1[1] = p6;
mystore.Buy(U1, buy1); // perform buy operation 1
System.out.println("\n");

// buy operation 2
System.out.println("Store after 1 correct buy operation: " + mystore.getName()); // print store name after buy operation 1
mystore.PrintProducts(); // print all available products after buy operation 1
System.out.println("\n");
Products[] buy2 = new Products[2];
buy2[0] = p5;
buy2[1] = p1;
mystore.Buy(U1, buy2); // perform buy operation 2
System.out.println("\n");

// buy operation 3
System.out.println("Store second correct buy operation: " + mystore.getName()); // print store name after buy operation 2
mystore.PrintProducts(); // print all available products after buy operation 2
System.out.println("\n");
Products[] buy3 = new Products[2];
buy3[0] = p7;
buy3[1] = p2;
mystore.Buy(U1, buy3); // perform buy operation 3
System.out.println("\n");
System.out.println("Store third correct buy operation: " + mystore.getName()); // print store name after buy operation 3
mystore.PrintProducts(); // print all available products after buy operation 3
System.out.println("\n");

// print customer
mystore.printcustomer(); // print all customers and their purchase history
System.out.println("\n");


        //buy operation 4
 // Print the store's name and products before the buy operation
System.out.println("Store before wrong buy operation: " + mystore.getName());
mystore.PrintProducts();
System.out.println("\n");

// Print the products the customer wants to buy
System.out.println("the customer needs : ");
Products[] buy4 = new Products[2];
buy4[0] = p2;
buy4[1] = p1;
for (Products p : buy4) {
    System.out.println(p);
}

// Attempt to buy the products
mystore.Buy(U1, buy4);

// Print the store's name and products after the failed transaction
System.out.println("Store After a wrong buy operation: " + mystore.getName());
mystore.PrintProducts();
System.out.println("\n");

// Print information about the store's users
mystore.printuser();
System.out.println("\n");

// Print the store's name and products before adding new products
System.out.println("Store before add a product: " + mystore.getName());
mystore.PrintProducts();
System.out.println("\n");

// Add three new products to the store
System.out.println("Add: cup, book, pen Successfully to the Store.");
Products p9 = new Products("cup", 60);
Products p10 = new Products("book", 20);
Products p11 = new Products("pen", 10);
mystore.addProduct(p9);
mystore.addProduct(p10);
mystore.addProduct(p11);

// Print the store's name and products after adding new products
System.out.println("\n");
System.out.println("Store After add a product:" + mystore.getName());
mystore.PrintProducts();
System.out.println("\n");

// Create three special products for the summer season
Products[] summer = new Products[3];
summer[0] = new Products("smart screen ", 10000.2);
summer[1] = new Products("cover ", 200.0);
summer[2] = new Products(" Ipad", 1000);
specialproudect sp1 = new specialproudect(summer[0].getName(), summer[0].getPrice(), summer, "summer");
specialproudect sp2 = new specialproudect(summer[1].getName(), summer[1].getPrice(), summer, "summer");
specialproudect sp3 = new specialproudect(summer[2].getName(), summer[2].getPrice(), summer, "summer");

// Print information about the special products for the summer season
System.out.println("the list of the special proudect proudect:");
for (Products summerP : summer) {
    System.out.println(summerP.toString());
}
System.out.println("\n");
sp1.print();
System.out.println("");
sp2.print();
System.out.println("");
sp3.print();
System.out.println("");

// Creating a list of special products from the same factory
System.out.println("The list of the second special product:");
Products[] samefactory = new Products[2];
samefactory[0] = new Products("yogurt ", 5.2);
samefactory[1] = new Products("Milke ", 20.0);

// Creating two special products with the same factory products list
specialproudect sp4 = new specialproudect(samefactory[0].getName(), samefactory[0].getPrice(), samefactory, "same factory");
specialproudect sp5 = new specialproudect(samefactory[1].getName(), samefactory[1].getPrice(), samefactory, "same factory");

// Printing out the details of the factory products
for (Products summerPf : samefactory) {
System.out.println(summerPf.toString());
}
System.out.println("\n");

// Printing out the details of the special products
sp4.print();
System.out.println("");
sp5.print();
System.out.println("");

// Printing out the details of the store users
System.out.println();
mystore.printuser();
System.out.println("\n");

// Removing the manager GUI
mystore.managerremove();

}// End of the code block