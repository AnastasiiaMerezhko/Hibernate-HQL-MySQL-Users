package org.example.app.views;

import java.util.Scanner;

public class UserDeleteView {

    public String[] getData() {
        Scanner scanner = new Scanner(System.in);
        String title = "Enter user`s username: ";
        System.out.print(title);
        String userName = scanner.nextLine().trim();
        return new String[]{userName};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
