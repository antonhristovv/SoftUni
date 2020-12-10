import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

public class T32MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> mirrorWords = new ArrayList<>();
        //Map<String, String> mirrorWords = new LinkedHashMap<>();
        String regex = "([@#])(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);
        int validPairsCount = 0;
        while (matcher.find()) {
            validPairsCount++;
            String first = matcher.group("first");
            String second = matcher.group("second");
            StringBuilder reversedSecond = new StringBuilder(second);
            reversedSecond.reverse();
            second = reversedSecond.toString();
            if (first.equals(second)) {
                mirrorWords.add(String.format("%s <=> %s", matcher.group("first"), matcher.group("second")));
                //mirrorWords.put(matcher.group("first"), matcher.group("second"));
            }
        }
        if (validPairsCount > 0) {
            System.out.printf("%d word pairs found!%n", validPairsCount);
            if (!mirrorWords.isEmpty()) {
                System.out.println("The mirror words are:");
                for (int i = 0; i < mirrorWords.size(); i++) {
                    System.out.print(mirrorWords.get(i));
                    if (i != mirrorWords.size() -1 ) {
                        System.out.print(", ");
                    }
                }
                //System.out.print(Arrays.toString(new List[] {mirrorWords}).replaceAll("[\\[\\]]", ""));
                /*String output = mirrorWords.entrySet()
                        .stream()
                        .map(e -> e.getKey() + " <=> " + e.getValue())
                        .collect(joining(", "));
                System.out.println(output);*/
            }
        } else {
            System.out.println("No word pairs found!");
        }
        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        }
    }
}
