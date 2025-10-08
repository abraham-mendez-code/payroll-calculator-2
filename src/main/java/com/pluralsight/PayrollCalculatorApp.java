package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class PayrollCalculatorApp {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        // prints out a message to get the file to read
        System.out.println("Enter the name of the employee file to process: ");
        String readFile = scanner.nextLine();

        // prints out a message to get the name of a file to create
        System.out.println("Enter the name of the payroll file to create: ");
        String makeFile = scanner.nextLine();

        boolean isJson = false;


        // check if the file is a .json
        if (makeFile.endsWith(".json")) {
            isJson = true;
        }

        try (BufferedReader  bufferedReader = new BufferedReader(new FileReader(readFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(makeFile)) ) {


            String input;

            // if it's a .json file do this
            if (isJson) {
                // create an array of employee objects
                Employee[] employees = new Employee[8];


                int i = 0;

                bufferedWriter.write("[\n");
                // this loop reads the current line in the bufferedReader and displays the contents if not null
                while ( (input = bufferedReader.readLine()) != null ) {

                    // split the current line into seperate fields
                    String[] tokens = input.split("[|]");

                    // create variables to store each field
                    String id = tokens[0];
                    String name = tokens[1];
                    double hoursWorked = Double.parseDouble(tokens[2]);
                    double payRate = Double.parseDouble(tokens[3]);

                    // create a new employee object using the fields
                    employees[i] = new Employee(id, name, hoursWorked, payRate);

                    // create a format string to write
                    String output = String.format("\t{ \"id\" : %s, \"name\" : \"%s\", \"gross pay\" : $%.2f },", employees[i].getEmployeeID(),
                            employees[i].getName(), employees[i].getGrossPay());

                    // write the formatted string to the file
                    bufferedWriter.write(output);

                    // go to a new line
                    bufferedWriter.newLine();

                    i++;

                }
                bufferedWriter.write("]");
            }
            else {
                // check if the current line is null and print out if it is not
                while ((input = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(input + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println("Error occured");

        }

    }

    private static void readPayRoll(String readFile) throws IOException {

        FileReader fileReader = new FileReader(readFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String input;

        Employee[] employees = new Employee[8];


        int i = 0;

        // this loop reads the current line in the bufferedReader and displays the contents if not null
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
    }



}
