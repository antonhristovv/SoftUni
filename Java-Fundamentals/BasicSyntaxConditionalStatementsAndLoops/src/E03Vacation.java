import java.util.Scanner;

public class E03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        String peopleType = scanner.nextLine();
        String dayType = scanner.nextLine();
        double singlePrice = 0.00;

        switch (peopleType) {
            case "Students":
                switch (dayType) {
                    case "Friday":
                        singlePrice = 8.45;
                        break;
                    case "Saturday":
                        singlePrice = 9.80;
                        break;
                    case "Sunday":
                        singlePrice = 10.46;
                        break;
                }
                if (peopleCount >= 30) {
                    singlePrice *= 0.85;
                }
                break;
            case "Business":
                if (peopleCount >= 100) {
                    peopleCount -= 10;
                }
                switch (dayType) {
                    case "Friday":
                        singlePrice = 10.90;
                        break;
                    case "Saturday":
                        singlePrice = 15.60;
                        break;
                    case "Sunday":
                        singlePrice = 16;
                        break;
                }
                break;
            case "Regular":
                switch (dayType) {
                    case "Friday":
                        singlePrice = 15;
                        break;
                    case "Saturday":
                        singlePrice = 20;
                        break;
                    case "Sunday":
                        singlePrice = 22.50;
                        break;
                }
                if (10 <= peopleCount && peopleCount <= 20) {
                    singlePrice *= 0.95;
                }
                break;

        }

        System.out.printf("Total price: %.2f", peopleCount * singlePrice);
    }
}
