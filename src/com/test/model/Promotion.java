package com.test.model;

import java.util.HashMap;

public class Promotion {
    private int promotionId;
    private HashMap<String, Integer> productInfoMap;
    private int promoPrice;

    public Promotion(int promId, HashMap<String, Integer> prodInfoMap, int pprice)
    {
        this.promotionId = promId;
        this.productInfoMap = prodInfoMap;
        this.promoPrice = pprice;
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

    public int getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(int promoPrice) {
        this.promoPrice = promoPrice;
    }
}
