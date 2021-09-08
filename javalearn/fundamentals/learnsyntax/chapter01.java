package javalearn.fundamentals.learnsyntax;

import java.io.Console;
import java.util.Scanner;

public class chapter01 {
    /**
     * Выполняю примеры и упражнения из первой главы книги К. Хорстмана Java SE 9 Базовый курс
     * @param args
     */
    public static void main(String[] args) {
        // tryScanner();
        // tryConsole();
        exerciseOne(1000);
        System.out.println(exerciseTwo(123));
        System.out.println(exerciseTwo(-123));

    }

    private static void tryScanner() {
        /*
         * Тестирую Scanner
         */
        Scanner scanner = new Scanner(System.in);

        System.out.println("How old are you? ");
        int age = scanner.nextInt();
        System.out.println(age + " fuck");

        scanner.close();
    }

    private static void tryConsole() {
        /*
         * Тестирую Console
         */
        Console terminal = System.console();

        String userName = terminal.readLine("User name: ");
        char[] password = terminal.readPassword("Password: ");
        System.out.println("Hello, " + userName + "! I know your fucking password - " + password.toString() + "\nOoops.. Actually no.. :(");
    }
    
    private static void exerciseOne(int number) {
        /*
         * Выполняю первое упражнение
         */
        double doubledNumber = (double) number;

        String binaryRepr = Integer.toString(number, 2);
        String octaRepr = Integer.toString(number, 8);
        String hexRepr = Integer.toString(number, 16);
        String hexDoubleRepor = Double.toHexString(doubledNumber);

        System.out.println(binaryRepr);
        System.out.println(octaRepr);
        System.out.println(hexRepr);
        System.out.println(hexDoubleRepor);
    }

    private static int exerciseTwo(int number) {
        /*
         * Выполняю второе упражнение
         */
        return Math.floorMod(number, 359);

    }
}
