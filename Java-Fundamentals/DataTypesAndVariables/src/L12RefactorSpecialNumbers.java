import java.util.Scanner;

public class L12RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            int current = i;
            int sum = 0;
            while (current != 0) {
                sum += current % 10;
                current = current / 10;
            }
            boolean isSpecialNumber = (sum == 5) || (sum == 7) || (sum == 11);
            String specialNumber = "";
            if (isSpecialNumber) {
                specialNumber = "True";
            } else {
                specialNumber = "False";
            }
            System.out.printf("%d -> %s%n", i, specialNumber);
        }

    }
}
