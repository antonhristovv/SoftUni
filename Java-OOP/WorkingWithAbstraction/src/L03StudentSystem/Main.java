package L03StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        String input = scanner.nextLine();
        while (!"Exit".equals(input)) {
            studentSystem.executeCommand(input);
            input = scanner.nextLine();
        }
    }
}
