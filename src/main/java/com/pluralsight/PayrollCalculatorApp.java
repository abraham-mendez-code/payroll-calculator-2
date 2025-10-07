package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculatorApp {

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("payroll.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String input = bufferedReader.readLine();


        bufferedReader.close();

        System.out.println(input);

    }

}
