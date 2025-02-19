import java.util.Arrays;

public class FIAbstractTest {

	public static void main(String[] args) {
		FIAbstract[] fiInsts = new FIAbstract[3];
		
		fiInsts[0] = new Bank("Second Bank", 2, 10200076, null, 2.67);
		fiInsts[0] = new CreditUnion("First CU", 1, 10200077, null, 2.9);
		fiInsts[0] = new Bank("Fifth Bank", 5, 10200079, null, 3.8);
		
		for(FIAbstract fi: fiInsts) {
			System.out.println(fi);
		}
		
		Arrays.sort(fiInsts);
	}

}
