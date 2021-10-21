package Exercise;

import java.util.Scanner;

public class E08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int playerHitPoints = 18500;
        double heiganHitPoints = 3000000.0;
        int playerRow = 7;
        int playerCol = 7;
        String lastSpell = "";
        boolean activeCloud = false;
        double damageToHeigan = Double.parseDouble(scanner.nextLine());
        while (heiganHitPoints > 0 && playerHitPoints > 0) {
            heiganHitPoints -= damageToHeigan;
            if (activeCloud) {
                playerHitPoints -= 3500;
                activeCloud = false;
                if (playerHitPoints < 0) {
                    break;
                }
            }
            if (heiganHitPoints < 0) {
                break;
            }
            boolean[][] heiganChamber = new boolean[15][15];
            String[] tokens = scanner.nextLine().split("\\s+");
            String spell = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);
            for (int currentRow = row - 1; currentRow <= row + 1; currentRow++) {
                for (int currentCol = col - 1; currentCol <= col + 1; currentCol++) {
                    if (isInChamber(currentRow, currentCol, heiganChamber)) {
                        heiganChamber[currentRow][currentCol] = true;
                    }
                }
            }
            if (heiganChamber[playerRow][playerCol]) {
                //First, he tries to move up, if there’s damage/wall, he tries to move right, then down, then left.
                if (isInChamber(playerRow - 1, playerCol, heiganChamber) && !heiganChamber[playerRow - 1][playerCol]) {
                    playerRow--;
                } else if (isInChamber(playerRow, playerCol + 1, heiganChamber) && !heiganChamber[playerRow][playerCol + 1]) {
                    playerCol++;
                } else if (isInChamber(playerRow + 1, playerCol, heiganChamber) && !heiganChamber[playerRow + 1][playerCol]) {
                    playerRow++;
                } else if (isInChamber(playerRow, playerCol - 1, heiganChamber) && !heiganChamber[playerRow][playerCol - 1]) {
                    playerCol--;
                }
            }
            if (heiganChamber[playerRow][playerCol]) {
                if("Cloud".equals(spell)) {
                    playerHitPoints -= 3500;
                    activeCloud = true;
                    lastSpell = "Plague Cloud";
                } else {
                    playerHitPoints -= 6000;
                    lastSpell = spell;

                }
            }
        }
        if (heiganHitPoints > 0) {
            System.out.printf("Heigan: %.2f%n", heiganHitPoints);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerHitPoints > 0) {
            System.out.println("Player: " + playerHitPoints);
        } else {
            System.out.println("Player: Killed by " + lastSpell);
        }
        System.out.printf("Final position: %d, %d", playerRow, playerCol);
    }

    private static boolean isInChamber(int row, int col, boolean[][] heiganChamber) {
        return row >= 0 && row < heiganChamber.length && col >= 0 && col < heiganChamber[row].length;
    }
}
