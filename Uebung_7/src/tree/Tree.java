package tree;

public class Tree {

	private Stack stack;
	private TreeNode root;
	
	public Tree() {
		stack = new Stack();
		root = new TreeNode('-', null, null);
		
		root.setLeftChild(new TreeNode('+', null, null));
		root.setRightChild(new TreeNode('/', null, null));
		root.getRightChild().setLeftChild(new TreeNode('d', null, null));
		root.getRightChild().setRightChild(new TreeNode('e', null, null));
		
		root.getLeftChild().setLeftChild(new TreeNode('a', null, null));
		root.getLeftChild().getLeftChild().setLeftChild(new TreeNode('_', null, null));
		root.getLeftChild().setRightChild(new TreeNode('*', null, null));
		root.getLeftChild().getRightChild().setLeftChild(new TreeNode('b', null, null));
		root.getLeftChild().getRightChild().getLeftChild().setRightChild(new TreeNode('!', null, null));
		root.getLeftChild().getRightChild().setRightChild(new TreeNode('^', null, null));
		root.getLeftChild().getRightChild().getRightChild().setLeftChild(new TreeNode('c', null, null));
		root.getLeftChild().getRightChild().getRightChild().setRightChild(new TreeNode('2', null, null));
	}
	
	public void inOrderRec() {
		inOrderRecHelp(root);
		System.out.println();
	}
	
	private void inOrderRecHelp(TreeNode current) {
		if (current == null)
			return;
		inOrderRecHelp(current.getLeftChild());
		System.out.print(current.getKey() + " ");
		inOrderRecHelp(current.getRightChild());
	}
	
	public void inOrderIter() throws Exception {
		inOrderIterHelp(root);
		System.out.println();
	}

	private void inOrderIterHelp(TreeNode current) throws Exception {
		if (current == null) return;

		do {
			while (current.getLeftChild() != null) {
				stack.push(current);
				current = current.getLeftChild();
			}

			System.out.print(current.getKey() + " ");

			if (stack.empty())
				break;

			if (current.getRightChild() == null) {
				current = (TreeNode) stack.top();
				System.out.print(current.getKey() + " ");
				stack.pop();
			}

			while (current.getRightChild() == null) {
				current = (TreeNode) stack.top();
				System.out.print(current.getKey() + " ");
				stack.pop();
			}

			current = current.getRightChild();
		} while (current != null);
	}
}
