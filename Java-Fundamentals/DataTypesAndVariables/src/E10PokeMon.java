import java.util.Scanner;

public class E10PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingPower = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFacotr = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int power = startingPower;
        while (power >= distance) {
            power -= distance;
            count++;
            if (power == (int) (0.5 * startingPower) && exhaustionFacotr != 0) {
                power /= exhaustionFacotr;
            }
        }
        System.out.println(power);
        System.out.println(count);
    }
}
