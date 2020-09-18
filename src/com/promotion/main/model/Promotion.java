package com.promotion.main.model;

import java.util.HashMap;

public class Promotion {
    private int promotionId;
    private HashMap<String, Integer> productInfoMap;
    private int promoDiscount;

    public Promotion(int promId, HashMap<String, Integer> prodInfoMap, int promoDiscountAmount)
    {
        this.promotionId = promId;
        this.productInfoMap = prodInfoMap;
        this.promoDiscount = promoDiscountAmount;
    }

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public HashMap<String, Integer> getProductInfoMap() {
        return productInfoMap;
    }

    public void setProductInfoMap(HashMap<String, Integer> productInfoMap) {
        this.productInfoMap = productInfoMap;
    }

    public int getPromoDiscount() {
        return promoDiscount;
    }

    public void setPromoDiscount(int promoDiscount) {
        this.promoDiscount = promoDiscount;
    }
}
