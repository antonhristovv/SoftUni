package Exercise;

import java.util.*;

public class E08HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> playersCards = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!"JOKER".equals(input)) {
            String[] tokens = input.split(": ");
            String name = tokens[0];
            String[] cards = tokens[1].split(", ");
            playersCards.putIfAbsent(name, new HashSet<>());
            playersCards.get(name).addAll(Arrays.asList(cards));

            input = scanner.nextLine();
        }
        playersCards.entrySet().forEach(entry -> {
            String name = entry.getKey();
            int points = getCardsPoints(entry.getValue());
            System.out.println(name + ": " + points);
        });
    }

    private static int getCardsPoints(Set<String> cards) {
        int sum = 0;
        Map<Character, Integer> cardValues = getPartOfCardValue();
        for(String card: cards) {
            if (card.contains("10")) {
                char type = card.charAt(2);
                sum += 10 * cardValues.get(type);
            } else {
                char value = card.charAt(0);
                char type = card.charAt(1);
                sum += cardValues.get(value) * cardValues.get(type);
            }
        }
        return sum;
    }

    private static Map<Character, Integer> getPartOfCardValue () {
        Map<Character, Integer> cardParts = new HashMap<>();
        cardParts.put('2', 2);
        cardParts.put('3', 3);
        cardParts.put('4', 4);
        cardParts.put('5', 5);
        cardParts.put('6', 6);
        cardParts.put('7', 7);
        cardParts.put('8', 8);
        cardParts.put('9', 9);
        cardParts.put('J', 11);
        cardParts.put('Q', 12);
        cardParts.put('K', 13);
        cardParts.put('A', 14);
        cardParts.put('S', 4);
        cardParts.put('H', 3);
        cardParts.put('D', 2);
        cardParts.put('C', 1);


        return cardParts;
    }
}
