package com.hyr.tests.dataprovider;

import org.testng.annotations.DataProvider;

public class dp {

	@DataProvider(name="logintestdata",indices= {1,3})
	public Object[] TestData()
	{
		String[] data = new String []
				{"A","B","C","D","E"};
		
		return data;
		
	}
	
}
