package Exercise;

import java.util.Scanner;

public class E01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            String[] input = scanner.nextLine().split(", ");
            int rows = Integer.parseInt(input[0]);
            String pattern = input[1];
            int[][] matrix = new int[rows][rows];
            if ("A".equals(pattern)) {
                fillMatrixInPatternA(matrix);
            } else {
                fillMatrixInPatternB(matrix);
            }
            printMatrix(matrix);
    }

    private static void fillMatrixInPatternB(int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = counter++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = counter++;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixInPatternA(int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = counter++;
            }
        }
    }
}
