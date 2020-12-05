import java.util.Scanner;

public class ME05Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        while (count > 0) {
            String current = scanner.nextLine();
            int numberOfDigits = current.length();
            int mainDigit = Integer.parseInt(current);
            mainDigit %= 10;
            int offset;
            if (mainDigit == 8 || mainDigit == 9) {
                offset = (mainDigit - 2) * 3 + 1;
            } else if( mainDigit == 0) { // space
                offset = -65;
            } else {
                offset = (mainDigit - 2) * 3;
            }
            int letterIndex = (offset + numberOfDigits - 1) + 97;
            char letter = (char) letterIndex;
            System.out.print(letter);
            count--;
        }
    }
}
