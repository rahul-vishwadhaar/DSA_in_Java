/**
 * 
 */

/**
 * @author rahul kumar
 *
 */
public class reverseOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static void printReverseLevelOrder(Node node){
		
		if(node == null){
			return;
		}
		
		printReverseLevelOrder(node.left);
		printReverseLevelOrder(node.right);
		
		System.out.print(node.right);
		
		System.out.println(node.left);
		
		return;
	}

}
