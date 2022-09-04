package com.ftteknolojijavaspringpracticum.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftteknolojijavaspringpracticum.dto.ProductDto;
import com.ftteknolojijavaspringpracticum.jpa.model.Product;
import com.ftteknolojijavaspringpracticum.service.ProductService;

@Controller
@RequestMapping
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/add-product")
    public @ResponseBody ProductDto addProduct(@RequestBody ProductDto productDto) {
        Product product = convertToEntity(productDto);
        Product productCreated = productService.addProduct(product);
        return convertToDto(productCreated);
    }

    @GetMapping(path = "/all-product")
    public @ResponseBody List<ProductDto> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/expired-product")
    public @ResponseBody List<ProductDto> getExpiredProducts() {
        List<Product> products = productService.getExpiredProducts();
        return products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/unexpired-product")
    public @ResponseBody List<ProductDto> getUnexpiredProducts() {
        List<Product> products = productService.getUnexpiredProducts();
        return products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ProductDto convertToDto(Product product) {

        ProductDto dto = new ProductDto();
        dto.setProductName(product.getProductName());
        dto.setExpireDate(product.getExpireDate());
        dto.setPrice(product.getPrice());

        return dto;
    }

    private Product convertToEntity(ProductDto productDto) {

        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setExpireDate(productDto.getExpireDate());
        product.setPrice(productDto.getPrice());

        return product;
    }
}