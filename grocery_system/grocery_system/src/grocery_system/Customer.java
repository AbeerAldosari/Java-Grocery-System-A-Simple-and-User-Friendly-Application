package grocery_system;

public class Customer extends USERS {

    private int countvisit = 0; // initialize the number of visits made by the customer to 0
    private String newornot; // declare variable for indicating whether the customer is new or special

    public Customer(String Name) {
        super(Name); // call the constructor of the superclass with Name parameter
        newornot = "new customer"; // initialize newornot to "new customer"
    }

    public void Speacialornew() {
        countvisit++; // increment the visit count
        if (countvisit > 2) { // if the visit count is greater than 2
            newornot = "special customer"; // set newornot to "special customer"
        }
    }

    public int getCounter() {
        return countvisit; // return the number of visits made by the customer
    }

    public String getNewornot() {
        if (countvisit > 2) { // if the visit count is greater than 2
            newornot = "special customer"; // set newornot to "special customer"
        }
        return newornot; // return the value of newornot
    }

    @Override
    public String toString() {
        return newornot + ": " + Name + "( " + ID + " ) visits " + countvisit + " tims(s)"; // return a string representation of the object
    }

}