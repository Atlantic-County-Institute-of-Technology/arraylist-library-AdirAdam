import java.util.ArrayList;
import java.util.Collections;


public class Library {
    ArrayList <String> collection = new ArrayList<String>();

    public Library(ArrayList <String> collection) {
        this.collection = collection;
    }

    public void addItem(String addItem) {
        collection.add(addItem);
    }

    public void removeItem(String removeItem) {
        for(String x: collection) {
            if (x.equals(removeItem)) {
                collection.remove(x);
            }
        }
    }

    public String getNextItem() {
        return collection.get(0);
    }

    public void skipNextItem() {
        collection.remove(0);
    }

    public void sortAlphabet() {
        collection.sort(null);
    }

    public int find(String searchItem) {
        return collection.indexOf(searchItem);
    }

    public void shuffle() {
        Collections.shuffle(collection);    // ues
    }


}
