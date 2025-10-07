Exercises — Payroll Calculator

Data is often shared in a csv file because the data can be organized into rows and
columns. Instead of parsing a text-based story, in this exercise you will read the
contents of a .csv file and load the contents into the memory of your java
application.

EXERCISE 3

Create a new Java application named PayrollCalculator. You will read employee
data from a .csv file and generate the payroll information for each employee.
For this exercise read the file using the BufferedReader.

Remember: When creating a new Java project, create a new git repository and
commit your changes often! Don’t forget to push to github.com. Always create
the Github repository before creating a new Java project.

The file will contain several lines of employee data in the form:

    id|name|hours-worked|pay-rate

For example:

    10|Dana Wyatt|52.5|12.50
    
    20|Ezra Aiden|17|16.75
    
    30|Brittany Thibbs|40|16.50
    
    40|Zephaniah Hughes|2|10.0

Step 1

Create an Employee class as described below:

Private data members (attributes):
- employeeId
- name
- hoursWorked
- payRate


  Methods:
- parameterized constructor
- getEmployeeId() and getters/setters for other attributes
- getGrossPay() that calculates and returns that employee's gross pay
  based on their hours worked and pay rate


Step 2

To make the main program work, you will need to:
1. Load the file using a FileReader object
2. Read each line of text
3. Split it into individual fields using the | character as the delimiter
4. Copy the values from the tokens array into variables that match the data
   and then use them to create a new Employee object
5. Display the employee using a printf and by calling the employee's
   getEmployeeId(), getName(), and getGrossPay() methods
6. Repeat for each line in the input file
   
Step 3

1. Ensure all your changes are committed and pushed to GitHub
2. Send your repository URL to your Instructor
