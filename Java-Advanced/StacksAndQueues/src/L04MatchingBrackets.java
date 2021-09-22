import java.util.ArrayDeque;
import java.util.Scanner;

public class L04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String expression = scanner.nextLine();
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            if (currentChar == '(') {
                stack.push(i);
            } else if (currentChar == ')') {
                int startIndex = stack.pop();
                String subString = expression.substring(startIndex, i + 1);
                System.out.println(subString);
            }
        }
    }
}
