import java.util.Random;
import java.util.Scanner;

public class ListTest {

    /**
     * @param args
     */
    public static void main(String[] args)  {
        LinkedList list=new LinkedList();
        
        Scanner in = new Scanner(System.in);
        int choice = -1;
        
        do {
            if (choice == -1) { 
            	System.out.println();
                System.out.println(" 0. Programm beenden");
                System.out.println(" 1. Liste löschen");
                System.out.println(" 2. Liste ausgeben (iterativ)");
                System.out.println(" 3. Liste ausgeben (rekursiv)");
                System.out.println(" 4. Liste umgekehrt ausgeben (rekursiv)");
                System.out.println(" 5. Liste umkehren (rekursiv)");
                System.out.println(" 6. Element hinzufügen (am Anfang)");
                System.out.println(" 7. Element hinzufügen (am Ende)");
                System.out.println(" 8. Element hinzufügen (Sortierreihenfolge)");
                System.out.println(" 9. Element löschen (iterativ)");
                System.out.println("10. Element löschen (rekursiv)");
                System.out.println("11. Element suchen (iterativ)");
                System.out.println("12. Element suchen (rekursiv)");
                System.out.println("13. Element zählen (iterativ)");
                System.out.println("14. Element zählen (rekursiv)");
                System.out.println("15. Listenlänge bestimmen (iterativ)");
                System.out.println("16. Listenlänge bestimmen (rekursiv)");
                System.out.println("17. Aufsteigende Sortierung überprüfen (iterativ)");
                System.out.println("18. Aufsteigende Sortierung überprüfen (rekursiv)");
                System.out.println("42. Liste vorbelegen (unsortiert)");
                System.out.println("43. Liste vorbelegen (sortiert)");
            }
           
            System.out.print("Eingabe: ");
            
            try {
            	choice = in.nextInt();
	            switch(choice) {   
	                case 1:
	                    list.dispose1();
	                    break;
	                case 2:
	                    list.show1();
	                    break;
	                case 7:
	                    int element;
	                     
	                    System.out.print("Element: ");
	                    element = in.nextInt();                 
	
	                    list.insertLast(element);
	                    break;
	                case 42:
	                    int elements, max;
	                    Random randomGen = new java.util.Random(42); 
	                    
	                    System.out.print("Anzahl der Elemente: ");
	                    elements = in.nextInt();
	                    System.out.print("Maximum: ");
	                    max = in.nextInt();
	                   
	                    list.dispose1();
	                    
	                    for(int i = 1; i <= elements; i++) {
	                        list.insertFirst(randomGen.nextInt(max+1));
	                    }
	                    
	                    break;
	                default : 
	                	System.out.println("Noch nicht implementiert !!!");
	            }
            } catch (Exception e) {
            	choice = -1;
            	in.nextLine(); // skip die Zeile
            	System.out.println("Nur int-Werte möglich");
            }
        } while (choice != 0);
        in.close();
    }

}
