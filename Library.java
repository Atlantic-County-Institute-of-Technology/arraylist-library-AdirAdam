// Adir Adam 3.7.2025 Library.java
import java.util.ArrayList;
import java.util.Collections;


public class Library {      // Library class used as a collection of items object
    ArrayList <String> collection = new ArrayList<String>();            // Local variable to manage ArrayList

    public Library() {                          // Constructor for the collection variable
        this.collection = collection;
    }

    public void addItem(String addItem) {       // Adds an item to the collection
        collection.add(addItem);
    }

    public void removeItem(String removeItem) { // Removes an item through a for each loop
        for(String x: collection) {
            if (x.equals(removeItem)) {
                collection.remove(x);
            }
        }
    }

    public String getNextItem() {   // Returns the first item
        return collection.get(0);
    }

    public void skipNextItem() {    // Removes the first item
        collection.remove(0);
    }

    public void sortAlphabet() {    // Sorts the collection alphabetically through .sort
        collection.sort(null);
    }

    public int find(String searchItem) {    // Searches for the index of a specified item
        return collection.indexOf(searchItem);
    }

    public void shuffle() {
        Collections.shuffle(collection);    // Shuffles the Arraylist
    }


}
