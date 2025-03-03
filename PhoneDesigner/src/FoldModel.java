import java.util.ArrayList;

public class FoldModel implements Comparable {
	private String processor;
	private int cache;
	private int storage; 
	private ArrayList<Character> list = new ArrayList<>();
	
	// Constructors 
	public FoldModel() {
		processor = "SpeedRacer 800";
		cache = 6;
		storage = 64;
	}
	
	public FoldModel(String processor, int cache, int storage, ArrayList<Character> list) {
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
	public double costToRepair() {
		return 300.00; 
	}
	
	public FoldModel clone() throws CloneNotSupportedException {
		FoldModel foldClone = new FoldModel();
		
		foldClone = (FoldModel)super.clone();
		foldClone.list = new ArrayList<Character>(); 
		
		return foldClone;	
	}
	
	@Override 
	public int compareTo(FoldModel otherP) {
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
		return "FoldModel [processor=" + processor + ", cache=" + cache + ", storage=" + storage + ", list=" + list
				+ "]";
	}
}
