package com.fonsix.backend.controllers;

import com.fonsix.backend.documents.Product;
import com.fonsix.backend.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/products")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class ProductController 	{

	@Autowired
	private ProductService productService;

	@GetMapping
	public Iterable<Product> findAll() throws InterruptedException {
		return productService.findAll();
	}

	@GetMapping(path = "available/by-name/like/{name}")
	public Iterable<Product> findAvailableByNameLike(@PathVariable String name) {
		return productService.findAvailableByNameLike(name.replaceAll("[$(-+.\\/?\\[-^{-}]", "\\$0"));
	}

	@GetMapping(path = "available/by-category/{category}")
	public Iterable<Product> findAvailableByCategory(@PathVariable String category) {
		return productService.findAvailableByCategory(category);
	}

	@GetMapping(path = "available/by-price/less-than-or-equal-to/{price}")
	public Iterable<Product> findAvailableByPriceLessThanOrEqualTo(@PathVariable Float price) {
		return productService.findAvailableByPriceLessThanOrEqualTo(price);
	}

	@GetMapping(path = "categories")
	public Iterable<String> findAllCategories() {
		return productService.findAllCategories();
	}

	@PostMapping
	public Product save(@RequestBody Product product) {
		return productService.save(product);
	}

	@DeleteMapping(path = "{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Integer id) {
		productService.deleteById(id);
	}

}
