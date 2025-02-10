import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Employee[] payableEmployees = new Employee[6];
		int selection = 0; 
		
		System.out.println("This program will create an array of 6 payable employees."
				+ " For each employee enter the type of employee type");
		for (int i = 0; i < 6; i++) {
			System.out.println("1 = Commission + base," + " 2 = Commission, 3 = Hourly,"
					+ " 4 = Salaried).");
			try {
				selection = scnr.nextInt(); 
				while (!((selection > 0) && (selection < 5))) {
					System.out.println("Enter integer 1, 2, 3, or 4:");
					selection = scnr.nextInt();
				}
				if (selection == 1) {
					payableEmployees[i] = (CommissionEmployee) payableEmployees[i];
				}
				else if (selection == 2) {
					payableEmployees[i] = (BasePlusCommissionEmployee) payableEmployees[i];
				}
				else if (selection == 3) {
					payableEmployees[i] = (HourlyEmployee) payableEmployees[i];
				}
				else if (selection == 4) {
					payableEmployees[i] = (SalariedEmployee) payableEmployees[i];
				}
				setEmployeeType(payableEmployees[i], scnr);
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			}
			
			
		}
		
		
		
	}
	
	public static void setEmployeeType(Employee employee, Scanner scnr) throws InputMismatchException{
		double temp = 0;
		if (employee instanceof BasePlusCommissionEmployee) {
			BasePlusCommissionEmployee baseComEmployee = (BasePlusCommissionEmployee)employee;
			setBasicFields(employee, scnr);
			System.out.println("Enter the base pay:");
			temp = scnr.nextDouble(); 
			baseComEmployee.setBasePay(temp);
			System.out.println("Enter the commission rate:");
			temp = scnr.nextDouble(); 
			baseComEmployee.setCommissionRate(temp);
		}
		else if (employee instanceof CommissionEmployee) {
			CommissionEmployee ComEmployee = (CommissionEmployee)employee;
			setBasicFields(employee, scnr);
			System.out.println("Enter the commission rate:");
			temp = scnr.nextDouble(); 
			ComEmployee.setCommissionRate(temp);	
		}
		else if (employee instanceof HourlyEmployee) {
			HourlyEmployee hourlyEmployee = (HourlyEmployee)employee;
			setBasicFields(employee, scnr);
			System.out.println("Enter the base pay:");
			temp = scnr.nextDouble(); 
			hourlyEmployee.setHourlyWage(temp);
			System.out.println("Enter the hourly wage:");
			temp = scnr.nextDouble(); 
			hourlyEmployee.setHourlyWage(temp);
		}
		else if (employee instanceof SalariedEmployee) {
			SalariedEmployee salEmployee = (SalariedEmployee)employee;
			setBasicFields(employee, scnr);
			System.out.println("Enter the salary:");
			temp = scnr.nextDouble(); 
			salEmployee.setWeeklySalary(temp);
			System.out.println("Enter the hourly wage:");
			temp = scnr.nextDouble(); 
			salEmployee.setWeeklySalary(temp);
		}
		
		
		
	}
	public static void setBasicFields(Employee employee, Scanner scnr) {
		String temp = null;
		long ssn = 100000000;
		System.out.println("Enter first, last, and SSN of employee (ex. Toby James "
				+ "100000000): ");
		if (scnr.nextLine().equals(null)) {
			temp = scnr.next();
			employee.setFirstName(temp);
			temp = scnr.next();
			employee.setLastName(temp);
			ssn = scnr.nextLong();
			employee.setSocialSecNum(ssn);
		}
		else {
			scnr.nextLine();
			setBasicFields(employee, scnr);
		}
	}
	
	public static void printEmpDetails(Employee employee) {
		System.out.println(employee);
	}
	
	public static void printBasic(Employee employee) {
		System.out.println("Name: " + employee.getFirstName() + " " +
				employee.getLastName() + ", SSN: " + employee.getSocialSecNum());
	}

	public static void printAltDetails(Employee employee) {
		if (employee instanceof BasePlusCommissionEmployee) {
			BasePlusCommissionEmployee baseComEmployee = (BasePlusCommissionEmployee)employee;
			printBasic(baseComEmployee);
			System.out.println(", Commission rate: " + baseComEmployee.getCommissionRate() + 
					", Gross Sales: " + baseComEmployee.getGrossSales() + ", Base pay: " + 
					baseComEmployee.getBasePay());
		}
		else if (employee instanceof CommissionEmployee) {
			CommissionEmployee comEmployee = (CommissionEmployee)employee;
			printBasic(comEmployee);
			System.out.println(", Commission rate: " + comEmployee.getCommissionRate() + 
					"Gross Sales: " + comEmployee.getGrossSales());
		}
		else if (employee instanceof HourlyEmployee) {
			HourlyEmployee hourlyEmployee = (HourlyEmployee)employee;
			printBasic(hourlyEmployee);
			
			// TODO finish method 
		}
		else if (employee instanceof HourlyEmployee) {
			HourlyEmployee hourlyEmployee = (HourlyEmployee)employee;
			setBasicFields(employee, scnr);
			System.out.println("Enter the base pay:");
			temp = scnr.nextDouble(); 
			hourlyEmployee.setHourlyWage(temp);
			System.out.println("Enter the hourly wage:");
			temp = scnr.nextDouble(); 
			hourlyEmployee.setHourlyWage(temp);
		}
		else if (employee instanceof SalariedEmployee) {
			SalariedEmployee salEmployee = (SalariedEmployee)employee;
			setBasicFields(employee, scnr);
			System.out.println("Enter the salary:");
			temp = scnr.nextDouble(); 
			salEmployee.setWeeklySalary(temp);
			System.out.println("Enter the hourly wage:");
			temp = scnr.nextDouble(); 
			salEmployee.setWeeklySalary(temp);
		}
	}
}
