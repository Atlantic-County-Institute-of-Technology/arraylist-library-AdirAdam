import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner userInput = new Scanner(System.in);
        String currentItem = "";

        while (true) {
            try {
                System.out.println("\nLibrary Menu:");
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

                int choice = userInput.nextInt();
                userInput.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        currentItem = library.getNextItem();
                        if (!currentItem.equals("Library is empty")) {
                            library.skipNextItem();
                            System.out.println("Now Playing: " + currentItem);
                        } else {
                            System.out.println("Library is empty.");
                        }
                        break;
                    case 2:
                        library.skipNextItem();
                        System.out.println("Skipped to the next item.");
                        break;
                    case 3:
                        System.out.print("Enter item to add: ");
                        String addItem = userInput.nextLine();
                        library.addItem(addItem);
                        System.out.println(addItem + " added to library.");
                        break;
                    case 4:
                        System.out.print("Enter item to remove: ");
                        String removeItem = userInput.nextLine();
                        library.removeItem(removeItem);
                        System.out.println(removeItem + " removed from library (if it existed).");
                        break;
                    case 5:
                        library.sortAlphabet();
                        System.out.println("Library sorted alphabetically.");
                        break;
                    case 6:
                        library.shuffle();
                        System.out.println("Library shuffled.");
                        break;
                    case 7:
                        System.out.print("Enter item to find: ");
                        String searchItem = userInput.nextLine();
                        int position = library.find(searchItem);
                        if (position != -1) {
                            System.out.println(searchItem + " found at position: " + position);
                        } else {
                            System.out.println(searchItem + " not found in library.");
                        }
                        break;
                    case 8:
                        System.out.println("Library Queue:");
                        if (library.collection.isEmpty()) {
                            System.out.println("Library is empty.");
                        } else {
                            for (int i = 0; i < library.collection.size(); i++) {
                                System.out.println((i + 1) + ". " + library.collection.get(i));
                            }
                        }
                        break;
                    case 9:
                        System.out.println("Goodbye.");
                        userInput.close();
                        return;
                    default:
                        System.out.println("Please select a valid input!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                userInput.nextLine(); // Clear invalid input
            }
        }
    }
}