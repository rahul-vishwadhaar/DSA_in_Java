/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class JollyJumping {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] input = new int[] { 1 ,4, 2, -1, 6 };

		boolean result = isJumpingSequence(input);

		System.out.println(result);
	}

	private static boolean isJumpingSequence(int[] input) {
		boolean result = false;
		
		int totalSum = -1;
		
		int len = input.length;
		
		totalSum = (len-1)*(len)/2;
		
		for(int i=0; i< len-1;i++)
		{
			totalSum = totalSum - Math.abs(input[i+1] - input[i]);
		}

		if(totalSum == 0)
			result = true;
		
		return result;
	}

}
