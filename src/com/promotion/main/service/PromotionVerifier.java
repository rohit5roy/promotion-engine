package com.promotion.main.service;

import com.promotion.main.model.Product;
import com.promotion.main.model.Order;
import com.promotion.main.model.Promotion;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class PromotionVerifier {
    //returns PromotionID and count of promotions
    public static int getTotalPrice(Order ord, Promotion prom)
    {
        int d = 0;
        //get count of promoted products in order
        int cOpp = ord.getProducts().stream()
                .collect(groupingBy(Product:: getId))
                .entrySet().stream()
                .filter(grp -> prom.getProductInfoMap()
                        .entrySet().stream()
                        .anyMatch(promotionProduct -> grp.getKey().equals(promotionProduct.getKey()) && grp.getValue().size() >= promotionProduct.getValue()))
                .map(Map.Entry::getValue)
                .mapToInt(List::size)
                .sum();
        int ppc = prom.getProductInfoMap().values().stream().mapToInt(i -> i).sum();
        while(cOpp>= ppc)
        {
            d +=  prom.getPromoDiscount();
            cOpp -= ppc;
        }
        return d;
    }
}
