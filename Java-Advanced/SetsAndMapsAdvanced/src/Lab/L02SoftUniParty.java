package Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class L02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> invitedGuests = new TreeSet<>();
        String input = scanner.nextLine();
        while (!"PARTY".equals(input)) {
            invitedGuests.add(input);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!"END".equals(input)) {
            invitedGuests.remove(input);
            input = scanner.nextLine();
        }
        System.out.println(invitedGuests.size());
        for (String invitedGuest : invitedGuests) {
            System.out.println(invitedGuest);
        }
    }
}
