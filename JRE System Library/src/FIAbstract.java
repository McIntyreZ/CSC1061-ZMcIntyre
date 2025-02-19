
public class FIAbstract {
	
	
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
}
