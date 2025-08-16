package service;
import entity.Book;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class login {
    Scanner sc = new Scanner(System.in);
    List<User> userList = new ArrayList<>();


    public void checkUser() {
try {


    User user=new User("1","Rishabh","r@1", "1234", User.role.admin);
    userList.add(user);

    System.out.println("Welcome to the Library Management System");
    System.out.println("User login dashboard\n"
            + "1. Login\n"
            + "2. Register\n" +
            "  3. Exit"
    );
    System.out.println("Please select an option (1 or 2 or 3):");
    // Read user input for login or registration
    int UserDetails = sc.nextInt();

    if (UserDetails == 1) {
        System.out.println("You have selected to login");
        loginUser();

    } else if (UserDetails == 2) {
        System.out.println("You have selected to register");
        register();

    } else if (UserDetails == 3) {
        System.out.println("Exiting the application. Thank you!");
        System.exit(0); // Exit the application
    } else {
        System.out.println("Invalid option selected. Please try again.");
        checkUser(); // Return an error code for invalid selection
    }
} catch (Exception e) {
    System.out.println("An error occurred: " + e.getMessage());
    sc.nextLine(); // Clear the scanner buffer
    checkUser(); // Return to the user login dashboard after an error
}
    }
        public void loginUser() {

            System.out.println("Enter your email");
            String email = sc.next();
            System.out.println("Enter your password");
            String password = sc.next();

            // Validate email and password
            // This is a simple validation. In a real application, you would hash the password and compare it securely.
            // Here you would typically check the email and password against a database

            if (email.isEmpty() || password.isEmpty() || !email.contains("@")) {
                System.out.println("Email or password cannot be empty or invalid");
                return;
            }
            boolean emailExists = false;
            for (User u : userList) {
                if (u.getEmail().equalsIgnoreCase(email)) {
                    emailExists = true;
                    if (u.getPassword().equals(password)) {
                        System.out.println("Login successful for user: " + u.getName());

                        BookService bookService = new BookService();
                        System.out.println("Welcome " + u.getName() + "! You are logged in as a " + u.getUserRole());
                        bookService.managebook(); // Call the book management service
                        return;

                    }
                }
            }
            if (!emailExists) {
                System.out.println("Email not found. Please register first.");
                return;
            }


        }
        public void register(){

            System.out.println("Enter your name");
            String name = sc.next();
            System.out.println("Enter your email");
            String email = sc.next();
            System.out.println("Enter your password");
            String password = sc.next();
            System.out.println("Select your role:\n"
                    + "1. Admin\n"
                    + "2. Student\n"
                    + "3. Teacher");
            int roleChoice = sc.nextInt();
            User.role userRole = switch (roleChoice) {
                case 1 -> User.role.admin;
                case 2 -> User.role.student;
                case 3 -> User.role.teacher;
                default -> {
                    System.out.println("Invalid role selected. Defaulting to Student.");
                    yield User.role.student;
                }
            };
            // Here you would typically save the new user to a database
            System.out.println("Registration successful for user: " + name);
            User newUser = new User();
            newUser.setName(name);
            newUser.setEmail(email);
            newUser.setPassword(password);
            newUser.setUserRole(userRole);
            userList.add(newUser);
           checkUser(); // Return to the user login dashboard after registration
    }
}

