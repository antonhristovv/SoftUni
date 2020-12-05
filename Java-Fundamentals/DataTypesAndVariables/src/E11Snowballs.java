import java.util.Scanner;

public class E11Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        int bestSnowballSnow = 0;
        int bestSnowballTime = 0;
        int bestSnowballQuality = 0;
        double bestSnowballValue = 0;
        while (count > 0) {
            int currentSnowballSnow = Integer.parseInt(scanner.nextLine());
            int currentSnowballTime = Integer.parseInt(scanner.nextLine());
            int currentSnowballQuality = Integer.parseInt(scanner.nextLine());
            int current = currentSnowballSnow / currentSnowballTime;
            double currentSnowballValue = Math.pow(current, currentSnowballQuality);
            if (currentSnowballValue > bestSnowballValue) {
                bestSnowballQuality = currentSnowballQuality;
                bestSnowballSnow = currentSnowballSnow;
                bestSnowballTime = currentSnowballTime;
                bestSnowballValue = currentSnowballValue;
            }
            count--;
        }
        System.out.printf("%d : %d = %.0f (%d)", bestSnowballSnow, bestSnowballTime, bestSnowballValue, bestSnowballQuality);
    }
}
