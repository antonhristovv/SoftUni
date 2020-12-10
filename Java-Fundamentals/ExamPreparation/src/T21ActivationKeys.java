import java.util.Locale;
import java.util.Scanner;

public class T21ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder activationPassword = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!"Generate".equals(input)) {
            String[] tokens = input.split(">>>");
            String command = tokens[0];
            switch (command) {
                case "Contains":
                    String substring = tokens[1];
                    if (activationPassword.indexOf(substring) != -1) {
                        System.out.printf("%s contains %s%n", activationPassword, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String direction = tokens[1];
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    if ("Upper".equals(direction)) {
                        String toUpperCase = activationPassword.substring(startIndex, endIndex).toUpperCase();
                        activationPassword.replace(startIndex, endIndex, toUpperCase);
                    } else {
                        String toLowerCase = activationPassword.substring(startIndex, endIndex).toLowerCase();
                        activationPassword.replace(startIndex, endIndex, toLowerCase);
                    }
                    System.out.println(activationPassword);
                    break;
                case "Slice":
                    int fromIndex = Integer.parseInt(tokens[1]);
                    int toIndex = Integer.parseInt(tokens[2]);
                    activationPassword.replace(fromIndex, toIndex, "");
                    System.out.println(activationPassword);
                    break;
                default:
                    System.out.println("Unknown command: " + command);
            }
            input = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + activationPassword);
    }
}
