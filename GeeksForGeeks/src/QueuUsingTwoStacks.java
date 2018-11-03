import java.util.Stack;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

/**
 * 
 */

/**
 * @author rahul kumar
 *
 */
public class QueuUsingTwoStacks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		insert(1);
		insert(2);
		insert(3);
		
		System.out.println(remove());
		System.out.println(remove());

	}

	static Stack<Integer> s1 = new Stack<Integer>();
	static Stack<Integer> s2 = new Stack<Integer>();

    /* The method insert to push element into the queue */
    static void insert(int B)
    {
        s1.add(B);
    }
	
    
    /*The method remove which return the element popped out of the queue*/
    static int remove()
    {
    	int returnValue = 0;
    	
    	if(s1.isEmpty())
    		return -1;
    	
    	while(!s1.isEmpty()){
    		s2.push(s1.pop());
    	}
    	
    	returnValue = s2.pop();
    	
    	while(!s2.isEmpty()){
    		s1.push(s2.pop());
    	}
    	
    	return returnValue;
    }
}
