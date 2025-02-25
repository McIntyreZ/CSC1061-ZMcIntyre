/**
 * Class for Staff object 
 * @author Zachary McIntyre 
 */
public class Staff extends Employee {
	private String title;

	// Constructors 
	public Staff() {
		super();
		title = "none"; 
	} 
	
	public Staff(String name, String address, String email, String phone, 
			String office, String salary, String dateHired, String title) {
		super(name, address, email, phone, office, salary, dateHired);
		this.title = title;
	}

	// Getters and setters 
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// Other methods 
	/**
	 * Method returns a string with all data members to be printed to file
	 */
	@Override
	public String getInfo() {
		return "Staff\t" + super.getName() + "\t" + super.getAddress() + "\t" 
				+ super.getEmailAddress() + "\t" + super.getPhoneNum() + "\t" + 
				super.getOffice() + "\t" + super.getSalary() + "\t" + 
				super.getDateHired() + "\t" + title;
	}

	@Override
	public String toString() {
		return super.toString() + "of type Staff [title=" + title + "]";
	} 
	
	
	
}
