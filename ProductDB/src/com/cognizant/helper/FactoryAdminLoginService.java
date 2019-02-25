package com.cognizant.helper;

import com.cognizant.service.AdminService;
import com.cognizant.service.AdminServiceImpl;

public class FactoryAdminLoginService {

	public static AdminService createAdminService()
	{
		AdminService adminService=new AdminServiceImpl();
		return adminService;
	}
}
