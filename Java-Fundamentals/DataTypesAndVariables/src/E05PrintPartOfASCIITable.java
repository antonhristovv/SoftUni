import java.util.Scanner;

public class E05PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startChar = Integer.parseInt(scanner.nextLine());
        int endChar = Integer.parseInt(scanner.nextLine());
        for (int i = startChar; i <= endChar; i++) {
            //char current = (char) i;
            System.out.printf("%c ", (char) i);
        }
    }
}
