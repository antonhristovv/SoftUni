import java.util.Scanner;

public class E06RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        memoryForFib = new long[n + 1];
        System.out.println(getFibonacci(n));
    }

    public static long[] memoryForFib;

    public static long getFibonacci(int n) {
        //bottom
        if (n <= 1) {
            return 1;
        }
        //memorization
        if (memoryForFib[n] != 0) {
            return memoryForFib[n];
        } else {
            memoryForFib[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
        }
        return getFibonacci(n - 1) + getFibonacci(n - 2);
        //alternative
        //return memoryForFib[n] = getFibonacci(n - 1) + getFibonacci([n - 2]);
    }
}
