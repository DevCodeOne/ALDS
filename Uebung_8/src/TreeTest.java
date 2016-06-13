public class TreeTest {

    public static void main(String[] args) {
        Tree t = new Tree();
        t.init();
        t.getRoot().setLeftChild(new TreeNode(0, null, null));
        t.getRoot().setRightChild(new TreeNode(1, null, null));
        t.getRoot().getLeftChild().setLeftChild(new TreeNode(1, null, null));
        t.getRoot().getLeftChild().setRightChild(new TreeNode(1, null, null));
        t.getRoot().getRightChild().setRightChild(new TreeNode(0, null, null));
        t.getRoot().getRightChild().setLeftChild(new TreeNode(2, null, null));
        t.getRoot().getRightChild().getLeftChild().setLeftChild(new TreeNode(0, null, null));

        //t.getRoot().getRightChild().setLeftChild(new TreeNode(0, null, null));
        //t.getRoot().getRightChild().setRightChild(new TreeNode(1, null, null));

        //t.getRoot().getLeftChild().setLeftChild(new TreeNode(0, null, null));
        //t.getRoot().getLeftChild().setRightChild(new TreeNode(1, null, null));
        //t.getRoot().getLeftChild().getLeftChild().setLeftChild(new TreeNode(0, null, null));
        //t.getRoot().getLeftChild().getLeftChild().setRightChild(new TreeNode(0, null, null));
        //t.getRoot().getLeftChild().getLeftChild().getRightChild().setRightChild(new TreeNode(0, null, null));

        System.out.println("Number of nodes " + t.getNumberOfNodes());
        System.out.println("Height : " + t.getHeight());
        System.out.println("Number of leaves " + t.getNumberOfLeaves());
        System.out.println("PathSum : " + t.getPathLength());
        System.out.println("IsStrict : " + t.isStrict());
        System.out.println("Root key occurences " + t.getNumberOfRootKey());
        System.out.println("MinLeafLevel : " + t.getMinLeafLevel());
        System.out.println("MaxLeafLevel : " + t.getMaxLeafLevel());
    }
}
