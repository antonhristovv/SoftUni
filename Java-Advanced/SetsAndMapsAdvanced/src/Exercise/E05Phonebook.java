package Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phoneBook = new HashMap<>();
        String input = scanner.nextLine();
        while (!"search".equals(input)) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String phone = tokens[1];
            phoneBook.put(name, phone);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!"stop".equals(input)) {
            if (phoneBook.containsKey(input)) {
                String phone = phoneBook.get(input);
                System.out.println(input + " -> " + phone);
            } else {
                System.out.println("Contact " + input + " does not exist.");
            }

            input = scanner.nextLine();
        }
    }
}
