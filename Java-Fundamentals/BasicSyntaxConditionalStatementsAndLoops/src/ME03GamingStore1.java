import java.util.Scanner;

public class ME03GamingStore1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        String game = scanner.nextLine();
        double totalSpent = 0.00;
        while(!"Game Time".equals(game)) {
            switch (game) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    if(currentBalance >= 39.99) {
                        System.out.println("Bought " + game);
                            currentBalance -= 39.99;
                        totalSpent += 39.99;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "CS: OG":
                    if(currentBalance >= 15.99) {
                        System.out.println("Bought " + game);
                        currentBalance -= 15.99;
                        totalSpent += 15.99;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "Zplinter Zell":
                    if(currentBalance >= 19.99) {
                        System.out.println("Bought " + game);
                        currentBalance -= 19.99;
                        totalSpent += 19.99;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "Honored 2":
                    if(currentBalance >= 59.99) {
                        System.out.println("Bought " + game);
                        currentBalance -= 59.99;
                        totalSpent += 59.99;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "RoverWatch":
                    if(currentBalance >= 29.99) {
                        System.out.println("Bought " + game);
                        currentBalance -= 29.99;
                        totalSpent += 29.99;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                default:
                    System.out.println("Not Found");
            }
            if(currentBalance == 0.00) {
                System.out.println("Out of money!");
                break;
            }
            game = scanner.nextLine();
        }
        if(currentBalance != 0.00) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, currentBalance);
        }
    }
}
