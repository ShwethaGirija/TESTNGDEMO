package com.hyr.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReturnType1DArray {

	@Test(dataProvider = "logintestdata")
	public void login(String name)
	{
		System.out.println("Hello ==>  "+name);
	}
	
	@DataProvider(name="logintestdata",indices= {1,3})
	public Object[] TestData()
	{
		String[] data = new String []
				{"A","B","C","D","E"};
		
		return data;
		
	}
}
