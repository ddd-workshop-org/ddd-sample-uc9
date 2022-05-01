package com.ddd_bootcamp.domain.domain_service;

import com.ddd_bootcamp.domain.Cart;
import com.ddd_bootcamp.domain.Item;
import com.ddd_bootcamp.domain.Order;
import com.ddd_bootcamp.domain.Product;

import java.util.List;
import java.util.stream.Collectors;

public class CheckOutService {

    public static Order checkOut(Cart cart) {
        cart.checkOut1();
        List<Item> items = cart.getItems();
        List<Product> products = items.stream().flatMap(item ->
                item.getFlattenedProducts().stream()).collect(Collectors.toList());
        return new Order(products);
    }

}
