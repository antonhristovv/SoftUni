package Lab;

import java.util.Scanner;

public class L01RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        printRhombus(n);
    }

    private static void printRhombus(int stars) {
        for (int i = 1; i < stars; i++) {
            printRow(stars, i);
        }
        for (int i = stars; i >= 0; i--) {
            printRow(stars, i);
        }
    }

    private static void printRow(int stars, int row) {
        for (int j = 0; j < stars - row; j++) {
            System.out.print(" ");
        }
        for (int j = 0; j < row; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }

}
