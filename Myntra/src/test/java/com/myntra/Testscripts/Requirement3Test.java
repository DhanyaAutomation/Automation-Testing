package com.myntra.Testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myntra.Base.TestBase;
import com.myntra.Pages.Requirement3;

public class Requirement3Test {
	TestBase base= new TestBase();
	WebDriver driver=null;
	@BeforeMethod
	public void setUp() throws Exception {
		driver=base.driverInitialization();
		
	}
	@Test
	public void Requirement3() { 
		Requirement3 req3= new Requirement3(driver);
		req3.autoSearch();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
