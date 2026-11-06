package shop.shipping;

public class ExpressShipping extends ShippingService {
    public ExpressShipping() {
        super("Express");
    }

    protected long ratePerKg(){
        return 18_000;
    }
}
