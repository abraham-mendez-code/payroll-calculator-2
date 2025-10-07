package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculatorApp {

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("payroll.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String input;

         /*
         employeeId
        name
        hoursWorked
        payRate
          */
        //Employee[] employees = new Employee[];

        while ( (input = bufferedReader.readLine()) != null ) {

            String[] currentLine = input.split("[|]");

            for (int i = 0; i < currentLine.length; i++) {

                System.out.println(currentLine[i]);

            }

        }

        bufferedReader.close();

        System.out.println(input);

    }

}
