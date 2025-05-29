public class Book {
    private String title;
    private String author;
    private String bookNo;
    public boolean isAvailable;

    public Book(String title, String author, String bookNo) {
        this.title = title;
        this.author = author;
        this.bookNo = bookNo;
        this.isAvailable = true;
    }

    // Getters & setters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getBookNo() { return bookNo; }
    public boolean isAvailable() { return isAvailable; }


    @Override
    public String toString() {
        return title + " by " + author + " (Book No.: " + bookNo + ") - " + 
               (isAvailable ? "Available" : "Borrowed");
    }
}