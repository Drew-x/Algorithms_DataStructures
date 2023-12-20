import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class BinaryTree <T>{

	private TreeNode<T> root;
	
	public List<T> preOrder() {
		List<T> result = new ArrayList<T>();
		Deque<TreeNode<T>> s = new ArrayDeque<TreeNode<T>>();
		
		s.push(this.root);
		
		while (!s.isEmpty()) {
			TreeNode<T> current = s.pop();
			result.add(current.getItem());
			
			if (current.hasRightChild()) {
				s.push(current.getRightTreeNode());
			}
			
			if (current.hasLeftChild()) {
				s.push(current.getLeftTreeNode());
			}
		}
		
		return result;
	}
	
	public List<T> inOrder() {
		
		List<T> result = new ArrayList<T>();
		Deque<TreeNode<T>> stack = new ArrayDeque<TreeNode<T>>(); 
		TreeNode<T> current = this.root;
		
		while (!stack.isEmpty() || current != null) {
			if( current != null ) {
				stack.push(current);
				
				current = current.getLeftTreeNode();
			}else {
				current = stack.pop();
				
				result.add(current.getItem());
				current = current.getRightTreeNode();
			}
			
		}
		return result;
	}
	
	
	public List<T> traversePostOrderStack() {
    	List<T> result = new ArrayList<>();
    	
    	Stack<TreeNode<T>> s = new Stack<>();
    	TreeNode<T> prev = null;
    	s.push(this.root);
    	while(!s.isEmpty()) {
    		//establish the current node, but do not remove it
    		//as we need to (eventually) process it after its left
    		// and right subtree are done
    		TreeNode<T> curr = s.peek();
    		//if curr is the root or we came from the parent
    		//   we (curr) is the previous's left child or right child
    		if(prev == null || prev.getLeftTreeNode() == curr || prev.getRightTreeNode() == curr) {
    			//push left if exists because we need to go to it next
    			//else if no left child, then push the right if it exists 
    			//  because we need to go to it next
    			//else do nothing and we'll head back up the tree
    			if(curr.hasLeftChild()) {
    				s.push(curr.getLeftTreeNode());
    			} else if(curr.hasRightChild()) {
    				s.push(curr.getRightTreeNode());
    			} 
    		} else if(curr.getLeftTreeNode() == prev) {
    			//we're returning from traversing the left subtree
    			//if current has a right child, push it so we can go to it
    			if(curr.hasRightChild()) {
    				s.push(curr.getRightTreeNode());
    			}
    		} else {
    			result.add(curr.getItem());
    			s.pop();
    		}
    		prev = curr;
    	}
    	
    	return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree<String> t = new BinaryTree<String>();
		
		TreeNode<String> a = new TreeNode<String>("a");
		TreeNode<String> b = new TreeNode<String>("b");
		TreeNode<String> c = new TreeNode<String>("c");
		TreeNode<String> d = new TreeNode<String>("d");
		TreeNode<String> e = new TreeNode<String>("e");
		TreeNode<String> f = new TreeNode<String>("f");
		
		
		a.setLeftTreeNode(b);
		a.setRightTreeNode(c);
		
		b.setParent(a);
		b.setLeftTreeNode(d);
		b.setRightTreeNode(e);
		
		c.setParent(a);
		c.setRightTreeNode(f);
		
		d.setParent(b);
		
		e.setParent(b);
		
		f.setParent(c);
		
		t.root = a;
		
		System.out.println(t.preOrder());
		
		System.out.println(t.inOrder());
		
		System.out.println(t.traversePostOrderStack());
	}

}
