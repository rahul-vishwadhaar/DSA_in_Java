/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class DistanceK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node head = null;

		head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		
		head.right.left = new Node(6);
		head.right.right = new Node(7);
		
		int level = 2;

		printLevel(head, level);

	}

	private static void printLevel(Node node, int level) {

		if(node == null)
			return;
		
		if(level == 0){
			System.out.println(node.data);
			return;
		}
		
		printLevel(node.left, level-1);
		printLevel(node.right,level -1);
	}

}
