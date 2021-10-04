package Exercise;

import java.util.Scanner;

public class E04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        int[] maxSumAndStartCoordinates = calculateMaxSumAndCoordinates(matrix);
        int maxSum = maxSumAndStartCoordinates[0];
        int bestRow = maxSumAndStartCoordinates[1];
        int bestCol = maxSumAndStartCoordinates[2];
        System.out.println("Sum = " + maxSum);
        for (int row = bestRow; row < bestRow + 3; row++) {
            for (int col = bestCol; col <= bestCol + 2; col++) {
                System.out.print(matrix[row][col]);
                if (col != bestCol + 2) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static int[] calculateMaxSumAndCoordinates(int[][] matrix) {
        int sum = 0;
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row <= matrix.length - 3; row++) {
            for (int col = 0; col <= matrix[row].length - 3; col++) {
                int currentSum = 0;
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        currentSum += matrix[i][j];
                    }
                }
                if (currentSum > sum) {
                    sum = currentSum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        return new int[] {sum, bestRow, bestCol};
    }
}
