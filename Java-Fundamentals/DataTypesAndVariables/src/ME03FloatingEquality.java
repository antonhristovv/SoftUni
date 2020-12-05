import java.util.Scanner;

public class ME03FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double first = Double.parseDouble(scanner.nextLine());
        double second = Double.parseDouble(scanner.nextLine());
        double precisionLevel = 0.000001;
        if (Math.abs(first - second) >= precisionLevel) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
}
