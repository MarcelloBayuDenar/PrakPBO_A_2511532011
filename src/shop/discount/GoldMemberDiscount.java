package shop.discount;

public class GoldMemberDiscount implements DiscountStrategy {

    private final int goldPercent;

    public GoldMemberDiscount(int goldPercent) {
        this.goldPercent = goldPercent;
    }

    public long discountFor(long subtotal) {
        return subtotal * goldPercent / 100;
    }

}
