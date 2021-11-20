package Lab.L04FirstAndReserveTeam;

import Lab.Person;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("Black eagles");
        Person personOne = new Person("Ivan", "Ivanov", 45, 500);
        Person personTwo = new Person("Petar", "Petrov", 28, 600);
        team.addPlayer(personOne);
        team.addPlayer(personTwo);
        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");
    }
}
