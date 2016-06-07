import java.util.Random;
import java.util.StringTokenizer;
import java.io.*;


public class SortTest {

    private static String[] vName = {"Bernd", "Natalie", "Kathrin", "Martin", "Michael", "Thomas", "Judith", "Ullrich", "Tina", "Udo", "Rolf", "Klaus", "Fritz", "Sebb"};
    private static String[] nName = {"Weber", "Brot", "Schiwy", "Bunke", "Braun", "Schmidt", "Schmid", "Schmit", "Schmitt", "Weber", "Meier", "Metzger", "Mueller", "Rössler"};
    private static String[] hobby = {"Surfen", "Schwimmen", "Reiten", "Fußball", "Lesen", "Malen", "Kung-Fu", "Kegeln", "Tennis", "Laufen", "Hallen-Halma", "Tanzen", "Angeln"};


    public static void main(String[] args) {
        // reference to list
        List list = null;
        boolean aufsteigend = true;

        // input
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int choice = -1;  // show menu

        // menu
        do {
            if (choice == -1) {
                System.out.println();
                System.out.println((aufsteigend ? "aufsteigende" : "absteigende") + " Sortierung: " + Element.getSortOrderNames());
                System.out.println(" 0. Programm beenden");
                System.out.println(" 1. Liste neu anlegen und vorbelegen");
                System.out.println(" 2. Liste ausgeben");
                System.out.println(" 3. Liste sortieren (Selection)");
                System.out.println(" 4. Liste sortieren (Insertion)");
                System.out.println(" 5. Liste sortieren (Bubble)");
                System.out.println("42. Sortierordnung ändern");
                System.out.println("43. Sortierrichtung ändern");
            }

            System.out.print("Eingabe: ");
            try {   // read a line and convert it to integer
                input = buffer.readLine().trim();
                choice = Integer.parseInt(input);
            } catch (Exception e) {
                choice = -1;  // show menu
            }

            switch (choice) {
                case 0:
                    break;
                case 1:
                    int size;

                    System.out.print("Länge: ");
                    try {   // read a line and convert it to integer
                        input = buffer.readLine().trim();
                        size = Integer.parseInt(input);
                    } catch (Exception e) {
                        size = 10;
                    }

                    list = new List(size);
                    Random randomGen = new java.util.Random(42);
                    // Liste voll belegen
                    for (int i = 0; i < size; i++) {
                        list.addElement(new Element(850000 + randomGen.nextInt(9999 + 1),
                                vName[randomGen.nextInt(vName.length)],
                                nName[randomGen.nextInt(nName.length)],
                                hobby[randomGen.nextInt(hobby.length)]));
                    }
                    break;
                case 2:
                    if (list != null) System.out.println(list);
                    break;
                case 3:
                    Element.setCompareCounter(0);
                    if (list != null) list.selectionSort(aufsteigend);
                    System.out.println(Element.getCompareCounter() + " Vergleiche bei " + list.getSize() + " Elementen");
                    break;
                case 4:
                    Element.setCompareCounter(0);
                    if (list != null) list.insertionSort(aufsteigend);
                    System.out.println(Element.getCompareCounter() + " Vergleiche bei " + list.getSize() + " Elementen");
                    break;
                case 5 :
                    Element.setCompareCounter(0);
                    if (list != null) list.bubbleSort(aufsteigend);
                    System.out.println(Element.getCompareCounter() + " Vergleiche bei " + list.getSize() + " Elementen");
                    break;
                case 42:
                    StringTokenizer st;
                    int[] sortOrder;

                    System.out.print("max " + Element.getNumberOfAttributes() + "-Tupel ohne Wiederholungen aus ");

                    for (int i = 0; i < Element.getNumberOfAttributes(); i++)
                        System.out.print(i + "(" + Element.getAttributeNames()[i] + ") ");

                    System.out.println();

                    try {   // read a line and convert it to integer values
                        input = buffer.readLine().trim();
                        st = new StringTokenizer(input);

                        // sortOrder-Tupel mindestens 1, maximal #Attribute lang

                        if ((st.countTokens() < 1) || (st.countTokens() > Element.getNumberOfAttributes()))
                            throw new Exception();

                        sortOrder = new int[st.countTokens()];

                        for (int i = 0; i < sortOrder.length; i++) {
                            sortOrder[i] = Integer.parseInt(st.nextToken());

                            // jeder sort-Order Eintrag gr��ergleich 0 und kleiner #Attribute
                            if ((sortOrder[i] < 0) || (sortOrder[i] >= Element.getNumberOfAttributes()))

                                throw new Exception();
                        }

                        // Doubletten erkennen
                        for (int i = 0; i < sortOrder.length; i++)
                            for (int j = i + 1; j < sortOrder.length; j++)
                                if (sortOrder[i] == sortOrder[j])
                                    throw new Exception();

                    } catch (Exception e) {
                        sortOrder = new int[]{0};
                    }

                    Element.setSortOrder(sortOrder);
                    break;
                case 43:
                    aufsteigend = !aufsteigend;
                    System.out.println("jetzt " + (aufsteigend ? "aufsteigende" : "absteigende") + " Sortierung");
                    break;
                default :
                    System.out.println("Nicht definiert");
            }


        } while (choice != 0);
    }
}

