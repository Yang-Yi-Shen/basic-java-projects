package banking_system;

public class BankAccount {
    private boolean signedin;
    private int PIN;
    private long balance;

    BankAccount(int PIN) {
        this.signedin = false;
        this.PIN = PIN;
        this.balance = 0;
    }

    public boolean getSignedIn() {
        return this.signedin;
    }

    public int getPIN() {
        return this.PIN;
    }

    public long getBalance() {
        return this.balance;
    }

    public boolean login(int PIN) {
        if (this.PIN == PIN) {
            this.signedin = true;
            return true;
        } else {
            return false;
        }
    }

    public void logout() {
        this.signedin = false;
    }

    public void deposit(long amount) {
        this.balance += amount;
    }

    public void withdraw(long amount) {
        this.balance -= amount;
    }
}