package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PayrollCalculatorApp {

    public static void main(String[] args) throws IOException {

        enterFiles();

    }

    private static void enterFiles() throws IOException {
        Scanner scanner = new Scanner(System.in);

        // prints out a message to get the file to read
        System.out.println("Enter the name of the employee file to process: ");
        String sourceFile = scanner.nextLine();

        // prints out a message to get the name of a file to create
        System.out.println("Enter the name of the payroll file to create: ");
        String targetFile = scanner.nextLine();

        // creates the file
        writeFile(targetFile, sourceFile);
    }

    private static void writeFile(String targetFile, String sourceFile) throws IOException {
        boolean isJson = false;

        // check if the file is a .json
        if (targetFile.endsWith(".json")) {
            isJson = true;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetFile)) ) {


            String input;

            // if it's a .json file do this
            if (isJson) {
                toJson(bufferedWriter, bufferedReader);
            }
            else {
                // check if the current line is null and print out if it is not
                while ((input = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(input + "\n");
                }
            }

        } catch (IOException e) {
            // create a file object of file at source file path
            File readFile = new File(sourceFile);

            // check if the file exists
            if (!readFile.exists()) {
                System.out.println("Source file not found, please try again.");
            }
            else if (targetFile.isEmpty()) {
                System.out.println("Name for target file cannot be empty, please try again.");
            }
            else {
                e.printStackTrace();
                System.exit(404);
            }

            // return to main method an rerun
            String[] args = new String[0];
            String[] strings = new String[]{""};
            main(strings);

        }
    }

    private static void toJson(BufferedWriter bufferedWriter, BufferedReader bufferedReader) throws IOException {
        String input;
        // create an array of employee objects
        Employee[] employees = new Employee[8];

        // write to beginning of file
        bufferedWriter.write("[\n");

        // create an arraylist to store content to write
        ArrayList<String>  output = new ArrayList<String>();

        // index for tokens
        int i = 0;

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
            String content = String.format("{ \"id\": %s, \"name\" : \"%s\", \"gross pay\" : $%.2f }", employees[i].getEmployeeID(),
                    employees[i].getName(), employees[i].getGrossPay());

            output.add(i, content);
            i++;

        }

        for (int j = 0; j < output.size(); j++) {
            // write each element in the output arraylist
            bufferedWriter.write("\t"+ output.get(j));
            if (j != output.size() - 1) {
                bufferedWriter.write(",");
            }
            // go to a new line
            bufferedWriter.newLine();
        }


        bufferedWriter.write("]");
        bufferedWriter.close();
    }

    // This method prints out the contents of employees.csv in a certain format, not implemented in current version
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
