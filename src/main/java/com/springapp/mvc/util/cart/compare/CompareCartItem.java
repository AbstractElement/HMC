package com.springapp.mvc.util.cart.compare;

import com.springapp.mvc.util.cart.Product;

/**
 * Created by Vladislav on 20.04.2017.
 */
public class CompareCartItem {
    private Product product;

    public CompareCartItem(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
