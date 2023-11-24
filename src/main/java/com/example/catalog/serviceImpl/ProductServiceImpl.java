package com.example.catalog.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.catalog.models.Category;
import com.example.catalog.models.Products;
import com.example.catalog.repository.CategoryRepository;
import com.example.catalog.repository.ProductRepository;
import com.example.catalog.service.ProductServices;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductServices {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
    private CategoryRepository categoryRepository;
	

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}


	@Override
	public Products addProduct(Products product, Long id) {
		// TODO Auto-generated method stub
		Category category=categoryRepository.getById(id);
		Products ObjProduct=new Products();
		ObjProduct.setCategory(category);
		ObjProduct.setProductName(product.getProductName());
		ObjProduct.setProductPrice(product.getProductPrice());
		ObjProduct.setQty(product.getQty());
		return productRepository.save(ObjProduct);
	}


	@Override
	public List<Products> findCategoryWiseProductList(Long id) {
		List<Products>  prodlist=productRepository.findByProductCategoryWise(id);
		return prodlist;
	}


	@Override
	public Products updateProductDetails(Products p,Long id) {
		Optional<Products> product= productRepository.findById(id);
		return productRepository.save(p);
	}



	@Transactional
	public Products deleteProductById(Long id) {
		// TODO Auto-generated method stub
		 productRepository.deleteById(id);
		return null;
	}
}
