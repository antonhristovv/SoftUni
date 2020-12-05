import java.util.Scanner;

public class E02SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            sum += input.charAt(i) - 48;
        }
        System.out.println(sum);
    }
}
