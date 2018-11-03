/**
 * 
 */

/**
 * @author rahul kumar
 *
 */
public class IntegerToRow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int num= 57;
		int charIndex = 0;
		while(num != 0){
			
			charIndex = num%26;
			num = num/26;
			
			printCharacter(charIndex);
			
		}
	}

	private static void printCharacter(int charIndex) {
		// TODO Auto-generated method stub
		
	}

}
