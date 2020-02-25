package inheritance;

public class Driver {

    public static void main(String[] args) {
        ChequeingAccount acc1 = new ChequeingAccount("12421", 1_000, 1_000_000);
        acc1.getBalance();
        acc1.getAccountNumber();
        acc1.getLimit();
    }
}
