package shop.model;

import shop.discount.Discountable;

public class DigitalProduct extends Product implements Discountable {

    private String donwloadUrl;

    private static final int Digital_Discount_Percent = 10;
    
    public DigitalProduct(String sku, String name, long price, String donwloadUrl){
        super(sku, name, price);

        if (donwloadUrl.isEmpty()) {
            throw new IllegalArgumentException("Donwload Url Can't be Empty");
        }

        this.donwloadUrl = donwloadUrl;
    }

    public String getDonwloadUrl(){
        return donwloadUrl;
    }

    public String category() {
        return "Digital";
    }

    public int  discountPercent(){
        return Digital_Discount_Percent;
    }

    public long getFinalPrice(){
        return applyDiscount(super.getPrice());
    }


}
