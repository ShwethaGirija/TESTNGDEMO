package com.hyr.groups;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class FirstTest3 {
	
	@Test(groups= {"dailyBuild","smoke"})
	public void test1()
	{
		System.out.println("Class 3 >>> Test 1");
	}
	
	@Test(groups= {"Weekly build"})
	public void test2()
	{
		System.out.println("Class 3 >>> Test 2");
	}
	
	@Test(groups= {"smoke","regression"})
	public void test3()
	{
		System.out.println("Class 3 >>> Test 3");
	}
	
	@Test(groups= {"functional"})
	public void test4()
	{
		System.out.println("Class 3 >>> Test 4");
	}
	

}
