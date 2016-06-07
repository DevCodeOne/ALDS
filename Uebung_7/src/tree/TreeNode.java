package tree;

public class TreeNode {

	private char key;
	private TreeNode leftChild;
	private TreeNode rightChild;
	
	public TreeNode(char k, TreeNode lc, TreeNode rc) {
		this.key = k;
		this.leftChild = lc;
		this.rightChild = rc;
	}

	public void setLeftChild(TreeNode node) {
		this.leftChild = node;
	}

	public void setRightChild(TreeNode node) {
		this.rightChild = node;
	}

	public void setKey(char key) {
		this.key = key;
	}

	public TreeNode getLeftChild() { return leftChild; }

	public TreeNode getRightChild() { return rightChild; }

	public char getKey() { return key; }
}
