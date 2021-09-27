package Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class L08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(rows, scanner);
        int wrongValueRow = scanner.nextInt();
        int wrongValueCol = scanner.nextInt();
        int wrongValue = matrix[wrongValueRow][wrongValueCol];
        List<int[]> wrongIndexes = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int current = matrix[row][col];
                if (current == wrongValue) {
                    wrongIndexes.add(new int[] {row, col});
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int current = matrix[row][col];
                if (current == wrongValue) {
                    current = checkAndCalculate(matrix, row, col, wrongValue, wrongIndexes);
                    matrix[row][col] = current;
                }
            }
        }
        printMatrix(matrix, " ");
    }

    private static int checkAndCalculate(int[][] matrix, int row, int col, int wrongValue, List<int[]> wrongIndexes) {
        int toBeAdded = 0;
        //TODO reduce if statements
        if (row > 0) {
            int[] currentIndex = {row - 1, col};
            int upper = matrix[row - 1][col];
            if (upper != wrongValue && isNotWrongIndex(wrongIndexes, currentIndex)) {
                toBeAdded += upper;
            }
        }
        if (col > 0) {
            int[] currentIndex = {row, col - 1};
            int left = matrix[row][col - 1];
            if (left != wrongValue && isNotWrongIndex(wrongIndexes, currentIndex)) {
                toBeAdded += left;
            }
        }
        if (row < matrix.length - 1) {
            int[] currentIndex = {row + 1, col};
            int lower = matrix[row + 1][col];
            if (lower != wrongValue && isNotWrongIndex(wrongIndexes, currentIndex)) {
                toBeAdded += lower;
            }
        }
        if (col < matrix[row].length - 1) {
            int[] currentIndex = {row, col + 1};
            int right = matrix[row][col + 1];
            if (right != wrongValue && isNotWrongIndex(wrongIndexes, currentIndex)) {
                toBeAdded += right;
            }
        }
        return toBeAdded;
    }

    private static boolean isNotWrongIndex(List<int[]> wrongIndexes, int[] currentIndex) {
        int currentRow = currentIndex[0];
        int currentCol = currentIndex[1];
        for (int[] wrongIndex : wrongIndexes) {
            if (wrongIndex[0] == currentRow && wrongIndex[1] == currentCol) {
                return false;
            }
        }
        return true;
    }

    private static int[][] readMatrix(int rows, Scanner scanner) {
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix, String delimiter) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
                if (col != matrix[row].length - 1) {
                    System.out.print(delimiter);
                }
            }
            System.out.println();
        }
    }
}
