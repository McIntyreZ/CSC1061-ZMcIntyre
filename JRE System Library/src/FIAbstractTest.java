import java.util.Arrays;

public class FIAbstractTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		FIAbstract[] fiInsts = new FIAbstract[3];
		
		fiInsts[0] = new Bank("Second Bank", 2, 10200076, null, 2.67);
		fiInsts[0] = new CreditUnion("First CU", 1, 10200077, null, 2.9);
		fiInsts[0] = new Bank("Fifth Bank", 5, 10200079, null, 3.8);
		
		for(FIAbstract fi: fiInsts) {
			System.out.println(fi);
		}
		
		Arrays.sort(fiInsts);
		
		Address addr = new Address();
		addr.setLine1("555 Merry Way");
		addr.setZip(80525);
		
		Bank bank1 = new Bank();
		
		System.out.println("Bank1 Name: " + bank1.getName());
		System.out.println("Bank1 Addr: " + bank1.getAddress().getLine1());
		System.out.println("Bank1 Zip: " + bank1.getAddress().getZip());
		
		Bank bank2 = (Bank) bank1.clone();
		
		bank2.setName("New Bank");
// 		not needed since we set the clone method to do this automatically
//		Address newAddr = new Address(); 
//		newAddr.setLine1("343 Spooky St");
//		newAddr.setZip(333333);
//		bank2.setAddress(newAddr);
		
		System.out.println("Bank2 Name: " + bank2.getName());
		System.out.println("Bank2 Addr: " + bank2.getAddress().getLine1());
		System.out.println("Bank2 Zip: " + bank2.getAddress().getZip());
		
		System.out.println("Bank1 Name: " + bank1.getName());
		System.out.println("Bank1 Addr: " + bank1.getAddress().getLine1());
		System.out.println("Bank1 Zip: " + bank1.getAddress().getZip());
		
	}

}
