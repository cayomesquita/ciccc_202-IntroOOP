package inheritance;

public class ChequeingAccount extends BankAccount {

    private long limit;

    public ChequeingAccount(String accountNumber, double balance, long limit) {
        super(accountNumber, balance);
        this.limit = limit;
    }

    public long getLimit() {
        return limit;
    }
}
