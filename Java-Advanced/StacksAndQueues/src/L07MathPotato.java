import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();
        List<String> circle = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        int toss = Integer.parseInt(scanner.nextLine());
        int removalIndex = toss - 1;
        int cycle = 1;
        while (circle.size() > 1) {
            while (removalIndex >= circle.size()) {
                removalIndex %= circle.size();
            }
            if (!isPrimeNumber(cycle) || (cycle == 1)) {
                queue.offer("Removed " + circle.get(removalIndex));
                circle.remove(removalIndex);
            } else {
                queue.offer("Prime " + circle.get(removalIndex));
            }
            cycle++;
            removalIndex += toss - 1;
        }
        queue.offer("Last is " + circle.get(0));
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    public static boolean isPrimeNumber(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
