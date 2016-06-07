import tree.Tree;

public class TreeTest {

	public static void main(String[] args) throws Exception {
		// Baum aufbauen (im Konstruktor von Tree)
		Tree derBaum = new Tree();
		
		// Baum rekuriv und iterativ in Zwischenordnung ausgeben
		derBaum.inOrderRec();
		derBaum.inOrderIter();		
	}
}
