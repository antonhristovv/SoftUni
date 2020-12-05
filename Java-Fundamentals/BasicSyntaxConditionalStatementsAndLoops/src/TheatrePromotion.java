import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dayType = scanner.nextLine().toLowerCase();
        int age = Integer.parseInt(scanner.nextLine());
        int price = 0;

        if ("weekday".equals(dayType)) {
            if (((0 <= age) && (age <= 18)) || ((64 < age) && (age <= 122))) {
                price = 12;
            } else if (18 < age && age <= 64) {
                price = 18;
            }
        } else if ("weekend".equals(dayType)) {
            if (((0 <= age) && (age <= 18)) || ((64 < age) && (age <= 122))) {
                price = 15;
            } else if ((18 < age) && (age <= 64)) {
                price = 20;
            }
        } else if ("holiday".equals(dayType)) {
            if ((0 <= age) && (age <= 18)) {
                price = 5;
            } else if ((18 < age) && (age <= 64)) {
                price = 12;
            } else if ((64 < age) && (age <= 122)) {
                price = 10;
            }
        }
        if (price != 0) {
            System.out.println(price + "$");
        } else {
            System.out.println("Error!");
        }
    }
}
