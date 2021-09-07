package javalearn.fundamentals.learnsyntax;

import java.io.Console;
import java.util.Scanner;

public class chapter01 {
    public static void main(String[] args) {
        // tryScanner();
        tryConsole();
    }

    private static void tryScanner() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How old are you? ");
        int age = scanner.nextInt();
        System.out.println(age + " fuck");

        scanner.close();
    }

    private static void tryConsole() {
        Console terminal = System.console();

        String userName = terminal.readLine("User name: ");
        char[] password = terminal.readPassword("Password: ");
        System.out.println("Hello, " + userName + "! I know your fucking password - " + password.toString() + "\nOoops.. Actually no.. :(");
    }
    
}
