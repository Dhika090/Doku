package com.example.Doku;

import com.example.Doku.entity.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class DokuApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private com.example.Doku.repository.productRepository productRepository;


	@Test
	public void testAddProduct() {
		Product product = new Product("Test Product", BigDecimal.valueOf(100), 10);
		Product savedProduct = productRepository.save(product);
		assertNotNull(savedProduct);
		assertEquals("Test Product", savedProduct.getName());
	}

	@Test
	public void testGetAllProduct(){
		Product product1 = new Product("Laptop", BigDecimal.valueOf(15000), 10);
		Product product2 = new Product("Phone", BigDecimal.valueOf(8000), 5);

		productRepository.save(product1);
		productRepository.save(product2);

		List<Product> products = productRepository.findAll();
		assertFalse(products.isEmpty());
	}

	@Test
	public void testDeleteProduct(){
		Integer id = 1;
		productRepository.deleteById(id);
		assertFalse(productRepository.existsById(id));
	}
}
