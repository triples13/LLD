package com.vendingmachine.repo;

import com.vendingmachine.model.Product;

import java.util.List;

public interface ProductRepo {

    public abstract double findPriceByProductId(String productId);
    public Product addProduct(Product product);
    public Product findProductByProductId(String productId);
    public void updateProductInventory(String productId);
}
