package grocery_system;

// Employee class is a subclass of USERS class
public class Employee extends USERS {
    
    // protected instance variable salary
    protected double salary;

    // Employee constructor takes Name and salary as input parameters
    public Employee(String Name, double salary) {
        super(Name); // call the constructor of the superclass (USERS)
        this.salary = salary; // initialize the salary instance variable
    }

    // updateSalary method updates the salary by adding the bonus to it
    public double updateSalary(double Bouns) {
        return salary += (salary * (Bouns / 100)); // calculate and return the updated salary
    }

    // getSalary method returns the current value of the salary instance variable
    public double getSalary() {
        return salary; 
    }

    // setSalary method sets the value of the salary instance variable
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // override the toString method to return a String representation of the Employee object
    @Override
    public String toString() {
        return "Employee : " + Name + " (" + ID + " ) has " + salary + "RS";
    }
}

// Manager class is a subclass of Employee class
class Manager extends Employee {

    // Manager constructor takes Name and salary as input parameters
    public Manager(String Name, double salary) {
        super(Name, salary); // call the constructor of the superclass (Employee)
    }

    // override the toString method to return a String representation of the Manager object
    @Override
    public String toString() {
        return "Employee ( Manager) :" + Name + " (" + ID + " ) has " + salary + "RS";
    }
}
