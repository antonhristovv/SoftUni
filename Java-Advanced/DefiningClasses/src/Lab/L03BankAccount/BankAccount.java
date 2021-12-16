package Lab.L03BankAccount;

public class BankAccount {
    private static int bankAccountCount = 1;
    private int id;
    private double balance;
    private static double interestRate = 0.02;

    BankAccount() {
        this.id = bankAccountCount++;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterestRate(int years) {
        return BankAccount.interestRate * years * this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return id;
    }
}
