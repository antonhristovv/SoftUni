import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T22EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> coolEmojis = new ArrayList<>();
        Pattern coolnessPattern = Pattern.compile("([:]{2}[A-Z][a-z]{2,}[:]{2})|([*]{2}[A-Z][a-z]{2,}[*]{2})");
        Pattern digitsPattern = Pattern.compile("\\d");
        String input = scanner.nextLine();
        Matcher matcher = digitsPattern.matcher(input);
        int coolThreshold = 1;
        while (matcher.find()) {
            coolThreshold *= Integer.parseInt(matcher.group());
        }
        matcher = coolnessPattern.matcher(input);
        while (matcher.find()) {
            coolEmojis.add(matcher.group());
        }
        System.out.println("Cool threshold: " + coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", coolEmojis.size());
        for (String coolEmoji : coolEmojis) {
            int coolness = 0;
            for (int i = 2; i < coolEmoji.length() - 2; i++) {
                coolness += coolEmoji.charAt(i);
            }
            if (coolness >= coolThreshold) {
                System.out.println(coolEmoji);
            }
        }

    }
}
