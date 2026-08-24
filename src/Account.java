public class Account {

    // Private fields (Encapsulation)
    private String owner;
    private double balance;

    // Constructor
    public Account(String owner, double openingBalance) {
        this.owner = owner;

        // Accept only 0 or higher opening balance
        if (openingBalance >= 0) {
            this.balance = openingBalance;
        } else {
            this.balance = 0;
        }
    }

    // Getter for owner
    public String getOwner() {
        return owner;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        balance += amount;
        System.out.println("Deposited " + amount + ". New balance: " + balance);
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawn " + amount + ". New balance: " + balance);
    }
}
