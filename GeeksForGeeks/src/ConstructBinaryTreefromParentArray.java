import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class ConstructBinaryTreefromParentArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = new int[] { -1, 0, 0, 1, 1, 3, 5 };
		Node root = null;

		root = constructBinaryTree(arr);

		printPreOrder(root);
		
	/*	
		LLNode headA = new LLNode(1);
		headA.next = new LLNode(2);
		headA.next.next = new LLNode(3);
		headA.next.next.next = new LLNode(4);
		
		
		LLNode headB = new LLNode(7);
		headB.next = headA.next;
				
		

		System.out.println(intersectPoint(headA, headB));*/
	}

	private static void printPreOrder(Node root) {

		if (root == null)
			return;

		System.out.print(root.data + " ");

		printPreOrder(root.left);
		printPreOrder(root.right);
	}

	private static Node constructBinaryTree(int[] arr) {

		Node root = new Node(0);
		ArrayList<Node> arrNode = new ArrayList<Node>();
		Node newNode;
		Node tempNode;

		for (int index = 0; index < arr.length; index++) {

			newNode = new Node(index);
			arrNode.add(newNode);
			if (arr[index] == -1) {
				root = newNode;
			} else {

				if (arrNode.get(arr[index]).left == null)
					arrNode.get(arr[index]).left = newNode;
				else
					arrNode.get(arr[index]).right = newNode;

			}
		}

		return root;

	}

	/*static int intersectPoint(LLNode headA, LLNode headB) {
        int lenA = 0;
        int lenB = 0;
        int diff =-1;
        int result = -1;
        HashSet<Integer> data = new HashSet<Integer>();
        
        Node tempA = headA;
        Node tempB = headB;
        
        while(tempA != null){
            tempA = tempA.next;
            data.add(tempA.data);
            lenA++;
        }
        
         while(tempB != null){
            tempB = tempB.next;
            
            if(data.contains(tempB.data))
            return tempB.data;
            
            lenB++;
        }
        
      }*/
}
