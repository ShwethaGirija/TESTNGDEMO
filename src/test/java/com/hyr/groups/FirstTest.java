package com.hyr.groups;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

@Test(groups= {"All"})
public class FirstTest {
	
	@Test(groups= {"smoke","functional"})
	public void test1()
	{
		System.out.println("Class 1 >>> Test 1");
	}
	
	@Test(groups = {"regression","functional"})
	public void test2()
	{
		System.out.println("Class 1 >>> Test 2");
	}
	
	@Test(groups = {"sanity"})
	public void test3()
	{
		System.out.println("Class 1 >>> Test 3");
	}
	
	@Test
	public void test4()
	{
		System.out.println("Class 1 >>> Test 4");
	}
	

}
