package inheritance;

public class ChequeingAccount extends BankAccount {

    private long limit;

    public ChequeingAccount(String accountNumber, double balance, int bankCode, long limit) {
        super(accountNumber, balance, bankCode);
        this.limit = limit;
    }

    public long getLimit() {
        return limit;
    }
}
