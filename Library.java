import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;


    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(String user) {
        User toRemove = null;
        for (User u : users) {
            if (u.getName().toUpperCase().equals(user.toUpperCase())) {
                toRemove = u;
                break;
            }
        }

        if (toRemove != null) {
            if(toRemove.getBooks().size() != 0)
            {
                System.out.println("User has not returned all borrowed books. Cannot be deleted!");
            }else{
                users.remove(toRemove);
                System.out.println("User removed: " + user);
            }
        } else {
            System.out.println("User not found: " + user);
        }
    }

    public User findUser(String name) {
        for (User u : users) {
            if (u.getName().toUpperCase().equals(name.toUpperCase())) {
                return u;
            }
        }
        return null;
    }

    public void borrowBook(String title, String name){
        Book available = null;
        for (Book b : books)
        {
            if (b.getTitle().toUpperCase().equals(title.toUpperCase()) && b.isAvailable()) {
                b.isAvailable = false;
                available = b;
                break;
            }
        }

        if (available != null) {
            User currentUser = findUser(name);
            
            if (currentUser != null) {
                currentUser.borrowed(available);
                System.out.println(name + " borrowed " + title);
            } else {
                System.out.println("User " + name + "not found!");
            }
        } else {
            System.out.println("Book " + title + " not available!");
        }
    }

    public void returnBook(String title, String name){
        Book returned = null;
        for (Book b : books)
        {
            if (b.getTitle().toUpperCase().equals(title.toUpperCase()) && !b.isAvailable()) {
                b.isAvailable = true;
                returned = b;
                break;
            }
        }

        if (returned != null) {
            User currentUser = findUser(name);
            
            if (currentUser != null) {
                currentUser.returned(returned);
                System.out.println(name + " return " + title);
            } else {
                System.out.println("User " + name + "not found!");
            }
        } else {
            System.out.println("Book " + title + " not available!");
        }
    }

    public void showAllUsers() {
        for (User u : users) {
            System.out.println(u);
        }
    }

    public void showAllBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void showUserDetails(String userDet){
        User n = findUser(userDet);
        System.out.println("Details of user " + userDet + ": " + n.getBooks());
    }

    public Book findBookByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().toUpperCase().equals(title.toUpperCase())) {
                return b;
            }
        }
        return null;
    }
}