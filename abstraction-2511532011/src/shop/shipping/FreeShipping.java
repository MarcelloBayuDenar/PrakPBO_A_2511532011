package shop.shipping;

public class FreeShipping extends ShippingService {

    public FreeShipping() {
        super("Free");
    }
    
    protected long ratePerKg() {
        return 0;
    }

    public long calculateCost(int weightGrams) {
        return 0;
    }
}
