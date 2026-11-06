package shop.payment;

public class BankTransferPayment implements PaymentMethod {

    private String bankName;
    private long balance;

    public BankTransferPayment(String bankName) {
        this.bankName = bankName;
    }

    public String getName(){
        return "Transfer" + bankName;
    }

    public long getBalance(){
        return balance;
    }

    public boolean pay(long amount){
        if (amount <= 0 || amount > balance){
            return false;
        }

        balance -= amount;
        return true;
    }
}
