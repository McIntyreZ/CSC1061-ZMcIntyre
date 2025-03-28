/**
 * Class for Employee object 
 * @author Zachary McIntyre 
 */
public class Employee extends Person{
	private String office;
	private String salary;
	private String dateHired;
	
	// Constructors 
	public Employee() {
		super();
		office = "none";
		salary = "none";
		dateHired = "unknown"; 
	}
	
	public Employee(String name, String address, String email, String phone, 
			String office, String salary, String dateHired) {
		super(name, address, email, phone);
		this.office = office;
		this.salary = salary;
		this.dateHired = dateHired;
	}
	
	// Getters and setters 
	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDateHired() {
		return dateHired;
	}

	public void setDateHired(String dateHired) {
		this.dateHired = dateHired;
	}
	
	/**
	 * Method returns a string with all data members to be printed to file
	 */
	public String getInfo() {
		return "Student\t" + super.getName() + "\t" + super.getAddress() + "\t" 
				+ super.getEmailAddress() + "\t" + super.getPhoneNum() + "\t" + 
				office + "\t" + salary + "\t" + dateHired;
	}
	
	@Override
	public String toString() {
		return super.toString() + "of type Employee [office=" + office + ", salary=" 
				+ salary + ", dateHired=" + dateHired + "]";
	}
}
