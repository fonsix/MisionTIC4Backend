package com.fonsix.backend.services;

import com.fonsix.backend.documents.Product;
import com.fonsix.backend.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SequenceService sequenceService;

	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

	public Iterable<Product> findAvailableByNameLike(String name) {
		return productRepository.findAvailableByNameLike(name);
	}

	public Iterable<Product> findAvailableByCategory(String category) {
		return productRepository.findAvailableByCategory(category);
	}

	public Iterable<Product> findAvailableByPriceLessThanOrEqualTo(Float price) {
		return productRepository.findAvailableByPriceLessThanOrEqualTo(price);
	}

	public Iterable<String> findAllCategories() {
		return productRepository.findAllCategories();
	}

	public Product save(Product product) {
		if (product.getId() == null) {
			product.setId(sequenceService.next(Product.class.getSimpleName()));
		}
		return productRepository.save(product);
	}

	public void deleteById(Integer id) {
		productRepository.deleteById(id);
	}

}
