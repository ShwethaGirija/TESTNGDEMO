package com.hyr.tests.dataprovider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

public class ReturnTypeIterataorOfObject {

	@org.testng.annotations.Test(dataProvider = "testdata")
	public void Test(String name)
	{
		System.out.println("Hello "+name);
	
	}
	
	
	
	@DataProvider
	public Iterator<String> testdata()
	{
		List<String> data = new ArrayList<String>();
		data.add("Shwetha");
		data.add("Latha");
		data.add("Pinky");
		
		Iterator<String> itr = data.iterator();
		
		return itr;
	}
}
