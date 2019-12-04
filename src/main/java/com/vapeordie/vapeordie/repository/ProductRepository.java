package com.vapeordie.vapeordie.repository;

import com.vapeordie.vapeordie.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query(value = "SELECT * FROM `product` WHERE id_category = ?", nativeQuery = true)
	List<Product> findByCategorie(Long idCategory);
}
