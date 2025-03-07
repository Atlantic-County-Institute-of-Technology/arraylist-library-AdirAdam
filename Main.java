// Adir Adam 3.7.2025 Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();                // Gets the stuff from the Library.java file
        Scanner userInput = new Scanner(System.in);     // Gets the Scanner
        String currentItem = "";        // Current item that is "playing"

        while (true) {      // Program loops unless the user wants to stop
            try {
                System.out.println("\nLibrary Menu:");      // Declares the "Main Menu"
                System.out.println("1. Play");
                System.out.println("2. Skip");
                System.out.println("3. Add");
                System.out.println("4. Remove");
                System.out.println("5. Sort");
                System.out.println("6. Shuffle");
                System.out.println("7. Find");
                System.out.println("8. View Queue");
                System.out.println("9. Exit");
                System.out.print("Choose an option: ");

                int choice = userInput.nextInt();   // Asks for user inputs
                userInput.nextLine();

                switch (choice) {          // Switch case so I don't have to do "if 1, if 2, etc etc"
                    case 1:     // This checks the current item
                        currentItem = library.getNextItem();
                        if (!currentItem.equals("Library is empty")) {
                            library.skipNextItem();
                            System.out.println("Now Playing: " + currentItem);
                        } else {
                            System.out.println("Library is empty.");
                        }
                        break;
                    case 2:     // This skips the current item
                        library.skipNextItem();
                        System.out.println("Skipped to the next item.");
                        break;
                    case 3:     // Allows the user to add an item to the queue
                        System.out.print("Enter item to add: ");
                        String addItem = userInput.nextLine();
                        library.addItem(addItem);
                        System.out.println(addItem + " added to library.");
                        break;
                    case 4:     // Allows the user to remove an item to the queue
                        System.out.print("Enter item to remove: ");
                        String removeItem = userInput.nextLine();
                        library.removeItem(removeItem);
                        System.out.println(removeItem + " removed from library (if it existed).");
                        break;
                    case 5:     // Sorts the list alphabetically & numerically
                        library.sortAlphabet();
                        System.out.println("Library sorted alphabetically.");
                        break;
                    case 6:     // Shuffles the list randomly
                        library.shuffle();
                        System.out.println("Library shuffled.");
                        break;
                    case 7:     // Finds the position of the item the user wants
                        System.out.print("Enter item to find: ");
                        String searchItem = userInput.nextLine();
                        int position = library.find(searchItem);
                        if (position != -1) {
                            System.out.println(searchItem + " found at position: " + position);
                        } else {
                            System.out.println(searchItem + " not found in library.");
                        }
                        break;
                    case 8:     // Allows the user to see whats in the queue
                        System.out.println("Library Queue:");
                        if (library.collection.isEmpty()) {
                            System.out.println("Library is empty.");
                        } else {
                            for (int i = 0; i < library.collection.size(); i++) {
                                System.out.println((i + 1) + ". " + library.collection.get(i));
                            }
                        }
                        break;
                    case 9:     // Exits the program
                        System.out.println("Goodbye.");
                        userInput.close();
                        return;
                    default:    // if the user does an invalid integer
                        System.out.println("Please select a valid input!");
                }
            } catch (Exception e) {     // if the user does an invalid character
                System.out.println("Invalid input. Please enter a number.");
                userInput.nextLine(); // Clear invalid input
            }
        }
    }
}