package org.example.app.views;

import java.util.Scanner;


public class UserUpdateView {

    public String[] getData() {

        Scanner scanner = new Scanner(System.in);

        String title = "Enter user's username: ";
        System.out.print(title);
        String userName = scanner.nextLine().trim();

        title = "Enter new email in format example@mail.com: ";
        System.out.print(title);
        String email = scanner.nextLine().trim();

        return new String[]{userName, email};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
