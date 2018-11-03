/**
 * 
 */

/**
 * @author rahul kumar
 *
 */
public class Rearrange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static void rearrange(LLNode odd){
	    LLNode head = odd;
	    if (head == null)
	        return ;

	    LLNode currentNode = head;
	    LLNode lastNode = head;
	    LLNode nextNode = null;
	    LLNode head2 = new LLNode(0);

	    while (lastNode.next != null) {
	        lastNode = lastNode.next;
	    }   

	    while ((currentNode.next != lastNode) && (currentNode != null)) 
	    {
	        nextNode = currentNode.next;
	        if (nextNode == null)
	            break;

	        currentNode.next = nextNode.next;
	        currentNode = currentNode.next;
	        nextNode.next = head2.next;
	        head2.next = nextNode;

	    }

	        lastNode.next = head2.next;

	        odd = head;
	    }

}
