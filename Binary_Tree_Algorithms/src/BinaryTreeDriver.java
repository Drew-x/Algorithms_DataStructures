import java.util.*;
import java.math.*;



public class BinaryTreeDriver {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		
	
		String word = "d";
		
		
		Stack<Node> stack = new Stack<>();
		
		Node<String> node1 = new Node<String>("a");
		Node<String> node2 = new Node<String>("b");
		Node<String> node3 = new Node<String>("c");
		Node<String> node4 = new Node<String>("d");
		Node<String> node5 = new Node<String>("e");
		Node<String> node6 = new Node<String>("f");
		
		node1.left = node2;
		node1.right = node3;
		
		// B left hand side
		node2.left = node4;
		node2.right =node5;
		
		// C right hand side 
		node3.right= node6;
		
		//stack.add(node1);
		
		ArrayList<Node> depthFArrayList = new ArrayList<>();
		
		
		/* depthForSearchLoop  */
//		DepthForSearch.depthForSearchLoop(stack, depthFArrayList);
//	
//		System.out.println("Array list -");
//		
//		for (int i = 0; i < depthFArrayList.size(); i++) {
//			
//			System.out.println(depthFArrayList.get(i).value);
//		}
		
		/* depthForSearchRecursion  */
//		System.out.println("recursion");
//		
//		
//		DepthForSearch.depthForSearchRecursion(node1, depthFArrayList);
//		
//		for (int i = 0; i < depthFArrayList.size(); i++) {
//
//			System.out.println(depthFArrayList.get(i).value);
//		}
		
		// ****** BREATH for search 
		
		/* 
		ArrayList<Node> list = new ArrayList<>();
		
		//  list = breathForSearch(node1);  // CALLL MEHTOD
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).value);
		}
		*/
		
		// ****** END- BREATH for search
		
		//System.out.println(breathForSearchFind(node1, "e"));
		
		
		// RECURSIVE DEPTH FOR SEARCH
		
		System.out.println( recursiveDepthforseachFind(node1, "d"));
		
	} // end main
	
	public static boolean recursiveDepthforseachFind(Node node, String value) {
		
		if (node == null) {
			
			return false;
		}		
		
		if (node.value == value) {
			return true;
		}
					
		return recursiveDepthforseachFind(node.right,value) || recursiveDepthforseachFind(node.left, value);
		
	}
	
	public static boolean breathForSearchFind(Node node, String value) {

		Queue<Node> queue = new LinkedList<>();

		queue.add(node);
		
		

		
		while (!queue.isEmpty()) {
			Node curNode = queue.remove();
			String check = (String) curNode.value; 
			
//			System.out.println("value - "+ curNode.value + " value: "+ value);
//			System.out.println(check.equals(value));
			
//			if (check.equals(value)) {
//				
//				return true;
//			}
			
			if (curNode.value == value) {
				return true;
			}
			
			if (curNode.left != null) {
				queue.add(curNode.left);
			}
			if (curNode.right != null) {
				queue.add(curNode.right);
			}
			
		}

		return false;

	}
	
	
	public static ArrayList<Node> breathForSearch(Node node) {
		Queue<Node> queue = new LinkedList<>();
		
		ArrayList<Node> list = new ArrayList<>();
		
		if (node == null) {
			return null;
			
		}
		queue.add(node);
		
		
		
		while (!queue.isEmpty()) {
			
			Node currentNode = queue.remove();
			list.add(currentNode);
			
			
			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}
			
			if (currentNode.right != null) {
				queue.add(currentNode.right);
			
			}
			
			
		}
		
		return list;
	}
	

}// END
