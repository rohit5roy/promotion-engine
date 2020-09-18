package com.promotion.test;

import com.promotion.main.model.Order;
import com.promotion.main.model.Product;
import com.promotion.main.model.Promotion;
import com.promotion.main.service.PromotionVerifier;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TestPromotion {

    public static void main(String[] args) {

        //create list of promotions
        //we need to add information about Product's count
        HashMap<String, Integer> d1 = new HashMap<>();
        d1.put("A", 3);
        HashMap<String, Integer> d2 = new HashMap<>();
        d2.put("B", 2);
        HashMap<String, Integer> d3 = new HashMap<>();
        d3.put("C", 1);
        d3.put("D", 1);

        List<Promotion> promotions = Arrays.asList(
                new Promotion(1, d1, 150-130),
                new Promotion(2, d2, 60-45),
                new Promotion(3, d3, 30));


        Order order1 = new Order(1, Arrays.asList(new Product("A"), new Product("A"), new Product("B"), new Product("B"), new Product("C")));


        List<Integer> promoPrices = promotions.stream()
                .map(promotion -> PromotionVerifier.getTotalPrice(order1, promotion)).collect(Collectors.toList());
        int origPrice = order1.getProducts().stream().mapToInt(Product::getPrice).sum();
        int promoPrice = promoPrices.stream().mapToInt(Integer::intValue).sum();

        if(promoPrice == 15)
            System.out.println("Test Passed");
        else
            System.out.println("Test Failed");
    }
}
