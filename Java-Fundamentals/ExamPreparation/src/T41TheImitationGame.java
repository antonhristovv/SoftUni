import java.util.Scanner;

public class T41TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!"Decode".equals(input)) {
            String[] tokens = input.split("\\|");
            String command = tokens[0];
            switch (command) {
                case "Move":
                    int count = Integer.parseInt(tokens[1]);
                    for (int i = 0; i < count; i++) {
                        message.append(message.charAt(i));
                    }
                    message.replace(0, count, "");
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    message.insert(index, value);
                    break;
                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    String newMessage = message.toString().replace(substring, replacement);
                    message.replace(0, message.length(), "");
                    message.append(newMessage);
                    break;
                default:
                    System.out.println("Unknown command: " + command);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + message);
    }
}
