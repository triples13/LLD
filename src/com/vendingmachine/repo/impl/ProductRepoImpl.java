package com.vendingmachine.repo.impl;

import com.vendingmachine.model.Product;
import com.vendingmachine.repo.ProductRepo;

import java.util.ArrayList;
import java.util.List;

public class ProductRepoImpl implements ProductRepo {

    List<Product> productList;

    public ProductRepoImpl(){
        productList = new ArrayList<>();
    }

    @Override
    public double findPriceByProductId(String productId) {
        return productList.stream().filter(e->e.getId().equals(productId)).findFirst().get().getPrice();
    }

    @Override
    public Product addProduct(Product product) {
        this.productList.add(product);
        return product;
    }

    @Override
    public Product findProductByProductId(String productId) {
        return this.productList.stream().filter(e->e.getId().equals(productId)).findFirst().get();
    }

    @Override
    public void updateProductInventory(String productId) {
        Product product = findProductByProductId(productId);
        this.productList.remove(product);
    }
}
