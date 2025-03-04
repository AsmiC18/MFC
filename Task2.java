import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arrays to store book titles and authors
        String[] books = new String[10];
        String[] authors = new String[10];
        int count = 0;  // Counter to track number of books

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book (Create)");
            System.out.println("2. View Books (Read)");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                // Create: Add a new book
                if (count < 10) {
                    System.out.print("Enter book title: ");
                    books[count] = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    authors[count] = scanner.nextLine();
                    count++;
                    System.out.println("Book added successfully!");
                } else {
                    System.out.println("Library is full.");
                }
            } else if (choice == 2) {
                // Read: Display all books
                if (count == 0) {
                    System.out.println("No books available.");
                } else {
                    System.out.println("Books in Library:");
                    for (int i = 0; i < count; i++) {
                        System.out.println((i + 1) + ". " + books[i] + " by " + authors[i]);
                    }
                }
            } else if (choice == 3) {
                // Update: Modify book details
                System.out.print("Enter book number to update: ");
                int bookNum = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                if (bookNum > 0 && bookNum <= count) {
                    System.out.print("Enter new title: ");
                    books[bookNum - 1] = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    authors[bookNum - 1] = scanner.nextLine();
                    System.out.println("Book updated successfully!");
                } else {
                    System.out.println("Invalid book number.");
                }
            } else if (choice == 4) {
                // Delete: Remove a book
                System.out.print("Enter book number to delete: ");
                int bookNum = scanner.nextInt();
                if (bookNum > 0 && bookNum <= count) {
                    // Shift remaining books to fill the deleted spot
                    for (int i = bookNum - 1; i < count - 1; i++) {
                        books[i] = books[i + 1];
                        authors[i] = authors[i + 1];
                    }
                    books[count - 1] = null;  // Clear the last book
                    authors[count - 1] = null;  // Clear the last author
                    count--;
                    System.out.println("Book deleted successfully!");
                } else {
                    System.out.println("Invalid book number.");
                }
            } else if (choice == 5) {
                // Exit
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();  // Close the scanner when done
    }
}
