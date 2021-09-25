import java.util.ArrayDeque;
import java.util.Scanner;

public class E01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] input = scanner.nextLine().split("\\s+");
        for (String current : input) {
            stack.push(Integer.parseInt(current));
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
