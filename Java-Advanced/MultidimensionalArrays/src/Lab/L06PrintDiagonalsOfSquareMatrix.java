package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class L06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(size, scanner);
        int[][] diagMatrix = new int[2][size];
        for (int row = 0; row < size; row++) {
            diagMatrix[0][row] = matrix[row][row];
        }
        for (int row = 0; row < size; row++) {
            diagMatrix[1][row] = matrix[size - row - 1][row];
        }
        for (int row = 0; row < diagMatrix.length; row++) {
            for (int col = 0; col < diagMatrix[row].length; col++) {
                System.out.print(diagMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(int size, Scanner scanner) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
}
