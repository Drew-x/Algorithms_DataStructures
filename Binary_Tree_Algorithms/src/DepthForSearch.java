import java.util.ArrayList;
import java.util.Stack;

public class DepthForSearch {

	public static void depthForSearchLoop(Stack<Node> stack , ArrayList<Node> depthFArrayList) {
		
		while (!stack.isEmpty()) {

			Node currentNode = stack.pop();

			// System.out.println(currentNode.value);
			/*
			 * For depth for search push right side to print left side right-
			 */
			depthFArrayList.add(currentNode);
			
			if (currentNode.right != null) {
				stack.add(currentNode.right);
			}

			if (currentNode.left != null) {
				stack.add(currentNode.left);
			}

		} // end while
	}// End - depthForSearchLoop
	
	
	public static ArrayList<Node> depthForSearchRecursion(Node node, ArrayList<Node> list) {
		
		
		if (node == null) {
			
			return null;
			
		}
		
		list.add(node);
		depthForSearchRecursion(node.left, list);
		depthForSearchRecursion(node.right, list);
		
		
		return list;
		
	}
	
	
}
