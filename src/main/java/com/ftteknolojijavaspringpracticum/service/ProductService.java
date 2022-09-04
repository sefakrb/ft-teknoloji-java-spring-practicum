package com.ftteknolojijavaspringpracticum.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftteknolojijavaspringpracticum.jpa.model.Product;
import com.ftteknolojijavaspringpracticum.jpa.repository.ProductRepository;

@Component
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public @ResponseBody Product addProduct(Product product) {
        Product newProduct = new Product();
        newProduct.setProductName(product.getProductName());
        newProduct.setExpireDate(product.getExpireDate());
        newProduct.setPrice(product.getPrice());
        productRepository.save(newProduct);
        return newProduct;
    }

    public @ResponseBody List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public @ResponseBody List<Product> getExpiredProducts() {
        List<Product> allProducts = productRepository.findAll();
        List<Product> expiredProducts = new ArrayList<>();
        for (int index = 0; index < allProducts.size(); index++) {
            Date today = new Date();
            if (allProducts.get(index).getExpireDate().getTime() < today.getTime()) {
                expiredProducts.add(allProducts.get(index));
            }
        }
        return expiredProducts;
    }

    public @ResponseBody List<Product> getUnexpiredProducts() {
        List<Product> allProducts = productRepository.findAll();
        List<Product> unexpiredProducts = new ArrayList<>();
        for (int index = 0; index < allProducts.size(); index++) {
            Date today = new Date();
            if (allProducts.get(index).getExpireDate().getTime() >= today.getTime()) {
                unexpiredProducts.add(allProducts.get(index));
            }
        }
        return unexpiredProducts;
    }
}