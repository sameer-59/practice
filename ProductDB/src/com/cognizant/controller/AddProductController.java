package com.cognizant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.entity.Product;
import com.cognizant.helper.FactoryProductService;
import com.cognizant.service.ProductService;

/**
 * Servlet implementation class AddProductController
 */
@WebServlet("/addProduct")
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int productId=Integer.parseInt(request.getParameter("productId"));
		String productName=request.getParameter("productName");
		String productCategory=request.getParameter("productCategory");
		String productDescription=request.getParameter("productDescription");
		double productPrice=Double.parseDouble(request.getParameter("productPrice"));
		
		Product product=new Product();
		product.setProductId(productId);
		product.setProductName(productName);
		product.setProductCategory(productCategory);
		product.setProductDescription(productDescription);
		product.setProductPrice(productPrice);
		
		
		ProductService productService=FactoryProductService.createProductService();
		boolean productExists=productService.checkProduct(productId, productCategory);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("addProduct.jsp");
		if(!productExists){
			
			boolean productAdded=productService.addProduct(product);
			if(productAdded){
				request.setAttribute("status","Product Added Successfully");
				dispatcher.forward(request,response);
			}else{
				request.setAttribute("status","Product Add Failed");
				dispatcher.forward(request,response);

			}
		}
		
		else{
			
			request.setAttribute("status", "Product Id and Category already exists");
			dispatcher.forward(request,response);
		}
		
	}

}
