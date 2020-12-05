import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        for (int times = 0; times < 10; times++) {
            System.out.printf("%d X %d = %d%n", input, times + 1, input * (times + 1));
        }
    }
}
