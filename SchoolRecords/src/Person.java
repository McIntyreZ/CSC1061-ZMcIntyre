/**
 * Class for Person object 
 * @author Zachary McIntyre 
 */
public class Person {
	// Data Members 
	private String name;
	private String address;
	private String emailAddress;
	private String phoneNum;
	
	// Constructors 
	public Person() {
		name = "noName";
		address = "noWhere";
		emailAddress = "none";
		phoneNum = "noPhone";
	}
	
	public Person(String name, String address, String emailAddress, String phoneNum) {
		super();
		this.name = name;
		this.address = address;
		this.emailAddress = emailAddress;
		this.phoneNum = phoneNum;
	}

	// Getters and setters 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	// Other methods 
	/**
	 * Method returns a string with all data members to be printed to file
	 * @author Zachary McIntyre 
	 */
	public String getInfo() {
		return "Person\t" + name + "\t" + address + "\t" + emailAddress + "\t" + 
				phoneNum;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + ", emailAddress=" + 
				emailAddress + ", phoneNum=" + phoneNum + "]";
	}

	
}
