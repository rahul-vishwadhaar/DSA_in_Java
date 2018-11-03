import java.util.ArrayList;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class RepeatedNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();

		for(int i=0; i< 25;i++) {
			if(i == 15)
				input.add(i-1);
			
			input.add(i+1);
		}
		

		input = getRepeatedElement(input);

		for (Integer i : input) {
			System.out.println(i);
		}

	}

	private static ArrayList<Integer> getRepeatedElement(ArrayList<Integer> a) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		long sum = 0;
		long size = a.size();
		double fraction = 1.0;

		long maxSum = (size) * (size + 1) / 2;

		for (int i = 0; i < a.size(); i++) {
			sum = sum + a.get(i);
			fraction = fraction * ((double)(i+1) /(double) a.get(i));
		}

		long diff = maxSum - sum;

		long y = Math.round((double) ((diff) / (fraction - 1)));
		long x = diff + y;

		result.add((int) y);
		result.add((int) x);
		return result;

	}

}
