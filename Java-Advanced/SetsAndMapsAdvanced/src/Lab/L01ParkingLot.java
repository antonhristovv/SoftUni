package Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class L01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingLot = new LinkedHashSet<>();
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split(", ");
            String command = tokens[0];
            String carNumber = tokens[1];
            if ("IN".equals(command)) {
                parkingLot.add(carNumber);
            } else {
                parkingLot.remove(carNumber);
            }
            input = scanner.nextLine();
        }
        if (parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else {
            for (String carNumber : parkingLot) {
                System.out.println(carNumber);
            }
        }
    }
}
