import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CloneWithRandomPointer {

	public LLNode clone(LLNode root) {
		// Initialize two references, one with original
		// list's head.
		LLNode origCurr = root, cloneCurr = null;

		// Hash map which contains LLNode to LLNode mapping of
		// original and clone linked list.
		Map<LLNode, LLNode> map = new HashMap<LLNode, LLNode>();

		// Traverse the original list and make a copy of that
		// in the clone linked list.
		while (origCurr != null) {
			cloneCurr = new LLNode(origCurr.data);
			map.put(origCurr, cloneCurr);
			origCurr = origCurr.next;
		}

		// Adjusting the original list reference again.
		origCurr = root;

		// Traversal of original list again to adjust the next
		// and random references of clone list using hash map.
		while (origCurr != null) {
			cloneCurr = map.get(origCurr);
			cloneCurr.next = map.get(origCurr.next);
			// cloneCurr.random = map.get(origCurr.random);
			origCurr = origCurr.next;
		}

		// return the head reference of the clone list.
		return map.get(root);
	}
}
