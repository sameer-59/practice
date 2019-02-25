package com.cognizant.helper;

import com.cognizant.dao.AdminDAOImpl;
import com.cognizant.dao.AdminLoginDAO;

public class FactoryAdminLoginDAO {

	public static AdminLoginDAO createAdminDAO(){		// TODO Auto-generated method stub
		
		AdminLoginDAO admindao = new AdminDAOImpl();
		return admindao;
		
	
	}
}
