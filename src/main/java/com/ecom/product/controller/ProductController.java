package com.ecom.product.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.ecom.product.exception.ResourceNotFoundException;
import com.ecom.product.model.Product;
import com.ecom.product.model.Vendor;
import com.ecom.product.repository.ProductRepository;
import com.ecom.product.repository.VendorRepository;



@RestController
@RequestMapping("/api/v1/")
public class ProductController {
	
	@Autowired
	private ProductRepository productrepository;
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productrepository.findAll();
	}
	
	//Create employee rest Api
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/products/{id}")
	public Product createProduct(@RequestBody Product product,@PathVariable long id) {
		Vendor vendor=vendorRepository.findById(id).get();
		product.setVendor(vendor);
		return productrepository.save(product);
	}	
	
	// get employee by id rest api
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/products/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable long productId) {
		Product product=productrepository.findById(productId).
				orElseThrow(()->new ResourceNotFoundException("Product not exist with id:"+productId));
		return ResponseEntity.ok(product);
	}
//	@GetMapping("/products/{modelname}")
//	public List<Product> findProduct(@PathVariable String modelname) {
//		return productrepository.findByName(modelname);
//	}
	
	// Update employee rest api
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/products/{productId}")
	public ResponseEntity<Product> updateEmployee(@PathVariable long productId,@RequestBody Product productDetails){
		Product product=productrepository.findById(productId).
				orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+productId));
		
		product.setModelname(productDetails.getModelname());
		product.setOs(productDetails.getOs());
		product.setRam(productDetails. getRam());
		product.setHarddrivesize(productDetails. getHarddrivesize());
		product.setStockavailable(productDetails.getStockavailable());
		
		Product updatedProduct=productrepository.save(product);
		return ResponseEntity.ok(updatedProduct);
	}
	
	// delete employee rest api
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<Map<String,Boolean>> deleteProduct(@PathVariable Long productId){
		Product product=productrepository.findById(productId).
				orElseThrow(()->new ResourceNotFoundException("Product not exist with id:"+productId));
		productrepository.delete(product);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}

