/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class RemoveDuplicateCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		String input = "geeksforgeeks";
		String input = "HappyNewYear";

		char[] result = removeDuplicates(input.toCharArray(), 0, input.length()-1);
		
		for(int i=0; i<result.length;i++)
		{
			if(result[i] != ' '  )
			  System.out.print(result[i]);
		}
//		System.out.println(result);
	}

	private static char[] removeDuplicates(char[] input, int start, int end) {
		int mid = -1;

		if (start == end) {
			char[] c = new char[1];
			c[0] = input[start];
			return c;
		}

		mid = (start + end) / 2;

		char[] inputA = removeDuplicates(input, start, mid);
		char[] inputB = removeDuplicates(input, mid + 1, end);

		return merge(inputA, inputB);
	}

	private static char[] merge(char[] inputA, char[] inputB) {

		char[] result = new char[inputA.length + inputB.length];
		boolean flag = false;
		int index = inputA.length;

 		System.arraycopy(inputA, 0,result, 0,  inputA.length);

		for (int i = 0; i < inputB.length; i++) {
			flag = false;
			for (int j = 0; j < inputA.length; j++) {
				if (inputA[j] == inputB[i]) {
					flag = true;
				}
			}
			if (!flag)
				result[index] = inputB[i];
			index++;
		}

		return result;
	}

}
