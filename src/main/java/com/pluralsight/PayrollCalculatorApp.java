package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculatorApp {

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("employees.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String input;

         /*
         employeeId
        name
        hoursWorked
        payRate
          */

        Employee[] employees = new Employee[8];

        int i = 0;
        while ( (input = bufferedReader.readLine()) != null ) {

            // split the current line into seperate fields
            String[] currentLine = input.split("[|]");

            // create variables to store each field
            String id = currentLine[0];
            String name = currentLine[1];
            double hoursWorked = Double.parseDouble(currentLine[2]);
            double payRate = Double.parseDouble(currentLine[3]);

            // create a new employee object using the fields
            employees[i] = new Employee(id, name, hoursWorked, payRate);

            /*
                Display the employee using a printf and by calling the employee's getEmployeeId()
                , getName(), and getGrossPay() methods
             */

            System.out.printf("ID: %s, Name: %s, Gross Pay: $%.2f\n", employees[i].getEmployeeID(),
                    employees[i].getName(), employees[i].getGrossPay());

            i++;

        }

        bufferedReader.close();

        employees[7].toString();

    }

}
