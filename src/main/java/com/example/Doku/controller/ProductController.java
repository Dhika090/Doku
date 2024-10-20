package com.example.Doku.controller;


import com.example.Doku.entity.Product;
import com.example.Doku.repository.productRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private productRepository productRepository;

    @PostMapping
    public Product tambahProduct(@RequestBody @Valid Product product){
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> ambilSemuaProduct(){
        return productRepository.findAll();
    }


    @GetMapping("/{id}")
    public Product ambilProductById(@PathVariable Integer id){
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("product tidak di temukan!"));
    }

    @PutMapping("/{id}")
    public Product UpdateProduct(@PathVariable Integer id, @RequestBody @Valid Product updateProdcut){
        return productRepository.findById(id).map(product ->{
            product.setName(updateProdcut.getName());
            product.setPrice(updateProdcut.getPrice());
            product.setQuantity(updateProdcut.getQuantity());
            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product tidak di temukan!"));
    }

    @DeleteMapping("/{id}")
    public void hapusProduct(@PathVariable Integer id){
        productRepository.deleteById(id);
    }
}
