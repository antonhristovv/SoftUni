import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class T13HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer[]> heroes = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] hero = scanner.nextLine().split("\\s+");
            String heroName = hero[0];
            int hp = Integer.parseInt(hero[1]);
            int mp = Integer.parseInt(hero[2]);
            heroes.put(heroName, new Integer[]{hp, mp});
        }
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String heroName = tokens[1];
            int amount = Integer.parseInt(tokens[2]);
            switch (command) {
                case "CastSpell":
                    String spellName = tokens[3];
                    if (heroes.get(heroName)[1] - amount >= 0) {
                        heroes.get(heroName)[1] -= amount;
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, heroes.get(heroName)[1]);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    String attacker = tokens[3];
                    if (heroes.get(heroName)[0] - amount > 0) {
                        heroes.get(heroName)[0] -= amount;
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, amount, attacker, heroes.get(heroName)[0]);
                    } else {
                        heroes.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }
                    break;
                case "Recharge":
                    if (heroes.get(heroName)[1] + amount >= 200) {
                        amount = 200 - heroes.get(heroName)[1];
                    }
                    heroes.get(heroName)[1] += amount;
                    System.out.printf("%s recharged for %d MP!%n", heroName, amount);
                    break;
                case "Heal":
                    if (heroes.get(heroName)[0] + amount >= 100) {
                        amount = 100 - heroes.get(heroName)[0];
                    }
                    heroes.get(heroName)[0] += amount;
                    System.out.printf("%s healed for %d HP!%n", heroName, amount);
                    break;
                default:
                    System.out.println("Unknown command: " + command);
                    break;
            }
            input = scanner.nextLine();
        }
        heroes.entrySet().stream()
                .sorted((f, s) -> {
                    if (f.getValue()[0].equals(s.getValue()[0])) {
                        return f.getKey().compareTo(s.getKey());
                    } else {
                        return Integer.compare(s.getValue()[0], f.getValue()[0]);
                    }
                })
                .forEach(h -> {
                    System.out.println(h.getKey());
                    System.out.println("  HP: " + h.getValue()[0]);
                    System.out.println("  MP: " + h.getValue()[1]);
                });
    }
}
