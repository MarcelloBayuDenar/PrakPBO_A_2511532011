package shop.payment;

public class CreditCardPayment implements RefundablePayment, InstallmentPayment {

    private String holder;
    private long creditLimit;
    private long useCredit;

    public CreditCardPayment(String holder, long creditLimit){
        this.holder = holder;
        this.creditLimit = creditLimit;
    }

    public String getName(){
        return "Kartu Kredit (" + holder + ")";
    }

    public long getUsedCredit(){
        return useCredit;
    }

    public boolean pay(long amount){
        if (amount <= 0 || useCredit + amount > creditLimit){
            return false;
        }

        useCredit += amount;
        return true;
    }

    public boolean refund(long amount){
        if (amount <= 0 || amount > useCredit){
            return false;
        }
        useCredit -= amount;
        return true;
    }

    public int maxInstallmentMonth(){
        return 12;
    }


}
