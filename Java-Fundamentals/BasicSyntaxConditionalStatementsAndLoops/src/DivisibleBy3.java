import java.util.Scanner;

public class DivisibleBy3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int current = 3; current <= 100; current+=3) {
            System.out.println(current);
        }
    }
}
