package com.springapp.mvc.util.cart.compare;

import com.springapp.mvc.util.cart.Product;
import com.springapp.mvc.util.cart.shopping.ShoppingCartItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladislav on 20.04.2017.
 */
public class CompareCart {
    List<CompareCartItem> items;
    int numberOfItems = 0;

    public CompareCart() {
        items = new ArrayList<CompareCartItem>();
        numberOfItems = 0;
    }

    public synchronized void addItem(Product product) {
        boolean newItem = true;
        for (CompareCartItem scItem : items) {
            if (scItem.getProduct().getProductId().equals(product.getProductId()) &&
                    scItem.getProduct().getModel().equals(product.getModel())){
                newItem = false;
            }
        }
        if (newItem) {
            CompareCartItem scItem = new CompareCartItem(product);
            items.add(scItem);
            numberOfItems++;
        }
    }

    public synchronized List<CompareCartItem> getItems() {
        return items;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }
}
