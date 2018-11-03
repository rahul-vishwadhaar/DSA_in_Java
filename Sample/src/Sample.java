/**
 * 
 */

/**
 * @author rahul kumar
 *
 */
public class Sample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SampleObject so1= new SampleObject();
		
		SampleObject so2 = new SampleObject();
		
		//so2 = so1;
		
		so1.setI(2);
		so2.setI(2);
		
		so1.setC('c');
		so2.setC('c');
		
		so1.setD(2.0);
		so2.setD(2.0);
		
		if(so1 == so2)
			System.out.println("==");
		
		if(so1.equals(so2))
			System.out.println("Equals");
	}

}
