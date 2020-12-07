import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> destinations = new LinkedList<>();
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("([=/])([A-Z][A-za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            destinations.add(matcher.group(2));
        }
        System.out.println("Destinations: " + String.join(", ", destinations));
       int travelPoints = destinations.stream()
               .mapToInt(String::length)
               .sum();
        System.out.println("Travel Points: " + travelPoints);
    }
}
