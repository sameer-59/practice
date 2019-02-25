package com.cognizant.service;

import com.cognizant.dao.AdminDAOImpl;
import com.cognizant.dao.AdminLoginDAO;
import com.cognizant.entity.Admin;
import com.cognizant.helper.FactoryAdminLoginService;

public class AdminServiceImpl implements AdminService{

	@Override
	public boolean findAdmin(String uname, String pword) {
		// TODO Auto-generated method stub
		AdminDAOImpl ob = new AdminDAOImpl();
		//FactoryAdminLoginService ob = new FactoryAdminLoginService();
		boolean result=ob.findAdmin(uname,pword);
		return result;
	}

}
