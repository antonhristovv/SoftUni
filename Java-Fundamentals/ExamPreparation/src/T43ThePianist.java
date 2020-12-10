import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class T43ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Piece> pieces = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];
            pieces.put(piece, new Piece(piece, composer, key));
        }
        String input = scanner.nextLine();
        while (!"Stop".equals(input)) {
            String[] tokens = input.split("\\|");
            String command = tokens[0];
            String piece = tokens[1];
            switch (command) {
                case "Add":
                    if (pieces.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        String composer = tokens[2];
                        String key = tokens[3];
                        pieces.put(piece, new Piece(piece, composer, key));
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    }
                    break;
                case "Remove":
                    if (pieces.containsKey(piece)) {
                        pieces.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = tokens[2];
                    if (pieces.containsKey(piece)) {
                        pieces.get(piece).setKey(newKey);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                default:
                    System.out.println("Unknown command: " + command);
                    break;
            }
            input = scanner.nextLine();
        }
        pieces.entrySet().stream()
                .sorted(Comparator.comparing((Function<Map.Entry<String, Piece>, String>) Map.Entry::getKey).thenComparing(f -> f.getValue().getComposer()))
                .forEach(p -> System.out.printf("%s -> Composer: %s, Key: %s%n", p.getKey(), p.getValue().getComposer(), p.getValue().getKey()));
    }

    static class Piece {
        String piece;
        String composer;
        String key;

        public String getComposer() {
            return composer;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public Piece(String piece, String composer, String key) {
            this.piece = piece;
            this.composer = composer;
            this.key = key;
        }
    }
}
