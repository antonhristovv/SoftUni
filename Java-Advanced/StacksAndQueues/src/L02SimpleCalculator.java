import java.util.ArrayDeque;
import java.util.Scanner;

public class L02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] expression = scanner.nextLine().split("\\s+");
        for (int i = expression.length - 1; i >= 0; i--) {
            stack.push(expression[i]);
        }
        while (stack.size() > 1) {
            int left = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int right = Integer.parseInt(stack.pop());
            if ("+".equals(operator)) {
                left += right;
            } else {
                left -= right;
            }
            stack.push(String.valueOf(left));
        }
        System.out.println(stack.peek());
    }
}
