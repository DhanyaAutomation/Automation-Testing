package com.myntra.Testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myntra.Base.TestBase;
import com.myntra.Pages.Requirement3;
import com.myntra.Pages.Requirement4;

public class Requirement4Test {
	TestBase base= new TestBase();
	WebDriver driver=null;
	@BeforeMethod
	public void setUp() throws Exception {
		driver=base.driverInitialization();
		
	}
	@Test
	public void Requirement4() { 
		Requirement4 req4= new Requirement4(driver);
		req4.login(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
