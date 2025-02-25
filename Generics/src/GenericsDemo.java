import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {

	public static void main(String[] args) {
		List<String> colors = new ArrayList<>(); 
		
		colors.add("Red"); 
		colors.add("Apple"); 
		
		List<Integer> ints = new ArrayList<>();
		Integer num1 = Integer.valueOf(5); 
		ints.add(num1); 
		
		ints.add(6); // same thing as above since Java autoboxes = "casts" to Integer 
		
		// System.out.println(num1)  // can still do this; called "unboxing" 
		// can even do int inum = num1; because it auto unboxes 
		
		/* difference between primitive and wrapper classes: the list takes type Integer != int
		 * int x = 6;
		 * Integer x_obj = Integer.valueOf(6); 
		 */
		
		List<Double> dbs = new ArrayList<Double>(); 
		dbs.add(3.4); 
		dbs.add(4.5); 
		
		// Instance of ReverseList, the generic E is replaced with Integer and now the list can only 
		// accept Integer objects; the generic has been "instantiated" 
		ReverseList<Integer> intList = new ReverseList<>(); 
		intList.add(1); 
		intList.add(2);
		intList.add(3); 
		
		for (Integer i: intList.getList()) {
			System.out.println(i); 
		}
	 	
		ReverseList<String> strList = new ReverseList<>(); 
		strList.add("Howdy"); 
		
		
		
		
		
		
	}

}
