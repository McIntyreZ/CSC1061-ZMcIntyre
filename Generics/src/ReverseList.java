import java.util.ArrayList;
import java.util.List;

public class ReverseList<E> { // E indicates that the list can hold objects, it is the "generic." Once the first object is inserted
							  // then the rest of the list will only be able to hold that type of object 
	// Data members 
	private List<E> list = new ArrayList<E>(); 
	
	// Methods 
	public void add(E input) {
		 list.add(0, input);
	}
	
	public List<E> getList(){
		return list; 
	}
}
