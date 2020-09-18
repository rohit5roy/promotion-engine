package com.promotion;

import com.promotion.model.Order;
import com.promotion.model.Product;
import com.promotion.model.Promotion;
import com.promotion.service.PromotionVerifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

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
                new Promotion(1, d1, 130),
                new Promotion(2, d2, 45),
                new Promotion(3, d3, 30));

        //create orders
        Order order1 = new Order(1, Arrays.asList(new Product("A"), new Product("A"), new Product("B"), new Product("B"), new Product("C")));
        Order order2 = new Order(2, Arrays.asList( new Product("A"), new Product("A"), new Product("A"), new Product("A"), new Product("A")
                , new Product("B"), new Product("B"), new Product("B"), new Product("B"), new Product("B"), new Product("C")));
        Order order3 = new Order(3, Arrays.asList( new Product("A"), new Product("A"), new Product("D"), new Product("B"), new Product("B")));
        List<Order> orders = new ArrayList<>(Arrays.asList( order1, order2, order3));
        //check if order meets promotion
        for(Order ord : orders)
        {
            List<Integer> promoPrices = promotions.stream()
                    .map(promotion -> PromotionVerifier.getTotalPrice(ord, promotion)).collect(Collectors.toList());
            int origPrice = ord.getProducts().stream().mapToInt(Product::getPrice).sum();
            int promoPrice = promoPrices.stream().mapToInt(Integer::intValue).sum();
            System.out.println("OrderID: " + ord.getOrderId() + " => Original price: "+ origPrice+ " | Rebate: "+ promoPrice+ " | Final price: "+(origPrice - promoPrice));
        }
    }
}
