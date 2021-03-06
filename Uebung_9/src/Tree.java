import org.jetbrains.annotations.Contract;

public class Tree {

    private TreeNode root;

    public TreeNode init() {
        root = new TreeNode();
        return root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public int getHeight() {
        return heightCount(root);
    }

    private int heightCount(TreeNode current) {
        if (current != null)
            return 1 + Math.max(heightCount(current.getLeftChild()), heightCount(current.getRightChild()));
        return 0;
    }

    public int getNumberOfNodes() {
        return nodesCount(root);
    }

    private int nodesCount(TreeNode current) {
        if (current != null)
            return 1 + nodesCount(current.getLeftChild()) + nodesCount(current.getRightChild());
        return 0;
    }

    public int getNumberOfLeaves() {
        return leavesCount(root);
    }

    private int leavesCount(TreeNode current) {
        if (current == null) return 0;
        if (current.getLeftChild() == null && current.getRightChild() == null) return 1;

        return leavesCount(current.getLeftChild()) + leavesCount(current.getRightChild());
    }

    public int getPathLength() {
        return pathCount(root, 0);
    }

    private int pathCount(TreeNode current, int level) {
        if (current != null)
            return level + pathCount(current.getLeftChild(), level + 1) + pathCount(current.getRightChild(), level + 1);
        return 0;
    }

    public boolean isStrict() {
        return isStrict(root);
    }

    private boolean isStrict(TreeNode current) {
        if (current == null) return true;
        if (current.getLeftChild() == null ^ current.getRightChild() == null) return false;
        return isStrict(current.getLeftChild()) && isStrict(current.getRightChild());
    }

    public int getMinLeafLevel() {
        return getMinLeafLevel(root, 1);
    }

    private int getMinLeafLevel(TreeNode current, int level) {
        if (current != null) {
            if (current.getLeftChild() == null && current.getRightChild() == null)
                return level;
            else
                return Math.min(getMinLeafLevel(current.getLeftChild(), level + 1), getMinLeafLevel(current.getRightChild(), level + 1));
        }

        return Integer.MAX_VALUE;
    }

    public int getMaxLeafLevel() {
        return getMaxLeafLevel(root, 1);
    }

    private int getMaxLeafLevel(TreeNode current, int level) {
        if (current != null) {
            if (current.getLeftChild() == null && current.getRightChild() == null)
                return level;
            else
                return Math.max(getMaxLeafLevel(current.getLeftChild(), level + 1), getMaxLeafLevel(current.getRightChild(), level + 1));
        }

        return Integer.MIN_VALUE;
    }

    public int getNumberOfRootKey() {
        return getNumberOfRootKey(root) - 1;
    }

    private int getNumberOfRootKey(TreeNode current) {
        if (current == null) return 0;

        int occ = current.getKey() == root.getKey() ? 1 : 0;
        return occ + getNumberOfRootKey(current.getLeftChild()) + getNumberOfRootKey(current.getRightChild());
    }

    public void preOrder(TreeNode current) {
        if (current == null) return;
        System.out.print(current.getKey() + " ");
        preOrder(current.getLeftChild());
        preOrder(current.getRightChild());
    }

    public void appendNode(int key) {
        if (root == null) {
            root = new TreeNode(key, null, null);
            return;
        }

        TreeNode current = null;
        TreeNode next = root;
        do {
            current = next;

            if (current.getKey() >= key)
                next = current.getLeftChild();
            else
                next = current.getRightChild();
        } while (next != null);

        if (current.getKey() >= key) current.setLeftChild(new TreeNode(key, null, null));
        else current.setRightChild(new TreeNode(key, null, null));
    }

    public boolean isAVL() {
        return  isAVLHelper(root);
    }

    private boolean isAVLHelper(TreeNode current) {
        if (current == null) return true;

        boolean diff_one = Math.abs(heightCount(current.getLeftChild()) - heightCount(current.getRightChild())) < 2;
        return diff_one && isAVLHelper(current.getLeftChild()) && isAVLHelper(current.getRightChild());
    }
}
