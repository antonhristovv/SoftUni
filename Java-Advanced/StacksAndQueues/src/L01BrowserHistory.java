import java.util.ArrayDeque;
import java.util.Scanner;

public class L01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        String navigation = scanner.nextLine();

        while (!"Home".equals(navigation)) {
            String current = null;
            if ("back".equals(navigation)) {
                if (history.size() > 1) {
                    history.pop();
                    current = history.peek();
                } else {
                    current = "no previous URLs";
                }
            } else {
                history.push(navigation);
                current = navigation;
            }
            System.out.println(current);

            navigation = scanner.nextLine();
        }
    }
}
