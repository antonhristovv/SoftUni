import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 0; i < count; i++) {
            int currentOdd = 2 * i + 1;
            sum += currentOdd;
            System.out.println(currentOdd);
        }

        System.out.printf("Sum: %d%n", sum);
    }
}
