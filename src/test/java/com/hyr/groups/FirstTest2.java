package com.hyr.groups;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class FirstTest2 {
	
	@Test
	public void test1()
	{
		System.out.println("Class 3 >>> Test 1");
	}
	
	@Test(groups= {"sanity"})
	public void test2()
	{
		System.out.println("Class 3 >>> Test 2");
	}
	
	@Test(groups= {"functional,regression"})
	public void test3()
	{
		System.out.println("Class 3 >>> Test 3");
	}
	
	@Test(groups="sanity")
	public void test4()
	{
		System.out.println("Class 3 >>> Test 4");
	}
	

}
