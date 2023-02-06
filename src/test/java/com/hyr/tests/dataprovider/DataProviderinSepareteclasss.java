package com.hyr.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderinSepareteclasss {

	@Test(dataProvider = "logintestdata",dataProviderClass = dp.class)
	public void login(String name)
	{
		System.out.println("Hello ==>  "+name);
	}
	
	
}
