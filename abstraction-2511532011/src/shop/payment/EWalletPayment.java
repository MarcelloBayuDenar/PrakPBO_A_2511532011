package shop.payment;

public class EWalletPayment implements RefundablePayment {

    private String provider;
    private long balance;

    public EWalletPayment(String provider, long balance){

        if (balance <= 0 || provider == null || provider.isBlank()) {
            throw new IllegalArgumentException("Balance must be greater than zero");
        }

        this.provider = provider;
        this.balance = balance;

    }

    public String getName(){
        return "E-Wallet" +  provider;
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

    public boolean refund(long amount){
        if (amount <= 0 ){
            return false;
        }

        this.balance += amount;
        return true;
    }


}
