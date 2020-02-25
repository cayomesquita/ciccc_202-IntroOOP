package inheritance;

public class BankAccount {

    private String accountNumber;
    private double balance;
    protected int bankCode;

    public BankAccount() {
        this.accountNumber = "";
        this.balance = 0;
        this.bankCode = 0;
    }

    public BankAccount(String accountNumber, double balance, int bankCode) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bankCode = bankCode;
    }

    public BankAccount(String accountNumber, int bankCode) {
        this.accountNumber = accountNumber;
        this.bankCode = bankCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void transfer(BankAccount other, double amount) {
        this.balance -= amount;
        other.balance += amount;
    }

    @Override
    public String toString() {
        return "BankAccount[" +
                "accountNumber='" + accountNumber + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        BankAccount other = (BankAccount) obj;
        return this.accountNumber.equalsIgnoreCase(other.getAccountNumber());
    }
}
