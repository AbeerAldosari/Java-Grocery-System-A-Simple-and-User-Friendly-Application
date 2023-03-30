package grocery_system;

// Define the Products class
public class Products {
    // Instance variables
    protected String Name;
    protected double Price;
    protected int ID;
    protected static int counter = 0;

    // Constructor
    public Products(String Name, double Price) {
        this.Name = Name;
        this.Price = Price;
        this.ID = ++counter; // Increment the ID for each new instance of the class
    }

    // Getter methods
    public String getName() {
        return Name;
    }

    public double getPrice() {
        return Price;
    }

    public int getID() {
        return ID;
    }

    // Override the toString() method to return a string representation of the instance variables
    @Override
    public String toString() {
        return "  Product(" + ID + ") : " + Name + " costs " + Price + "RS";
    }

}

//------------------------------------------------------------

// Define the specialproudect class, which extends the Products class
class specialproudect extends Products {
    // Instance variables
    String nameofrelation;
    private Products[] sp;

    // Constructor
    public specialproudect(String Name, double Price, Products[] array, String nameofrelation) {
        super(Name, Price); // Call the constructor of the superclass (Products)
        this.nameofrelation = nameofrelation;
        sp = array;
    }

    // Print a message indicating the relationship between the special product and the related products in the sp array
    public void print() {
        System.out.println(" in (" + Name + ") the relation " + nameofrelation + " related between the following special products ");
        for (Products p : sp) {
            System.out.println(p.toString()); // Call the overridden toString() method of the Products class
        }
    }
}
