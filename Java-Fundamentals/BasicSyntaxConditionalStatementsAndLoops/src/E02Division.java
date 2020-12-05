import java.util.Scanner;

public class E02Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int input = Integer.parseInt(scanner.nextLine());
        int division = 0;
        if (input % 10 == 0) {
            division = 10;
        } else if (input % 7 == 0) {
            division = 7;
        } else if (input % 6 == 0) {
            division = 6;
        } else if (input % 3 == 0) {
            division = 3;
        } else if (input % 2 == 0) {
            division = 2;
        }

        if (division != 0) {
            System.out.printf("The number is divisible by %d", division);
        } else {
            System.out.println("Not divisible");
        }

    }
}
