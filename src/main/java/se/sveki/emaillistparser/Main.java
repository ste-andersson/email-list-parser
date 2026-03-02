package se.sveki.emaillistparser;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Give me a file path to a list of email addresses!");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
    }
}
