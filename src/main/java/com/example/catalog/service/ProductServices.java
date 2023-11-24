package com.example.catalog.service;

import java.util.List;

import com.example.catalog.models.Category;
import com.example.catalog.models.Products;

public interface ProductServices {

	Products addProduct(Products p, Long id);

	Category addCategory(Category category);

	List<Products> findCategoryWiseProductList(Long id);

	Products updateProductDetails(Products p, Long id);

	Products deleteProductById(Long id);

}
