public class AreMirrors {

	public static void main(String args[]) {

		Node root1 = new Node(20);
		root1.left = new Node(30);
		root1.right = new Node(40);
		root1.left.left = new Node(50);

		Node root2 = new Node(20);
		root2.right = new Node(30);
		root2.left = new Node(40);
		root2.right.left = new Node(50);

		System.out.println(areMirror(root1, root2));

	}

	static boolean areMirror(Node a, Node b) {
		boolean result = true;

		if ((a == null) && (b == null))
			return true;
		
		
		if((a == null) || (b== null))
			return false;
		

		if (a.data != b.data)
			return false;

		result = result & areMirror(a.left, b.right);

		return result & areMirror(a.right, b.left);
	}

}
