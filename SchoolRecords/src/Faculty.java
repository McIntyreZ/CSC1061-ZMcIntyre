/**
 * Class for Faculty object 
 * @author Zachary McIntyre 
 */
public class Faculty extends Employee {
	private String officeHours;
	private String rank; // Junior or Senior 
	
	// Constructors 
	public Faculty() {
		super();
		officeHours = "none";
		rank = "unknown"; 
	} 
	
	public Faculty(String name, String address, String email, String phone, 
			String office, String salary, String dateHired, String officeHours, 
			String rank) {
		super(name, address, email, phone, office, salary, dateHired);
		this.officeHours = officeHours;
		this.rank = rank;
	}
	
	// Getters and setters 
	public String getOfficeHours() {
		return officeHours;
	}

	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	// Other methods 
	/**
	 * Method returns a string with all data members to be printed to file
	 */
	@Override
	public String getInfo() {
		return "Faculty\t" + super.getName() + "\t" + super.getAddress() + "\t" 
				+ super.getEmailAddress() + "\t" + super.getPhoneNum() + "\t" + 
				super.getOffice() + "\t" + super.getSalary() + "\t" + 
				super.getDateHired() + "\t" + officeHours + "\t" + rank;
	}
	
	@Override
	public String toString() {
		return super.toString() + "of type Faculty [officeHours=" + officeHours + 
				", rank=" + rank + "]";
	} 
		
}
