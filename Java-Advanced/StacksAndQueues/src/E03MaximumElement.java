import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class E03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            switch (command) {
                case "1":
                    int value = Integer.parseInt(input[1]);
                    stack.push(value);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
}
