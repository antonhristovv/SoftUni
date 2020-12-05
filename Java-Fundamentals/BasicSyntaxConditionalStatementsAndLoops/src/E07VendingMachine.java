import java.util.Scanner;

public class E07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sumMoney = 0.00;
        String input = scanner.nextLine();
        while (!"Start".equals(input)) {
            double currentCoin = Double.parseDouble(input);
            if (currentCoin == 0.1 || currentCoin == 0.2 || currentCoin == 0.5 || currentCoin == 1 || currentCoin == 2) {
                sumMoney += currentCoin;
            } else {
                System.out.printf("Cannot accept %.2f%n", currentCoin);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!"End".equals(input)) {
            switch (input) {
                case "Nuts":
                    if (sumMoney >= 2.0) {
                        System.out.println("Purchased Nuts");
                        sumMoney -= 2.0;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                        break;
                case "Water":
                    if (sumMoney >= 0.7) {
                        System.out.println("Purchased Water");
                        sumMoney -= 0.7;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if (sumMoney >= 1.5) {
                        System.out.println("Purchased Crisps");
                        sumMoney -= 1.5;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if (sumMoney >= 0.8) {
                        System.out.println("Purchased Soda");
                        sumMoney -= 0.8;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if (sumMoney >= 1.0) {
                        System.out.println("Purchased Coke");
                        sumMoney -= 1.0;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", sumMoney);
    }
}
