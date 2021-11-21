package E01ClassBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //length, width and height
        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        try {
            Box box = new Box(length,width, height);
            System.out.printf("Surface Area - %.2f", box.calculateSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f", box.calculateLateralSurfaceArea());
            System.out.printf("Volume – %.2f", box.calculateVolume());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
