package entity;

public class Book {

    private int id;
    private String bookName;
    private boolean isAvailable = true;

    public Book() {
    }

    public Book(int id, String bookName, boolean isAvailable) {
        this.id = id;
        this.bookName = bookName;
        this.isAvailable = isAvailable;
    }

    public Book(int id, String name) {
        this.id = id;
        this.bookName = name;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.bookName = name;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return bookName;
    }

}
