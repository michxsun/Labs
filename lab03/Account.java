/**
 * This class represents a bank account whose current balance is a nonnegative
 * amount in US dollars.
 */
public class Account {

    /**
     * Initialize an account with the given balance.
     */
    public Account(int balance) {
        this.myBalance = balance;
    }
    
    /*
     * New constructor for overdrafting Accounts.
     */
    public Account(int balance, Account parAccount) {
        this.myBalance = balance;
        this.parentAccount = parAccount;
    }
    
    /**
     * Add the given amount to the account.
     */
    public void deposit(int amount) {
        if (amount < 0) {
            System.out.println("Cannot deposit negative amount.");
        } else {
            this.myBalance = this.myBalance + amount;
        }
    }

    /**
     * Subtract the given amount from the account if possible. If the amount
     * would leave a negative balance, print an error message and leave the
     * balance unchanged.
     */
    public boolean withdraw(int amount) {
        if (amount < 0) {
            System.out.println("Cannot withdraw negative amount.");
            return false;
        } else if (this.myBalance < amount) {
            if (this.parentAccount != null) {
                int remainder = amount - this.myBalance;
                if (this.parentAccount.withdraw(remainder)) {
                    this.myBalance = 0;
                    return true;
                } else {
                    return false;
                }
            } else {
            System.out.println("Insufficient funds");
            return false;
            }
        } else {
            this.myBalance = this.myBalance - amount;
            return true;
        }
    }

    /**
     * Return the number of dollars in the account.
     */
    public int balance() {
        return this.myBalance;
    }
    
    /**
     * Merges two accounts by taking balance of argument account and adding it to our account.
     */
    public void merge (Account anotherAcct) {
        this.myBalance = this.myBalance + anotherAcct.myBalance;
        anotherAcct.myBalance = 0;
    }

    // instance variables
    private int myBalance;
    private Account parentAccount;

}
