import java.util.Scanner;

public class E01IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstInteger = Integer.parseInt(scanner.nextLine());
        int secondInteger = Integer.parseInt(scanner.nextLine());
        int thirdInteger = Integer.parseInt(scanner.nextLine());
        int fourthInteger = Integer.parseInt(scanner.nextLine());

        System.out.println((firstInteger + secondInteger) / thirdInteger * fourthInteger);
    }
}
