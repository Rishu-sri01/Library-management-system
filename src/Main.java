import entity.Book;
import entity.User;
import service.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the Library Management System");
        login loginService = new login();
         loginService.checkUser();
    }
}