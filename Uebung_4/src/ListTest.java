
public class ListTest {

    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(3);
        list.insertLast(0);
        list.insertLast(1);
        list.insertLast(10);
        list.insertLast(12);
       
        
        System.out.println("it : " + list.getMinIter());
        System.out.println("rec : " + list.getMinRec(list.getFirst()));
        list.printReversed(list.getFirst());
        System.out.println();
        list.reverse();
        list.printReversed(list.getFirst());
        System.out.println();
    }

}
