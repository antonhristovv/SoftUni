import java.util.ArrayDeque;
import java.util.Scanner;

public class L08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forwardPages = new ArrayDeque<>();
        String navigation = scanner.nextLine();

        while (!"Home".equals(navigation)) {
            String current = null;
            if ("back".equals(navigation)) {
                if (history.size() > 1) {
                    forwardPages.addFirst(history.pop());
                    current = history.peek();
                } else {
                    current = "no previous URLs";
                }
            } else if ("forward".equals(navigation)) {
                if (forwardPages.size() >= 1) {
                    current = forwardPages.poll();
                } else {
                    current = "no next URLs";
                }
            } else {
                history.push(navigation);
                current = navigation;
                forwardPages.clear();
            }
            System.out.println(current);

            navigation = scanner.nextLine();
        }
    }
}
