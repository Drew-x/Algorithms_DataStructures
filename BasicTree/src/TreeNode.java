
public class TreeNode <T> {

	private T item;
	private TreeNode<T> parent;
	private TreeNode<T> leftTreeNode;
	private TreeNode<T> rightTreeNode;
	
	
	public TreeNode(T item) {
		super();
		this.item = item;
	}


	public TreeNode<T> getParent() {
		return parent;
	}


	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}


	public TreeNode<T> getLeftTreeNode() {
		return leftTreeNode;
	}


	public void setLeftTreeNode(TreeNode<T> leftTreeNode) {
		this.leftTreeNode = leftTreeNode;
	}


	public TreeNode<T> getRightTreeNode() {
		return rightTreeNode;
	}


	public void setRightTreeNode(TreeNode<T> rightTreeNode) {
		this.rightTreeNode = rightTreeNode;
	}


	public T getItem() {
		return item;
	}
	
	
	// checkers
	
	public boolean hasLeftChild() {
		return (this.leftTreeNode != null);
	}
	
	public boolean hasRightChild() {
		return (this.rightTreeNode != null);
	}
	
	public boolean isRoot() {
		return (this.parent == null);
	}
	
	
}
