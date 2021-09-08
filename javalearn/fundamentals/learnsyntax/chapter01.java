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
        System.out.println(exerciseThreeA(3, 2, 1));
        System.out.println(exerciseThreeB(3, 2, 1));
        exerciseFour();

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

    private static int exerciseThreeA(int first, int second, int third) {
        int result = 0;
        if (first > second) {
            if (first > third) {
                result = first;
            } else {
                result = third;
            }
        } else {
            if (second > third) {
                result = second;
            } else {
                result = third;
            }
        }
        return result;
    }
    
    private static int exerciseThreeB(int first, int second, int third) {
        return Math.max(Math.max(first, second), third);
    }
    
    private static void exerciseFour() {
        /*
         * Напишите программу, выводящую  наименьшее и наибольшее положительные значения типа double
         * Можно воспользоваться Math.nextUp()
         */

        System.out.println(Math.nextUp(Double.MAX_VALUE));
        System.out.println(Math.nextUp(0));

    }
}
