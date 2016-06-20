public class TreeTest {

    public static void main(String[] args) {
        Tree t = new Tree();

        // baum in preorder

        for (int i : new int [] { 36, 33, 27, 30, 35, 52, 47, 42, 87, 72, 1701 }) // baum in preorder
            t.appendNode(i);

        t.preOrder(t.getRoot()); // zum Testen obs geht
        System.out.println();
        System.out.println("Baum höhe : " + t.getHeight());
        System.out.println("AVL Krit : " + t.isAVL());
    }
}
