public class List {

    private Element L[];
    private int size;
    private int nextIndex;

    public List(int size) {
        L = new Element[size];
        this.size = size;
        nextIndex = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean addElement(Element elem) {
        if (nextIndex < size) {
            L[nextIndex] = elem;
            nextIndex++;
            return true;
        }
        return false;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < nextIndex; i++) {
            s += L[i] + "\n";
        }
        return s;
    }

    public void selectionSort(boolean aufsteigend) {
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                int res = L[i].compareTo(L[j]) * (aufsteigend ? 1 : -1);
                if (res > 0) {
                    Element tmp = L[j];
                    L[j] = L[i];
                    L[i] = tmp;
                }
            }
        }
    }

    public void bubbleSort(boolean aufsteigend) {
        for (int i = 0; i < size; i++) {
            boolean swap = false;
            for (int j = 0; j < size - 1; j++) {
                int res = L[j].compareTo(L[j + 1]) * (aufsteigend ? 1 : -1);
                if (res > 0) {
                    Element tmp = L[j];
                    L[j] = L[j + 1];
                    L[j + 1] = tmp;
                    swap = true;
                }
            }

            if (!swap)
                break;
        }
    }

    public void insertionSort(boolean aufsteigend) {
        for (int i = 1; i < size; i++) {
            int j = 0;
            for (; j < i; j++) {
                int res = L[i].compareTo(L[j]) * (aufsteigend ? -1 : 1);
                if (res > 0) {
                    break;
                }
            }

            Element tmp = L[i];

            for (int k = i; k > j; k--) {
                L[k] = L[k - 1];
            }

            L[j] = tmp;
        }
    }


}
