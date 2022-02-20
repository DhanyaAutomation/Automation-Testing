package com.myntra.Testscripts;

import org.openqa.selenium.WebDriver;
import com.myntra.Pages.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myntra.Base.TestBase;

public class Requirement2Test {
	TestBase base= new TestBase();
	WebDriver driver=null;
	@BeforeMethod
	public void setUp() throws Exception {
		driver=base.driverInitialization();
		
	}
	@Test
	public void Requirement2() {
		Requirement2 req2= new Requirement2(driver);
		req2.popularSearch();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
