package com.promotion.service;

import com.promotion.model.Order;
import com.promotion.model.Product;
import com.promotion.model.Promotion;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class PromotionVerifier {
    //returns PromotionID and count of promotions
    public static int getTotalPrice(Order ord, Promotion prom)
    {
        int d = 0;
        //get count of promoted products in order
        int copp = ord.getProducts().stream()
                .collect(groupingBy(Product :: getId))
                .entrySet().stream()
                .filter(grp -> prom.getProductInfoMap()
                        .entrySet().stream()
                        .anyMatch(y -> grp.getKey().equals(y.getKey()) && grp.getValue().size() == y.getValue()))
                .map(Map.Entry::getValue)
                .mapToInt(List::size)
                .sum();
        int ppc = prom.getProductInfoMap().values().stream().mapToInt(i -> i).sum();
        while(copp>= ppc)
        {
            d +=  prom.getPromoPrice();
            copp -= ppc;
        }
        return d;
    }
}