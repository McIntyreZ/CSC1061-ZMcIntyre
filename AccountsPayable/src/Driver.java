// Zachary McIntyre
// Built for CSC-1061, assignment AccountsPayable, 2/10/25
// Program written in Java
// This program is designed to demonstrate the creation and alteration of objects.
// The program creates Employee objects, which can be subclasses, and displays 
// their information

// Imports
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Employee[] payableEmployees = new Employee[6];
		int selection = 0; 
		
		// Welcome prompts for user
		System.out.println("This program will create an array of 6 payable employees."
				+ " For each employee enter the employee type");
		// All employee assignments will take place in this loop
		for (int i = 0; i < 6; i++) {
			// Prompt for Employee type
			System.out.println("(1 = Commission + base," + " 2 = Commission, 3 = Hourly,"
					+ " 4 = Salaried).");
			try { // In case an InputMismatchException occurs
				selection = scnr.nextInt(); 
				// Ensures proper input
				while (!((selection > 0) && (selection < 5))) {
					System.out.println("Enter integer 1, 2, 3, or 4:");
					selection = scnr.nextInt();
				}
				// Employee subclass assignments will take place in if-else statements
				if (selection == 1) {
					payableEmployees[i] = new BasePlusCommissionEmployee();
					setEmployeeType(payableEmployees[i], scnr);
				}
				else if (selection == 2) {
					payableEmployees[i] = new CommissionEmployee();
					setEmployeeType(payableEmployees[i], scnr);
				}
				else if (selection == 3) {
					payableEmployees[i] = new HourlyEmployee();
					setEmployeeType(payableEmployees[i], scnr);
				}
				else if (selection == 4) {
					payableEmployees[i] = new SalariedEmployee();
					setEmployeeType(payableEmployees[i], scnr);
				}
			}
			// Catch for earlier InputMismatchException try block
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			}	
		} 
		
		// Displays original information input
		for (int i = 0; i < 6; i++) {
			printEmpDetails(payableEmployees[i]);
		}
		
		// Only alters base pay for BasePlusCommission Employees
		for (int i = 0; i < 6; i++) {
			if (payableEmployees[i] instanceof BasePlusCommissionEmployee) {
				BasePlusCommissionEmployee baseComEmp = 
						((BasePlusCommissionEmployee)payableEmployees[i]);
				baseComEmp.setBasePay(((BasePlusCommissionEmployee) 
						payableEmployees[i]).getBasePay() * 1.1);
			}
		}
		
		// Displays changed information 
		for (int i = 0; i < 6; i++) {
			printEmpDetails(payableEmployees[i]);
		}
		
		
	} // End main()
	
	// Extra methods
	
	// Assigns Employee type
	public static void setEmployeeType(Employee employee, Scanner scnr) throws InputMismatchException{
		double temp = 0;
		if (employee instanceof BasePlusCommissionEmployee) {
			// Explicit down casting
			BasePlusCommissionEmployee baseComEmployee = (BasePlusCommissionEmployee)employee;
			setBasicFields(employee, scnr);
			// Prompts for extra data fields
			System.out.println("Enter the base pay:");
			temp = scnr.nextDouble(); 
			baseComEmployee.setBasePay(temp);
			System.out.println("Enter the commission rate:");
			temp = scnr.nextDouble(); 
			baseComEmployee.setCommissionRate(temp);
		}
		else if (employee instanceof CommissionEmployee) {
			// Explicit down casting
			CommissionEmployee ComEmployee = (CommissionEmployee)employee;
			setBasicFields(employee, scnr);
			// Prompt for extra data members
			System.out.println("Enter the commission rate:");
			temp = scnr.nextDouble(); 
			ComEmployee.setCommissionRate(temp);	
		}
		else if (employee instanceof HourlyEmployee) {
			// Explicit down casting
			HourlyEmployee hourlyEmployee = (HourlyEmployee)employee;
			setBasicFields(employee, scnr);
			System.out.println("Enter the hourly wage:");
			// Prompt for extra data member 
			temp = scnr.nextDouble(); 
			hourlyEmployee.setHourlyWage(temp);
		}
		else if (employee instanceof SalariedEmployee) {
			// Explicit down casting
			SalariedEmployee salEmployee = (SalariedEmployee)employee;
			setBasicFields(employee, scnr);
			System.out.println("Enter the salary:");
			// Prompt for extra data member 
			temp = scnr.nextDouble(); 
			salEmployee.setWeeklySalary(temp);
		}
	}
	
	// Method saves space in setEmployeeType()
	public static void setBasicFields(Employee employee, Scanner scnr) {
		String temp = null;
		long ssn = 100000000;
		// Basic prompt for original data fields
		System.out.println("Enter first, last, and SSN of employee (ex. Toby James "
				+ "100000000): ");
			temp = scnr.next();
			employee.setFirstName(temp);
			temp = scnr.next();
			employee.setLastName(temp);
			ssn = scnr.nextLong();
			employee.setSocialSecNum(ssn);
	}
	
	// Prints toString() for Employee 
	public static void printEmpDetails(Employee employee) {
		System.out.println(employee);
	}
	
	// Prints original/basic data members for Employee
	public static void printBasic(Employee employee) {
		System.out.println("Name: " + employee.getFirstName() + " " +
				employee.getLastName() + ", SSN: " + employee.getSocialSecNum());
	}

	// Alternate method for printing Employee details, uses .get() methods
	public static void printAltDetails(Employee employee) {
		if (employee instanceof BasePlusCommissionEmployee) {
			// Explicit down casting
			BasePlusCommissionEmployee baseComEmployee = (BasePlusCommissionEmployee)employee;
			printBasic(baseComEmployee);
			System.out.println(", Commission rate: " + baseComEmployee.getCommissionRate() + 
					", Gross Sales: " + baseComEmployee.getGrossSales() + ", Base pay: " + 
					baseComEmployee.getBasePay());
		}
		else if (employee instanceof CommissionEmployee) {
			// Explicit down casting
			CommissionEmployee comEmployee = (CommissionEmployee)employee;
			printBasic(comEmployee);
			System.out.println(", Commission rate: " + comEmployee.getCommissionRate() + 
					"Gross Sales: " + comEmployee.getGrossSales());
		}
		else if (employee instanceof HourlyEmployee) {
			// Explicit down casting
			HourlyEmployee hourlyEmployee = (HourlyEmployee)employee;
			printBasic(hourlyEmployee);
			System.out.println(", Hourly wage: " + hourlyEmployee.getHourlyWage() + ", "
					+ "Hours worked: " + hourlyEmployee.getHours());
		}
		else if (employee instanceof SalariedEmployee) {
			// Explicit down casting
			SalariedEmployee salEmployee = (SalariedEmployee)employee;
			printBasic(salEmployee);
			System.out.println(", Hourly wage: " + salEmployee.getWeeklySalary());
		}
	}
	
}
