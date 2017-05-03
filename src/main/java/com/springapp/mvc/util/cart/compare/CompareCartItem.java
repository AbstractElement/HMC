package com.springapp.mvc.util.cart.compare;

import com.springapp.mvc.util.cart.Product;

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
