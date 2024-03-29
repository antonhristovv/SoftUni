package E05FootballTeamGenerator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Team> teams = new HashMap();

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            String teamName = tokens[1];
            try {
                switch (command) {
                    case "Team":
                        Team team = new Team(teamName);
                        teams.putIfAbsent(teamName, team);
                        break;
                    case "Add":
                        String playerName = tokens[2];
                        int endurance = Integer.parseInt(tokens[3]);
                        int sprint = Integer.parseInt(tokens[4]);
                        int dribble = Integer.parseInt(tokens[5]);
                        int passing = Integer.parseInt(tokens[6]);
                        int shooting = Integer.parseInt(tokens[7]);
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                            break;
                        }
                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            teams.get(teamName).addPlayer(player);
                        break;
                    case "Remove":
                        playerName = tokens[2];
                        teams.get(teamName).removePlayer(playerName);
                        break;
                    case "Rating":
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                            break;
                        }
                        double rating = teams.get(teamName).getRating();
                        System.out.printf("%s - %.0f%n", teamName, rating);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }
    }
}
