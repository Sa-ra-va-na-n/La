package com.ecom.product.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecom.product.model.Product;
import com.ecom.product.repository.ProductRepository;
import com.ecom.product.service.interfaces.ProductDetails;

@Service
public class ProductDetailServiceImpl implements ProductDetails {

	private ProductRepository productRepository;
	
	@Autowired
	private EntityManager em;
	
	@Override
	public List<Product> getAllLaptop() {
		return productRepository.findAll();
	}
	
	@Override
	public Product findProductByProductName(String productName) {
		Product result = null;
		
		String s = "select * from Vendor where V_NAME='"+productName+"';";
		try {
			result = (Product) em.createNativeQuery(s).getSingleResult();
		}
		catch(Exception e)
		{
			
		}
		return result;
	}
}
