import java.util.Scanner;

public class E08BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kegCount = Integer.parseInt(scanner.nextLine());
        double biggestVolume = Double.MIN_VALUE;
        String biggestKegModel = "";
        for (int i = 0; i < kegCount; i++) {
            String kegModel = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            double height = Double.parseDouble(scanner.nextLine());
            double currentVolume = Math.PI * Math.pow(radius, 2) * height;
            if (currentVolume > biggestVolume) {
                biggestVolume = currentVolume;
                biggestKegModel = kegModel;
            }
        }
        System.out.println(biggestKegModel);
    }
}
