package Exercise;

import java.util.Scanner;

public class E05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rowsAndCols = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);
        String[][] matrix = readMatrix(rows, scanner);
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            if (validateInput(input, rows, cols)) {
                String[] commands = input.split("\\s+");
                int row1 = Integer.parseInt(commands[1]);
                int col1 = Integer.parseInt(commands[2]);
                int row2 = Integer.parseInt(commands[3]);
                int col2 = Integer.parseInt(commands[4]);
                String swap = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = swap;
                printMatrix(matrix);

            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }

    private static boolean validateInput(String commands, int rows, int cols) {
        String[] commandParts = commands.split("\\s+");
        String command = commandParts[0];
        if (!"swap".equals(command)) {
            return false;
        }
        if (commandParts.length != 5) {
            return false;
        }
        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);
        return row1 >= 0 && row1 < rows && col1 >= 0 && col1 < cols && row2 >= 0
                && row2 < rows && col2 >= 0 && col2 < cols;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (int col = 0; col < strings.length; col++) {
                System.out.print(strings[col]);
                if (col != strings.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static boolean validateCoordinates(int matrixRows, int matrixCols, int row1, int col1, int row2, int col2) {
        return (row1 < matrixRows && col1 < matrixCols && row2 < matrixRows && col2 < matrixCols);
    }

    private static String[][] readMatrix(int rows, Scanner scanner) {
        String[][] matrix = new String[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }

        return matrix;
    }
}
