import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Show All Books");
            System.out.println("4. Show All Users");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Borrow Book");
            System.out.println("7. Return Book");
            System.out.println("8. Delete user");
            System.out.println("9. User details");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    
                    System.out.print("Book number: ");
                    String bookNo = scanner.nextLine();
                    
                    library.addBook(new Book(title, author, bookNo));
                    System.out.println("Book added.");
                    break;
                case 2:
                    System.out.println("Name: ");
                    String name = scanner.nextLine();
                    library.addUser(new User(name));
                    break;
                case 3:
                    library.showAllBooks();
                    break;
                case 4:
                    library.showAllUsers();
                    break;
                case 5:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    Book found = library.findBookByTitle(searchTitle);
                    
                    /*Simpler and faster way to write a if-else statement
                    System.out.println(found != null ? found : "Book not found."); */
                    
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Book not found.");
                    }
                    
                    break;
                case 6:
                    System.out.print("Enter title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    System.out.println("Enter username: ");
                    String username = scanner.nextLine();
                    Book toBorrow = library.findBookByTitle(borrowTitle);
                    
                    if (toBorrow != null && toBorrow.isAvailable()) {
                        library.borrowBook(borrowTitle, username);
                        System.out.println("Book borrowed.");
                    } else {
                        System.out.println("Book not available.");
                    }
                    break;
                case 7:
                    System.out.print("Enter title to return: ");
                    String returnTitle = scanner.nextLine();
                    System.out.println("Enter username: ");
                    String userName = scanner.nextLine();

                    Book toReturn = library.findBookByTitle(returnTitle);
                    
                    if (toReturn != null && !toReturn.isAvailable()) {
                        library.returnBook(returnTitle, userName);
                        System.out.println("Book returned.");
                    } else {
                        System.out.println("Book is already available.");
                    }
                    break;
                case 8:
                    System.out.println("Enter User to delete: ");
                    String deleteUser = scanner.nextLine();
                    library.removeUser(deleteUser);
                    break;
                case 9:
                    System.out.println("Username: ");
                    String n = scanner.nextLine();
                    library.showUserDetails(n);
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);

        scanner.close();
    }
}