package atm;

public class CheckingAccount extends Account {

    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String ownerName,
                           double openingBalance, double overdraftLimit) {

        // super(...) first

        // store overdraftLimit
    }

    @Override
    public String getAccountType() {
        // return "CHECKING"
    }

    @Override
    public void withdraw(double amount)
            throws InsufficientFundsException {

        // Reject amount <= 0

        // Calculate:
        // double remaining = getBalance() - amount;

        // If remaining < -overdraftLimit,
        // calculate the shortfall and throw the exception.

        // Otherwise:
        // applyWithdrawal(amount);
    }
}
