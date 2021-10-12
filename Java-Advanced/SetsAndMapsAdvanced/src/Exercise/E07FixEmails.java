package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> namesWithEmails = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!"stop".equals(input)) {
            String email = scanner.nextLine();
            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                namesWithEmails.put(input, email);
            }
            input = scanner.nextLine();
        }
        namesWithEmails.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
