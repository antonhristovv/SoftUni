package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class L05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int maxSum = 0;
        int[][] matrix = readMatrix(rows, cols, ", ", scanner);
        int[][] bestMatrix = new int[2][2];
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int start = matrix[row][col];
                int upRight = matrix[row][col + 1];
                int bellow = matrix[row + 1][col];
                int downRight = matrix[row + 1][col + 1];
                int currentSum = start + upRight + bellow + downRight;
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    bestMatrix[0][0] = start;
                    bestMatrix[0][1] = upRight;
                    bestMatrix[1][0] = bellow;
                    bestMatrix[1][1] = downRight;
                }
            }
        }
        for (int row = 0; row < bestMatrix.length; row++) {
            for (int col = 0; col < bestMatrix[row].length; col++) {
                System.out.print(bestMatrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }

    private static int[][] readMatrix(int rows, int cols, String delimiter, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(delimiter))
                    .mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
}
