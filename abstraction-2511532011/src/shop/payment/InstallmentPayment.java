package shop.payment;

public interface InstallmentPayment extends PaymentMethod{
    
    int maxInstallmentMonth();

    default long monthlyInstallment(long amount, int month){
        if ( month < 1 || month > maxInstallmentMonth() ){
            throw new IllegalArgumentException("Month must be between 1 and " + maxInstallmentMonth());
        }
        return ( amount + month - 1) / month;
    }
}
