import java.util.Scanner;

public class E04PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int sum = start;
        System.out.print(start);
        for (int i = start + 1; i <= end; i++) {
            System.out.print(" " + i);
            sum += i;
        }
        System.out.printf("%nSum: %d", sum);
    }
}
