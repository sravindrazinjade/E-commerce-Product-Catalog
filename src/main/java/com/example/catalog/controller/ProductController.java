package com.example.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalog.models.Category;
import com.example.catalog.models.Products;
import com.example.catalog.service.ProductServices;

@RestController
@CrossOrigin("*")
@RequestMapping("product_catalog")
public class ProductController {

	@Autowired
	private ProductServices productServices;
	
	@PostMapping("/addCategory")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		Category cat=productServices.addCategory(category);
		return new ResponseEntity<Category>(cat,HttpStatus.CREATED) ;
		
	}
	
	@PostMapping("/addProduct/{id}")
	public ResponseEntity<Products> addProduct(@RequestBody Products p,@PathVariable ("id")Long id){
		Products pro=productServices.addProduct(p,id);
		return new ResponseEntity<Products>(pro,HttpStatus.CREATED) ;
		
		
	}
	@GetMapping("/getByCategoryProductList/{id}")
	public ResponseEntity<List<Products>> findCategoryWiseProductList(@PathVariable ("id")Long id){
		List<Products> prolist=productServices.findCategoryWiseProductList(id);
		return new ResponseEntity<List<Products>>(prolist,HttpStatus.OK);
		
	}
	
	@PutMapping("/updateProductDetails/{id}")
	public ResponseEntity<Products> updateProductDetails(@RequestBody Products p,@PathVariable("id")Long id)
	{
		Products product=productServices.updateProductDetails(p,id);
		return new ResponseEntity<Products>(product,HttpStatus.OK) ;
		
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProductById(@PathVariable("id") Long id) {
		Products product=productServices.deleteProductById(id);
		return "Product Deleted Successfully...";
		
	}
}
