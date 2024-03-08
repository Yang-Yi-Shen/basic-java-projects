package banking_system;

public class Bank {
    private BankAccount[] accountList;

    Bank() {
        this.accountList = new BankAccount[0];
    }

    public BankAccount[] getAccountList() {
        return this.accountList;
    }

    public boolean newAccount(BankAccount account) {
        // check if PIN is being used
        for (int i = 0; i < accountList.length; i++) {
            if (account.getPIN() == accountList[i].getPIN()) {
                return false;
            }
        }

        // create new account
        BankAccount[] accountListCopy = new BankAccount[this.accountList.length + 1];
        accountListCopy[this.accountList.length] = account;

        this.accountList = accountListCopy;
        return true;
    }
}
