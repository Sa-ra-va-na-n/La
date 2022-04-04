package com.ecom.product.service.interfaces;

import java.util.List;
import com.ecom.product.model.Product;

public interface ProductDetails {
	public List<Product> getAllLaptop();
	Product findProductByProductName(String productName);
}
