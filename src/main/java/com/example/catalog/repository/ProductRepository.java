package com.example.catalog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.catalog.models.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
     @Query(value="select * from products where category_id=?",nativeQuery = true)
	List<Products> findByProductCategoryWise(Long id);

	Optional<Products> findById(Long id);

	void deleteById(Long id);

	

}
