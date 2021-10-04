package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);
        List<List<Integer>> matrix = new ArrayList<>();
        fillMatrix(rows, cols, matrix);

        String input = scanner.nextLine();
        while (!"Nuke it from orbit".equals(input)) {
            int destroyRow = Integer.parseInt(input.split("\\s+")[0]);
            int destroyCol = Integer.parseInt(input.split("\\s+")[1]);
            int destroyRadius = Integer.parseInt(input.split("\\s+")[2]);

            //destroy up and down from destroy row
            for (int currentRow = destroyRow - destroyRadius; currentRow < destroyRow + destroyRadius; currentRow++) {
                if (isInMatrix(currentRow, destroyCol, matrix)) {
                    matrix.get(currentRow).remove(destroyCol);
                }
            }
            //destroy left and right from destroy col
            for (int currentCol = destroyCol + destroyRadius; currentCol >= destroyCol - destroyRadius; currentCol--) {
                if (isInMatrix(destroyRow, currentCol, matrix)) {
                    matrix.get(destroyRow).remove(currentCol);
                }
            }
            matrix.removeIf(List::isEmpty);
            input = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInMatrix(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void fillMatrix(int rows, int cols, List<List<Integer>> matrix) {
        int counter = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(counter++);
            }
        }
    }
}
