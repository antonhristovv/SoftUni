import java.util.Scanner;

public class MultiplicationTableTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());
        if (multiplier <= 10) {
            for (int times = multiplier; times <= 10; times++) {
                System.out.printf("%d X %d = %d%n", input, times, input * (times));
            }
        } else {
            System.out.printf("%d X %d = %d%n", input, multiplier, input * multiplier);
        }
    }
}
