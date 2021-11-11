package com.fonsix.backend.repositories;

import com.fonsix.backend.documents.Product;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

	@Query(value = "{ available: true, name: { $regex: '?0', $options: 'i' } }")
	public Iterable<Product> findAvailableByNameLike(String name);

	@Query(value = "{ available: true, category: '?0' }")
	public Iterable<Product> findAvailableByCategory(String category);

	@Query(value = "{ available: true, price: { $lte: ?0 } }")
	public Iterable<Product> findAvailableByPriceLessThanOrEqualTo(Float price);

	@Aggregation(pipeline = "{ $group : { _id : $category } }")
	public Iterable<String> findAllCategories();

}
