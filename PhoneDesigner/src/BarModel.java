import java.util.ArrayList;

public class BarModel implements Comparable {
	private String processor;
	private int cache;
	private int storage; 
	private ArrayList<Character> list = new ArrayList<>();

	// Constructors
	public BarModel() {
		processor = "DragonSlayer 600";
		cache = 8;
		storage = 32;
	}
	
	public BarModel(String processor, int cache, int storage, ArrayList<Character> list) {
		super();
		this.processor = processor;
		this.cache = cache;
		this.storage = storage;
		this.list = list;
	}
	
	// Getters and setters
	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public int getCache() {
		return cache;
	}

	public void setCache(int cache) {
		this.cache = cache;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public ArrayList<Character> getList() {
		return list;
	}
	
	public void setList(ArrayList<Character> newList) {
		list = newList; 
	}

	public void addToList(char s) {
		list.add(s); 
	}
	
	// Other methods
	public String howToRepair() {
		return "Charge and reset the phone. If there is any visible damage on the "
				+ "phone then search the internet for solutions. Otherwise, buy an "
				+ "Apple iPhone if the original phone was not already so.";
	}
	
	public double costToRepair() {
		return 250.00;
	}
	
	public BarModel clone() throws CloneNotSupportedException {
		BarModel barClone = new BarModel();
		
		barClone = (BarModel)super.clone();
		barClone.list = new ArrayList<Character>(); 
		
		return barClone;	
	}

	@Override 
	public int compareTo(BarModel otherP) {
		if (this.cache > otherP.getCache()) {
			if (this.storage > otherP.getStorage()) {
				return 1;
			}
			else {
				return -1; 
			}
		}
		else if (this.cache == otherP.getCache()) {
			if (this.storage > otherP.getStorage()) {
				return 1;
			}
			else {
				return -1;
			}
		}
		else {
			return 0; 
		}
	}
	
	@Override
	public String toString() {
		return "BarModel [processor=" + processor + ", cache=" + cache + ", storage=" + storage + ", list=" + list
				+ "]";
	}
}
