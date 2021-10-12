package Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class L03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerCards = new LinkedHashSet<>();
        Set<Integer> secondPlayerCards = new LinkedHashSet<>();
        for (int i = 0; i < 20; i++) {
            firstPlayerCards.add(scanner.nextInt());
        }
        for (int i = 0; i < 20; i++) {
            secondPlayerCards.add(scanner.nextInt());
        }
        int rounds = 0;
        while (rounds < 50 && !firstPlayerCards.isEmpty() && !secondPlayerCards.isEmpty()) {
            int firstNumber = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstNumber);
            int secondNumber = secondPlayerCards.iterator().next();
            secondPlayerCards.remove(secondNumber);
            if (firstNumber > secondNumber) {
                firstPlayerCards.add(firstNumber);
                firstPlayerCards.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondPlayerCards.add(firstNumber);
                secondPlayerCards.add(secondNumber);
            }
            rounds++;
        }
        if (firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerCards.size() > firstPlayerCards.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
