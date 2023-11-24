package com.example.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.catalog.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
