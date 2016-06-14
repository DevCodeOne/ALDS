public class TreeTest {

    public static void main(String[] args) {
        Tree t = new Tree();
        t.init();

        t.getRoot().setKey('-');
        t.getRoot().setLeftChild(new TreeNode('+', null, null));
        t.getRoot().setRightChild(new TreeNode('/', null, null));
        t.getRoot().getRightChild().setLeftChild(new TreeNode('d', null, null));
        t.getRoot().getRightChild().setRightChild(new TreeNode('e', null, null));

        t.getRoot().getLeftChild().setLeftChild(new TreeNode('a', null, null));
        t.getRoot().getLeftChild().getLeftChild().setLeftChild(new TreeNode('-', null, null));
        t.getRoot().getLeftChild().setRightChild(new TreeNode('*', null, null));
        t.getRoot().getLeftChild().getRightChild().setLeftChild(new TreeNode('b', null, null));
        t.getRoot().getLeftChild().getRightChild().getLeftChild().setRightChild(new TreeNode('!', null, null));
        t.getRoot().getLeftChild().getRightChild().setRightChild(new TreeNode('^', null, null));
        t.getRoot().getLeftChild().getRightChild().getRightChild().setLeftChild(new TreeNode('c', null, null));
        t.getRoot().getLeftChild().getRightChild().getRightChild().setRightChild(new TreeNode('2', null, null));

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
