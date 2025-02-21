
public class FIAbstract {
	private String fiId;
	private String 
	private 
	
	@Override
	public int compareTo(FIAbstract fi) {
		if (fiId < fi.fiId) {
			return -1;
		}
		if (fiId > fi.fiId) {
			return 1;
		}
		return 0; 
	}
	
	@Override
	public FIAbstract clone() throws CloneNotSupportedException {
		FIAbstract clone = (FIAbstract) super.clone(); 
		clone.address = address.clone();
		return clone();
	}
	
	@Override
	
	
}
