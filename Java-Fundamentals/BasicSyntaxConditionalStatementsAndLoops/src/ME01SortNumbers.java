import java.util.Scanner;

public class ME01SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());
        if (third >= second && second >= first) {
            System.out.printf("%d%n%d%n%d", third, second, first);
        } else if (first >= third && third >= second) {
            System.out.printf("%d%n%d%n%d", first, third, second);
        } else if (second >= first && first >= third) {
            System.out.printf("%d%n%d%n%d", second, first, third);
        } else if (second >= third && third >= first) {
            System.out.printf("%d%n%d%n%d", second, third, first);
        } else if (third >= first) {
            System.out.printf("%d%n%d%n%d", third, first, second);
        } else {
            System.out.printf("%d%n%d%n%d", first, second, third);
        }

    }
}
