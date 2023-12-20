import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node<Integer> node1 = new Node<>(3);
		Node<Integer> node2 = new Node<>(-11);
		Node<Integer> node3 = new Node<>(4);
		Node<Integer> node4 = new Node<>(-4);
		Node<Integer> node5 = new Node<>(2);
		Node<Integer> node6 = new Node<>(-111);
		Node<Integer> node7 = new Node<>(-112);
		// connecting 
		node1.left = node2;
		node1.right = node3;
		
		// B left hand side
		node2.left = node4;
		node2.right =node5;
		
		// C right hand side 
		node3.right= node6;
		
		node6.left = node7;
		
		ArrayList<Node> list = new ArrayList<>();
		int sum = 0;		
		//sum = depthForSearchSum(node1,list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).value);
		}
		
		System.out.println("SUM: "+ sum);
//		
//		System.out.println("SUM2");
//		
//		sum = depthForSearchSum2(node1, list, sum);
//		System.out.println(sum);
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).value);
//		}
		
		
		//int x = breathForSearchSum(node1);
	//	System.out.println("X: "+ x);
		
		
		//int min = treeMinDepth(node1, node1.value);
		
		//System.out.println("the min: "+ min);
		
		System.out.println("treeMINBreath");
		
		//int min2 = treeMinBreath(node1);
		
		//System.out.println("MIN2: "+ min2);
		
		System.out.println("MIN3");
		System.out.println(recursiveFindMin(node1));
		
	}// END Main
	
	public static int recursiveFindMin(Node<Integer> node) {
		
		
		System.out.println("start");
		System.out.println(node.value);
		if (node.left == null && node.right == null) {
			System.out.println("in start");
			return node.value;
		}
		
		System.out.println("right return ");
		if( node.right == null) {
			return  recursiveFindMin(node.left);
		}
		System.out.println("left return ");
		if(node.left == null ) {
			return  recursiveFindMin(node.right);
		}
		
		
//		if(node == null) {
//			int x = Integer.MAX_VALUE;
//			System.out.println("in- "+ x );
//			
//			return  x;
//		}
		System.out.println("val- "+ node.value);

		int leftMin = recursiveFindMin(node.left);
		int rightMin = recursiveFindMin(node.right);

		System.out.println("over Left return- "+leftMin);
		if (leftMin <= rightMin &&  leftMin <= node.value) {

			return leftMin;
		}
		System.out.println("over Right return- "+rightMin);
		if (rightMin <= leftMin &&  rightMin <= node.value) {

			return rightMin;
			
		}
		System.out.println("over return- "+node.value);
		return node.value;
		

		
	}
	
	public static int treeMinBreath(Node<Integer> node) {
		
		Queue<Node<Integer>> queue = new LinkedList<>();
		int min = node.value;
		queue.add(node);
		while (!queue.isEmpty()) {
			
			Node<Integer> currentNode = queue.remove();
			if (currentNode.value <= min) {
				min = currentNode.value;
			}
			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}
			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}
			
		}// end while

		return min;
	}
	
	public static int treeMinDepth(Node<Integer> node, int min) {
		
		int check = node.value;
		System.out.println("inside : "+ check);
		if (check <= min ) {
			min = node.value;
			treeMinDepth(node.left, min);
			treeMinDepth(node.right, min);
		}
	
		
		return min;
	}
	
	public static int breathForSearchSum(Node<Integer> node) {
		int sum = 0;

		Queue<Node> queue = new LinkedList<Node>();

		if (node != null) {

			queue.add(node);
			while (!queue.isEmpty()) {

				Node currentNode = queue.remove();
				
				sum += (Integer)currentNode.value;
				if (currentNode.left != null) {
					queue.add(currentNode.left);
				}

				if (currentNode.right != null) {
					queue.add(currentNode.right);
				}

			}
		}

		return sum;
	}
	
	public static int depthForSearchSum(Node<Integer> node, ArrayList<Node> list) {
		
	
//		System.out.println("on top ");
//		 System.out.println( list.toString());
		if (node == null) {

			return 0;
			
		}
		list.add(node);
		
		
		
		
		return node.value + depthForSearchSum(node.left, list) + depthForSearchSum(node.right, list); 
	}

}
