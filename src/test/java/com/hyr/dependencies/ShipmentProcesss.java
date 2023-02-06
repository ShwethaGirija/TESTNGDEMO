package com.hyr.dependencies;

import org.testng.annotations.Test;

public class ShipmentProcesss {

	
	int tracknum;
	
	@Test(priority=1)
	public void createShipment()
	{
		
		int temp = 1/0;
		System.out.println("Shipment created");
		tracknum = 1;
	}
	
	@Test(priority=0,dependsOnMethods = {"createShipment"})
	public void trackshipment() throws Exception
	{
		if(tracknum==0)
			throw new Exception("Shipment is not created so we cant track");
		
		else
			System.out.println("Track shipment success");
	}
	
	@Test(priority=3,dependsOnMethods = {"createShipment","trackshipment"})
	public void cancelshipment() throws Exception
	{
		if(tracknum==0)
			throw new Exception("Shipment is not created so we cant cancel");
		
		else
			System.out.println("cancel shipment success");
	}
	
}
