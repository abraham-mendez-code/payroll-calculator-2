package com.pluralsight;

public class Employee {

    /*
        Private data members (attributes):
        employeeId
        name
        hoursWorked
        payRate
        Methods:

        parameterized constructor
        getEmployeeId() and getters/setters for other attributes
        getGrossPay() that calculates and returns that employee's gross pay based on their hours worked and pay rate
     */

    private String employeeID;
    private String name;
    private double hoursWorked;
    private double payRate;

    // parameterize constructor for the Employee class
    public Employee(String employeeID, String name, double hoursWorked, double payRate) {
        this.employeeID = employeeID;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    // getter and setter methods for class attributes
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    // this method calculates and returns an employee's gross pay based on their hours worked and pay rate
    public double getGrossPay() {

        double grossPay;

        if (hoursWorked > 40.0) {

            double overtimeHours = hoursWorked - 40.0;
            grossPay = payRate * (hoursWorked - overtimeHours) + overtimeHours * (payRate * 1.5);

            return grossPay;

        } else {

            grossPay = payRate * hoursWorked;

            return grossPay;

        }

    }

}
