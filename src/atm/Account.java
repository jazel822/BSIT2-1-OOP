package atm;

public abstract class Account {

    private String accountNumber;
    private String ownerName;
    private double balance;

    public Account(String accountNumber, String ownerName, double openingBalance) {
        // Validate accountNumber
        // Validate ownerName
        // Validate openingBalance

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = openingBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        // Reject amount <= 0
        // Add amount to balance
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        // Reject amount <= 0
        // If amount > balance, throw InsufficientFundsException
        // Otherwise subtract amount
    }

    public abstract String getAccountType();

    protected void applyWithdrawal(double amount) {
        // subtract amount from balance
    }

    @Override
    public String toString() {
        return getAccountType() + " " + accountNumber
                + " (" + ownerName + ")";
    }
}