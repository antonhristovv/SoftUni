import java.util.Scanner;

public class ME02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            long first = scanner.nextLong();
            long second = scanner.nextLong();
            int sumOfDigits = 0;
            if (first > second) {
                first = Math.abs(first);
                while (first != 0) {
                    sumOfDigits += first % 10;
                    first /= 10;
                }
            } else {
                second = Math.abs(second);
                while (second != 0) {
                    sumOfDigits += second % 10;
                    second /= 10;
                }
            }
            System.out.println(sumOfDigits);
        }
        
    }
}
