package grocery_system;

public abstract class USERS {

    // instance variables
    protected String Name;
    protected int ID;
    protected static int counter = 1000; // static variable to generate unique IDs for users

    // constructor to initialize Name and ID
    public USERS(String Name) {
        this.Name = Name;
        ID = ++counter; // assigns a unique ID to each user
    }

    // getter method for Name
    public String getName() {
        return Name;
    }

    // setter method for Name
    public void setName(String Name) {
        this.Name = Name;
    }

    // getter method for ID
    public int getID() {
        return ID;
    }

    // setter method for ID
    public void setID(int ID) {
        this.ID = ID;
    }

}

