import java.util.Scanner;

public class T31SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!"Reveal".equals(input)) {
            String[] tokens = input.split(":\\|:");
            String command = tokens[0];
            boolean containsString = true;
            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(tokens[1]);
                    message.insert(index, " ");
                    break;
                case "Reverse":
                    String substring = tokens[1];
                    StringBuilder reversed = new StringBuilder();
                    for (int i = substring.length() - 1; i >= 0; i--) {
                        reversed.append(substring.charAt(i));
                    }
                    if (message.indexOf(substring) != -1) {
                        int startIndex = message.indexOf(substring);
                        message.replace(startIndex, startIndex + substring.length(), "");
                        message.append(reversed);
                    } else {
                        System.out.println("error");
                        containsString = false;
                    }
                    break;
                case "ChangeAll":
                    substring = tokens[1];
                    String replacement = tokens[2];
                    while (message.indexOf(substring) != -1) {
                        int startIndex = message.indexOf(substring);
                        message.replace(startIndex, startIndex + substring.length(), replacement);
                    }
                    break;
                default:
                    System.out.println("Unknown command: " + command);
            }
            if (containsString) {
                System.out.println(message);
            }
            input = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + message);

    }
}
