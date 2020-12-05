import java.util.Scanner;

public class L02PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pounds = scanner.nextDouble();
        double usd = pounds * 1.31;
        System.out.printf("%.3f", usd);
    }
}
