package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] command = scanner.nextLine().split("\\(");
        int rotationAngle = Integer.parseInt(command[1].split("\\)")[0]) % 360;
        String input = scanner.nextLine();
        ArrayDeque<String> textLines = new ArrayDeque<>();
        int maxSize = 0;
        while (!"END".equals(input)) {
            textLines.offer(input);
            if (input.length() > maxSize) {
                maxSize = input.length();
            }
            input = scanner.nextLine();
        }
        int rows = textLines.size();
        int cols = maxSize;
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            String current = textLines.poll();
            for (int i = 0; i < matrix[row].length; i++) {
                if (i > current.length() - 1) {
                    matrix[row][i] = ' ';
                } else {
                    char currentChar = current.charAt(i);
                    matrix[row][i] = currentChar;
                }
            }
        }

        rotateMatrix(matrix, rows, cols, rotationAngle);

    }

    private static void rotateMatrix(char[][] matrix, int rows, int cols, int rotationAngle) {
        if (rotationAngle == 90) {
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotationAngle == 180) {
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotationAngle == 270) {
            for (int col = cols - 1; col >= 0; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }
}
