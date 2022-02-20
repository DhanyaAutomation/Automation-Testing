package com.myntra.Testscripts;

import com.myntra.Pages.*;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myntra.Base.TestBase;

public class Requirement1Test {
	
	TestBase base= new TestBase();
	WebDriver driver=null;
	@BeforeMethod
	public void setUp() throws Exception {
		driver=base.driverInitialization();
		
	}
	@Test
	public void Requirement1() {
		Requirement1 req= new Requirement1(driver);
		/** For Men Validation */
		int size=req.menValidation();
		System.out.println(size);
		Assert.assertEquals(size>0, true);	
		/** For Women Validation */
		int womenListsize=req.menValidation();
		System.out.println(womenListsize);
		Assert.assertEquals(womenListsize>0, true);	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
