/**
 * Class for Student object 
 * @author Zachary McIntyre 
 */
public class Student extends Person{
	// Data members 
	private String status; // Freshman, Sophomore, Junior, or Senior
	
	// Constructors 
	public Student() {
		super();
		status = "unknown";
	}
	
	public Student(String name, String address, String email, String phone, 
			String status) {
		super(name, address, email, phone);
		this.status = status;
	}

	// Getters and setters
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	// Other methods 
	/**
	 * Method returns a string with all data members to be printed to file
	 */
	public String getInfo() {
		return "Student\t" + super.getName() + "\t" + super.getAddress() + "\t" 
				+ super.getEmailAddress() + "\t" + super.getPhoneNum() + "\t" + 
				status; 
	}
	
	@Override
	public String toString() {
		return super.toString() + "of type Student [status=" + status + "]";
	}
	
	
	
}
