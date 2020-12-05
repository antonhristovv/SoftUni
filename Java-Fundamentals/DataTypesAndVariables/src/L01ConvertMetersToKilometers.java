import java.util.Scanner;

public class L01ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double meters = scanner.nextDouble();
        double kilometers = meters / 1000;
        System.out.printf("%.2f", kilometers);
    }
}
