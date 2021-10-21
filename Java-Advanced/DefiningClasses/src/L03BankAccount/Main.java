package L03BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Integer, BankAccount> bankAccounts = new HashMap<>();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bankAccounts.put(bankAccount.getId(), bankAccount);
                    System.out.printf("Account ID%d created%n", bankAccount.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    if (bankAccounts.containsKey(id)) {
                        double amount = Double.parseDouble(tokens[2]);
                        bankAccounts.get(id).deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    if (bankAccounts.containsKey(id)) {
                        System.out.printf("%.2f%n",bankAccounts.get(id).getInterestRate(years));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
