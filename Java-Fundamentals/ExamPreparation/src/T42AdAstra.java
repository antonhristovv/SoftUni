import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T42AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String foodRegex = "([#|])(?<item>[A-Za-z\\s]+)\\1(?<date>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d+)\\1";
        Pattern pattern = Pattern.compile(foodRegex);
        String input = scanner.nextLine();
        List<String> food = new ArrayList<>();
        int calories = 0;
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String item = matcher.group("item");
            String date = matcher.group("date");
            String itemCalories = matcher.group("calories");
            calories += Integer.parseInt(itemCalories);
            food.add(String.format("Item: %s, Best before: %s, Nutrition: %s", item, date, itemCalories));
        }
        System.out.printf("You have food to last you for: %d days!%n", calories / 2000);
        food.forEach(System.out::println);
    }
}
