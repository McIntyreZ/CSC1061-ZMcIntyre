
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;

/**
 * Class runs and uses the File and ArrayList
 * @author Zachary McIntyre 
 */
public class Database {
	private final String fileName = "PersonDatabase";
	File file = new File(fileName); 
	PrintWriter pw = null; 
	
	/**
	 * Constructor creates and initializes File and PrintWriter 
	 * @throws IOException constructor will throw FileNotFoundException or IOException 
	 */
	public Database() throws Exception {
		try {
			if (!file.exists()) {
				file.createNewFile(); 
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		try {
			pw = new PrintWriter(new FileOutputStream(file, false));
		}
		catch (IOException e){
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}
	
	/**
	 * Method takes object input and writes all the information to a tsv file 
	 * @param person the person object that will be written 
	 */
	public void writePerson(Person person) {
				
		if (person instanceof Student) {
			person = (Student)person;
		}
		else if (person instanceof Employee) {
			if (person instanceof Staff) {
				person = (Staff)person;
			}
			else if (person instanceof Faculty) {
				person = (Faculty)person; 
			}
		}
		pw.println(person.getInfo());
		pw.flush();
	}
	
	/**
	 * Method reads tsv File and stores data in an ArrayList; method returns the ArrayList 
	 * @return list method will return ArrayList with information from File
	 */
	public ArrayList<Person> readDatabase() {
		String temp = null; 
		ArrayList<Person> list = new ArrayList<>();
		Person person = null;
		Scanner input = null;
		
		try {
			input = new Scanner(file);
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		while(input.hasNextLine()) {
			String[] line = input.nextLine().split("\t");
			switch (line[0]) {
				case "Person":
					Person p = new Person(line[1], line[2], line[3], line[4]);
					list.add(p); 
					break;
				case "Student":
					Student s = new Student(line[1], line[2], line[3], line[4],
							line[5]); 
					list.add(s); 
					break;
				case "Employee":
					Employee e = new Employee(line[1], line[2], line[3], line[4],
							line[5], line[6], line[7]);
					list.add(e);
					break;
				case "Staff":
					Staff st = new Staff(line[1], line[2], line[3], line[4],
							line[5], line[6], line[7], line[8]);
					list.add(st);
					break;
				case "Faculty":
					Faculty f = new Faculty(line[1], line[2], line[3], line[4],
							line[5], line[6], line[7], line[8], line[9]);
					list.add(f);
					break; 
				default: 
					System.out.println("No type for object");
			}
		}
		
		input.close();
		return list; 
	}
	
}
