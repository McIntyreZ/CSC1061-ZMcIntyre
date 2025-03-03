import java.util.ArrayList;

public class PhoneDesignerTest {

	public static void main(String[] args) {
		
		BarModel bar1 = new BarModel(); 
		
		bar1.addToList('d'); 
		bar1.addToList('j'); 
		bar1.addToList('z'); 
		
		System.out.println(bar1); 
		
		ArrayList<Character> barList = new ArrayList<>();
		BarModel bar2 = new BarModel("FastChip 3000", 1, 2, barList);
		bar2.addToList('e'); 
		bar2.addToList('f'); 
		bar2.addToList('g'); 
		
		System.out.println(bar2);
		try {
			System.out.println(bar1.compareTo(bar2)); 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
