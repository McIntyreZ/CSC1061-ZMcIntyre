/**
 * Driver class for program; Program demonstrates the use of an ArrayList and IO functions
 * @author Zachary McIntyre 
 */
import java.util.ArrayList;

/**
 * The program will use ArrayLists and a File to store data
 */
public class TestSchoolRecords {

	/**
	 * All program functions begin in main()
	 * @param command line input 
	 */
	public static void main(String[] args) {
		
		/**
		 * Creates database and person objects. Everything done with ArrayList is performed
		 * in the try catch block 
		 */
		try {
			Database db = new Database();
			
			Student student1 = new Student("Juniper Johnson", "555 nowhere",
					"jj@hotmail.com", "(994)456-7890", "Sophomore");
			Student student2 = new Student("Daryl Shawffenheim", "1317 Fischer",
					"DS@AOL.com", "(879)232-9498", "Junior");
			Faculty faculty1 = new Faculty("Bill Reily", "980 Giveaway st",
					"billy@hotmail.com", "(227)234-9728", "At school", "$13/yr", 
					"2/24/25", "None", "Junior");
			Faculty faculty2 = new Faculty("Dolly Lean", "772 Musical ave", 
					"thedoll@gmail.com", "(544)546-4564", "CP112", "$24/hr", "2/22/21",
					"2-4", "Senior");
			Staff staff1 = new Staff("Johnny Carson", "879 Funny st", "legendary@gmail.com",
					"(342)234-2323", "SP105", "$55/hr", "7/1/85", "Teach");
			Staff staff2 = new Staff("Toby Maguire", "123 Power way", "spidey@gmail.com",
					"(786)567-4564", "CP112", "$993/hr", "9/27/24", "Hero Instructor");

			try {
				db.writePerson(student1);
				db.writePerson(student2);
				db.writePerson(faculty1);
				db.writePerson(faculty2);
				db.writePerson(staff1);
				db.writePerson(staff2);
			}
			catch (Exception e) {
				System.out.println("Error"); 
			}
			ArrayList<Person> list = db.readDatabase();
			
			for (Person temp: list) {
				System.out.println(temp.toString()); 
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		
	}

}
