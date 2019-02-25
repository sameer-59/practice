package com.cognizant.dao;

import java.util.List;

import com.cognizant.entity.Product;

public interface ProductDAO {
	
	boolean checkProduct(int productId,String productCategory);
	boolean addProduct(Product product);
	List<Product> viewProducts();

}
