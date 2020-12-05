import java.util.Scanner;

public class E09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yield = Integer.parseInt(scanner.nextLine());
        int daysCount = 0;
        int totalYield = 0;
        while (yield >= 100) {
            daysCount++;
            totalYield += yield - 26;
            yield -= 10;
        }
        totalYield -= 26;
        if (totalYield < 0) {
            totalYield = 0;
        }
        System.out.println(daysCount);
        System.out.println(totalYield);
    }
}
