package com.hyr.tests.dataprovider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.testng.annotations.DataProvider;

public class ReturnTypeIterataorOfObjectArray {

	@org.testng.annotations.Test(dataProvider = "testdata")
	public void Test(String s[])
	{
		System.out.println("Hello "+s[0]);
		System.out.println("Daugther "+s[1]);
	
	}
	
	
	
	@DataProvider
	public Iterator<String[]> testdata()
	{
		Set<String[]> data = new HashSet<String[]>();
		data.add(new String[]{"Shwetha","ABC"});
		data.add(new String[]{"Latha","XYZ"});
		data.add(new String[]{"Pinky","LMN"});
		
		Iterator<String[]> itr = data.iterator();
		
		return itr;
	}
}
