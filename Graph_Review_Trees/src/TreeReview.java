import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeReview {

	static class Node<E>{
		
		E value;
		Node<E> right = null;
		Node<E> left = null;
		
		public Node(E value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		//stackDepthFirst(node1);
		breathFirstSearch(node1);
	}

	public static void breathFirstSearch(Node<String> root) {
		Queue<Node<String>> queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			Node<String> current = queue.poll();
			System.out.println(current.value);
			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}
		}
	}
	
	public static ArrayList<String> recursiveDepthFirst(Node<String> root, ArrayList<String> values) {
		if (root == null) {
			return null;
		}
		values.add(root.value);
		recursiveDepthFirst(root.left, values);
		recursiveDepthFirst(root.right, values);
		
		
		return values;
	}
	
	public static void stackDepthFirst(Node<String> root) {
		if (root == null) {
			System.out.println("null");
			return;
		}
		Stack<Node<String>> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node<String> current = stack.pop();
			System.out.println(current.value);
			
			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
			
			
		}
		
	}
}
