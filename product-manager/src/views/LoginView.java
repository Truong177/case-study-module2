package views;

import models.login.Login;

import java.util.Scanner;

public class LoginView {
    public Login viewLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("____________Sign In________");
        System.out.print("Username:");
        String userName = sc.nextLine();
        System.out.print("Password:");
        String passWord = sc.nextLine();
        Login login = new Login(userName, passWord);
        return login;
    }

    public void viewMessage(boolean result) {
        if (result) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
    }
}
