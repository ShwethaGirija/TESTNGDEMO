package com.hyr.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReturnType2DArray {

	@Test(dataProvider="testdata")
	public void test(String name , int age)
	{
		System.out.println("Hello "+name+ " Age "+age);
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
