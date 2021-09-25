import java.util.ArrayDeque;
import java.util.Scanner;

public class E05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        String input = scanner.nextLine();
        boolean isBalanced = false;
        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);
            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                openBrackets.push(currentBracket);
            } else if ((!openBrackets.isEmpty()) && (currentBracket == ')' || currentBracket == '}' || currentBracket == ']')) {
                char lastOpenedBracket = openBrackets.pop();
                if (lastOpenedBracket == '(' && currentBracket == ')') {
                    isBalanced = true;
                } else if (lastOpenedBracket == '[' && currentBracket == ']') {
                    isBalanced = true;
                } else if (lastOpenedBracket == '{' && currentBracket == '}') {
                    isBalanced = true;
                } else {
                    isBalanced = false;
                    break;
                }
            } else {
                isBalanced = false;
                break;
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
