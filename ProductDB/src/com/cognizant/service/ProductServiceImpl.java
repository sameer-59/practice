package com.cognizant.service;

import java.util.List;

import com.cognizant.dao.ProductDAO;
import com.cognizant.entity.Product;
import com.cognizant.helper.FactoryProductDAO;

public class ProductServiceImpl implements ProductService{
	
	ProductDAO productDAO=FactoryProductDAO.createProductDAO();

	@Override
	public boolean checkProduct(int productId, String productCategory) {
		// TODO Auto-generated method stub
		boolean result=productDAO.checkProduct(productId, productCategory);
		
		return result;
	}

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		boolean result=productDAO.addProduct(product);
		return result;
	}

	@Override
	public List<Product> viewProducts() {
		// TODO Auto-generated method stub
		List<Product> productList=productDAO.viewProducts();
		return productList;
	}

}
