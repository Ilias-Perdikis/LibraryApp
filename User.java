import java.util.ArrayList;

public class User {
    private String name;
    public ArrayList<Book> userBooks = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void borrowed(Book book){
        userBooks.add(book);
    }

    public void returned(Book book){
        userBooks.remove(book);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBooks(){
        return userBooks;
    }

    @Override
    public String toString(){
        return "User " + name + " has borrowed " + userBooks.size() + " books in total.";
    }
}
