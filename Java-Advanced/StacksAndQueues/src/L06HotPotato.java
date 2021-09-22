import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();
        List<String> circle = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        int toss = Integer.parseInt(scanner.nextLine());
        int removalIndex = toss - 1;
        while (circle.size() > 1) {
            while (removalIndex >= circle.size()) {
                removalIndex %= circle.size();
            }
            queue.offer("Removed " + circle.get(removalIndex));
            circle.remove(removalIndex);
            removalIndex += toss - 1;
        }
        queue.offer("Last is " + circle.get(0));
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
