import java.util.ArrayList;

public class FlipModel implements Comparable<FlipModel> {
	private String processor;
	private int cache;
	private int storage; 
	private ArrayList<Character> list = new ArrayList<>();
	
	
	public FlipModel() {
		processor = "HorseRacer 300";
		cache = 3;
		storage = 16;
	}
	
	public FlipModel(String processor, int cache, int storage, 
			ArrayList<Character> list) {
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
		return "Charge and reset phone. If issues still occur then take the phone to "
				+ "a phone repair shop.";
	}
	
	public double costToRepair() {
		return 200.00;
	}
	
	public FlipModel clone() throws CloneNotSupportedException {
		FlipModel flipClone = new FlipModel();
		
		flipClone = (FlipModel)super.clone();
		flipClone.list = new ArrayList<Character>(); 
		
		return flipClone;	
	}

	@Override 
	public int compareTo(FlipModel otherP) {
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
		return "FlipModel [processor=" + processor + ", cache=" + cache + ", storage="  
				+ storage + ", list=" + list + "]";
	}
}
