import java.util.Scanner;

public class E09PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double cash = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double sabreSinglePrice = Double.parseDouble(scanner.nextLine());
        double robeSinglePrice = Double.parseDouble(scanner.nextLine());
        double beltSinglePrice = Double.parseDouble(scanner.nextLine());

        double sabreCount = Math.ceil(students * 1.10);
        int beltCount = students;
        beltCount -= beltCount / 6;
        double totalPrice = students * robeSinglePrice + sabreCount * sabreSinglePrice + beltCount * beltSinglePrice;

        if (totalPrice <= cash) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", totalPrice - cash);
        }
    }
}
