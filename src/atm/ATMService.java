package atm;

public class ATMService {

    // OVERLOADING

    public void deposit(Account account, double amount) {
        // account.deposit(amount)
        // print successful deposit
    }

    public void deposit(Account account, double amount, String note) {
        // deposit the amount
        // print the amount
        // print the note
    }

    // VARARGS

    public double depositAll(Account account, double... amounts) {

        double total = 0;

        // for-each through amounts
        // deposit each amount
        // add each amount to total

        return total;
    }

    // PASS-BY-VALUE

    public void tryToReplace(Account account) {

        account = new SavingsAccount(
                "XX-000",
                "Ghost Account",
                0,
                0
        );

        System.out.println("Inside the method : " + account);

        /*
         * Explain here:
         * Java passes the reference by value.
         * Reassigning this local parameter does not
         * change the variable in main().
         */
    }

    public void addBonus(Account account, double bonus) {

        account.deposit(bonus);

        /*
         * Explain here:
         * The reference itself is passed by value,
         * but both references point to the same object.
         * Therefore changing the object's balance is visible
         * to the caller.
         */
    }

    public void transfer(Account from, Account to, double amount)
            throws InsufficientFundsException {

        // Withdraw first
        // Then deposit into the destination
    }
}
