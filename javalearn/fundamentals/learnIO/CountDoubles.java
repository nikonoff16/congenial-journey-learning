package javalearn.fundamentals.learnIO;

import java.util.Scanner;
import java.util.InputMismatchException;

public class CountDoubles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double result = 0;

        while (scanner.hasNext()) {
            try {
                result += scanner.nextDouble();
            } catch (InputMismatchException e) {
                scanner.next();
            }
        }
        scanner.close();

        System.out.printf("%.6f", result);
    }
}
