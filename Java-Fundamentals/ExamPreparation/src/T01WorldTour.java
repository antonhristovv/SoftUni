import java.util.Scanner;

public class T01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();
        String input = scanner.nextLine();
        while (!"Travel".equals(input)) {
            String[] tokens = input.split(":");
            switch (tokens[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    if (0 <= index && index < stops.length()) {
                        String string = tokens[2];
                        stops = stops.substring(0, index) + string + stops.substring(index);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (0 <= startIndex && startIndex <= endIndex && endIndex < stops.length()) {
                        stops = stops.substring(0, startIndex) + stops.substring(endIndex + 1);
                    }
                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    if (stops.contains(oldString)) {
                        stops = stops.replace(oldString, newString);
                    }
                    break;
                default:
                    System.out.println("Unknown command" + tokens[0]);
                    break;
            }
            System.out.println(stops);
            input = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + stops);
    }
}
