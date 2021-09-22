import java.util.ArrayDeque;
import java.util.Scanner;

public class L03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> binary = new ArrayDeque<>();
        int decimal = Integer.parseInt(scanner.nextLine());
        while (decimal > 0) {
            binary.push(decimal % 2);
            decimal /= 2;
        }
        if (binary.isEmpty()) {
            System.out.print(0);
        }
        while (!binary.isEmpty()) {
            System.out.print(binary.pop());
        }
        System.out.println();
    }
}
