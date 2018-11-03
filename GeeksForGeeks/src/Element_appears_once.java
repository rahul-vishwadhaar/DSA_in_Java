import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class Element_appears_once {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = new int[] { 1, 1, 2, 2, 4, 4, 3, 6, 6 };

		System.out.println(singleElement(arr));
	}

	private static int singleElement(int[] arr) {
		int result = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			result = result ^ arr[i];
		}

		return result;
	}

}
