package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class L01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] firstMatrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                firstMatrix[row][col] = scanner.nextInt();
            }
            /*int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            firstMatrix[row] = arr;*/
        }

        //int[][] firstMatrix = readMatrix(scanner, "\\s+");
        //int[][] secondMatrix = readMatrix(scanner, "\\s+");

        rows = scanner.nextInt();
        cols = scanner.nextInt();
        int[][] secondMatrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                secondMatrix[row][col] = scanner.nextInt();
            }
        }

        boolean areEqual = compareMatrices(firstMatrix, secondMatrix);
        if (areEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

        //System.out.println(areEqual ? "equal" : "not equal");

    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int[][] readMatrix(Scanner scanner, String splitPattern) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(splitPattern)).mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(splitPattern)).mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
}
