package entity;

import java.util.List;

public class User {
    public User() {
    }

    String id;
    String name;
    String email;
    String password;
    public enum role {
        admin , student, teacher

    }
    role userRole;

    public role getUserRole() {
        return userRole;
    }

    public void setUserRole(role userRole) {
        this.userRole = userRole;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String id, String name, String email, String password, role userRole) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void borrowed() {
      if (role.admin == role.admin) {
          System.out.println("Admin can borrow books");
      } else if (role.student == role.student) {
          System.out.println("Student can borrow books");
      } else if (role.teacher == role.teacher) {
          System.out.println("Teacher can borrow books");
      } else {
          System.out.println("Invalid role");
      }
    }

    public void addUser(User user) {
        System.out.println("User added: " + user.getName());

    }
    public void removeUser(User user) {
        System.out.println("User removed: " + user.getName());

    }
    List<User> users;

}
