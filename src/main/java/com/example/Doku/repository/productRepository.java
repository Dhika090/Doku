package com.example.Doku.repository;

import com.example.Doku.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<Product, Integer> {
}
