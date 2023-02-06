package com.hyr.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReturnType2DArraywith1DParaminTestMethod {

	@Test(dataProvider="testdata")
	public void test(Object[] s)
	{
		System.out.println("Hello "+s[0]+ " Age "+s[1]);
	}

	
	@DataProvider
	public Object[][] testdata()
	{
		Object[][] data = new Object[][]
				{
					{"Shwetha",27},
					{"Latha",25},
					{"Sweety",10}
				};
				
				return data;
	}
}
