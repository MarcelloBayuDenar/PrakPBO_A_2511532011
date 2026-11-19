package shop.testdouble;

import shop.exception.PaymentFailedException;
import shop.payment.PaymentMethod;

public class FakePaymentMethod implements PaymentMethod {

    private long lastAmount;
    private int callCount;

    public FakePaymentMethod(){}

    public long getLastAmount() {
        return lastAmount;
    }

    public int getCallCount() {
        return callCount;
    }

    public void pay(long amount) throws PaymentFailedException {
        lastAmount = amount;
        callCount++;
    }

    public String name() {
        return "Fake";
    }


}
