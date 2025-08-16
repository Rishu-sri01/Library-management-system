package service;

import entity.Book;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService {

    // This class manages the library's book collection
    public void managebook(){
        Scanner sc = new Scanner(System.in);
        BookService bookService = new BookService();
        System.out.println("Welcome to the Library Management System");
        System.out.println("Book management dashboard\n"
                + "1. View all books\n"
                + "2. Add a new book\n"
                + "3. Remove a book\n"
                + "4. Exit");
        System.out.println("Please select an option (1, 2, 3 or 4):");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                bookService.getAll();
                break;
            case 2:
                bookService.addBook();
                break;
            case 3:
                System.out.println("Enter the ID of the book to remove:");
                int id = sc.nextInt();
                bookService.removeBook(id);
                break;
            case 4:
                System.out.println("Exiting the application. Thank you!");
                return; // Exit the application
            default:
                System.out.println("Invalid option selected. Please try again.");
        }
    }

    List<Book> books = new ArrayList<>();
    public List<Book> getAllBooks() {

        books.add(new Book(1, "The Great Gatsby"));
        books.add(new Book(2, "To Kill a Mockingbird"));
        books.add(new Book(3, "1984"));
        books.add(new Book(4, "Pride and Prejudice"));
        books.add(new Book(5, "The Catcher in the Rye"));
        return books;
    }
    //Add a new book to the library
    public void addBook(){
        Scanner sc = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Enter book ID:");
       int id = sc.nextInt();
        book.setId(id);
        sc.nextLine(); // Consume newline left-over
        System.out.println("Enter book name:");
        String name = sc.nextLine();
        book.setName(name);
        // Check if the book with the same ID already exists
        for (Book b : books) {
            if (b.getId() == id) {
                System.out.println("Book with ID " + id + " already exists.");
                return;

            }

        }
        addBook(book);

    }
    public Book getBookById(int id) {
        List<Book> books = getAllBooks();
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        System.out.println("No book found with ID: " + id);
        managebook(); // Return to the book management dashboard
         // If no book is found with the given ID, return null
        return null; // Return null if no book is found with the given ID

    }

public void addBook(Book book) {
        List<Book> books = getAllBooks();
        books.add(book);
        System.out.println("Book added successfully: " + book.getName());
        managebook();
    }

    public void removeBook(int id) {
        List<Book> books = getAllBooks();
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getId() == id) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book removed successfully: " + bookToRemove.getName());
        } else {
            System.out.println("No book found with ID: " + id);
        }
        managebook();
    }

    public List<Book> getAll() {
        // This method retrieves all books from the library
        List<Book> books = getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Available books:");
            for (Book book : books) {
                System.out.println("ID: " + book.getId() + ", Name: " + book.getName());
            }
        }
        managebook();
        return books;
    }
}

