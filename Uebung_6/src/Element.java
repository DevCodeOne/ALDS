public class Element implements Comparable {

    private static String[] attributeNames = {"Matrikelnummer", "Vorname", "Nachname", "Hobby"};
    private static int numberOfAttributes = attributeNames.length;
    private static int[] sortOrder = {0};

    private static long compareCounter = 0;

    private int matNr;
    private String vName;
    private String nName;
    private String hobby;

    public Element(int matNr, String vName, String nName, String hobby) {
        this.matNr = matNr;
        this.vName = vName;
        this.nName = nName;
        this.hobby = hobby;
    }

    public Element() {
        this(0, "Max", "Mustermann", "Surfen");
    }

    public int getMatNr() {
        return matNr;
    }

    public void setMatNr(int matNr) {
        this.matNr = matNr;
    }

    public String getVName() {
        return vName;
    }

    public void setVName(String name) {
        vName = name;
    }

    public String getNName() {
        return nName;
    }

    public void setNName(String name) {
        nName = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public static String[] getAttributeNames() {
        return attributeNames;
    }

    public static int getNumberOfAttributes() {
        return numberOfAttributes;
    }

    public static void setSortOrder(int[] sortOrder) {
        Element.sortOrder = sortOrder;
    }

    public static String getSortOrderNames() {
        String s = "";
        for (int i = 0; i < sortOrder.length; i++)
            s += attributeNames[sortOrder[i]] + " ";
        return s;
    }

    public static long getCompareCounter() {
        return compareCounter;
    }

    public static void setCompareCounter(long compareCounter) {
        Element.compareCounter = compareCounter;
    }

    public String toString() {
        return (matNr + " : " + vName + " " + nName + ", " + hobby);
    }

    public int compareTo(Object o) {
        // negativ falls dieses Objekt kleiner als o ist
        // 0       falls dieses Objekt gleich o ist
        // positiv falls dieses Objekt größer als o ist

        compareCounter++;

        int res = 0;
        for (int i = 0; i < sortOrder.length; i++) {
            switch(sortOrder[i]) {
                case 0 :
                    res = Integer.compare(matNr, ((Element) o).matNr);
                    break;
                case 1 :
                    res = vName.compareTo(((Element) o).vName);
                    break;
                case 2 :
                    res = nName.compareTo(((Element) o).nName);
                    break;
                case 3 :
                    res = hobby.compareTo(((Element) o).hobby);
                    break;
            }

            if (res != 0)
                return res; // alternativ auch einfach break
        }
        return res;


    }
}
