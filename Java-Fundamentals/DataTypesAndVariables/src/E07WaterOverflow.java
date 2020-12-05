import java.util.Scanner;

public class E07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int capacity = 255;
        int pouredLiters = 0;
        for (int i = 0; i < n; i++) {
            int litersToPour = Integer.parseInt(scanner.nextLine());
            if (litersToPour <= capacity - pouredLiters) {
                pouredLiters += litersToPour;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(pouredLiters);
    }
}
