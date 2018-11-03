import java.util.ArrayList;
import java.util.List;

public class Concept2 extends Concept1 {

	static {
		System.out.println("subclass");
	}

	{
		System.out.println("Concept2");
	}

	public static void main(String... args) {

		int level = 2;

		level = ~level;

		System.out.println(level);

		level = ~level;

		System.out.println(level);


		level = ~level;

		System.out.println(level);

	}

	void Print(Node node, int k1, int k2) {
		ArrayList<Node> queue = new ArrayList<Node>();
		Node currentNode = null;

		if (node == null) {
			return;
		} else {
			queue.add(node);
		}

		while (queue.size() != 0) {

			int level = 0;

			level = ~level;

			currentNode = queue.get(0);
			queue.remove(0);

			if (node.left != null) {
				queue.add(node.left);
			}

			if (node.right != null) {
				queue.add(node.right);
			}

			System.out.print(node.data);
		}
	}
	
	
	 void printSpiral(Node node) 
     {
          int nodeCount = 0;
          int level = 1;
          
          ArrayList<Node> queue = new ArrayList<Node>();
          Node currentNode= null;
          
          if(node == null)
           return;
           
          queue.add(node);
           
          while(queue.size() != 0){
              
              if(nodeCount == 0){
                  
                  nodeCount = queue.size();
                  level = ~level;
                  
               if(level < 0)
                   printForward(0, nodeCount, queue);
               else
                   printReverse(0, nodeCount, queue);
                  
              }
                   
               currentNode = queue.get(0);
               queue.remove(0);
               nodeCount--;
               
               if(currentNode.left != null){
                   queue.add(currentNode.left);
               }
               if(currentNode.right != null){
                   queue.add(currentNode.right);
               }
          }
     }
     
     void printForward(int start, int end, ArrayList<Node> queue ){
         
         int i =0;
         
         for(i=start; i<end;i++){
             System.out.print(queue.get(i).data);
         }
         
     }
     
     void printReverse(int start, int end, ArrayList<Node> queue){
        int i = 0;
        
        for(i=end-1; i>=start;i++){
             System.out.print(queue.get(i).data);
         } 
     }
}