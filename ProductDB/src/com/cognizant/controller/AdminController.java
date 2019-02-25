package com.cognizant.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.entity.Admin;
import com.cognizant.helper.FactoryAdminLoginService;
import com.cognizant.service.AdminService;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/doLogin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        System.out.println("constructor");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=request.getParameter("username");
		String pword=request.getParameter("password");
		PrintWriter out = response.getWriter();
		
		Admin admin = new Admin();
		admin.setUsername(uname);
		admin.setPassword(pword);
		System.out.println(uname);
		
		AdminService adminService = FactoryAdminLoginService.createAdminService();
		boolean adminExists=adminService.findAdmin(uname,pword);
		RequestDispatcher dispatcher=request.getRequestDispatcher("welcome_admin.jsp");
		if(adminExists){
			
			HttpSession session = request.getSession();
				session.setAttribute("username",uname);
				dispatcher.forward(request,response);
		}
		else{
				
			out.println("Failed");
		}
	}

}
