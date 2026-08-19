package atm;

public class SavingsAccount extends Account {

    public static final double MAINTAINING_BALANCE = 500.0;

    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName,
                          double openingBalance, double interestRate) {

        // super(...) must be the first statement

        // store interestRate
    }

    @Override
    public String getAccountType() {
        // return "SAVINGS"
    }

    @Override
    public void withdraw(double amount)
            throws InsufficientFundsException {

        // First reject amount <= 0

        // Calculate:
        // double remaining = getBalance() - amount;

        // If remaining < MAINTAINING_BALANCE,
        // throw InsufficientFundsException using the shortfall.

        // Otherwise call:
        // super.withdraw(amount);
    }

    public double monthlyInterest() {
        // return getBalance() * interestRate / 12;
    }
}
