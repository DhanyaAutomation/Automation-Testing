package com.myntra.Pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.myntra.Base.TestBase;

public class Requirement4 extends TestBase {
	private static final Logger log = Logger.getLogger(Requirement3.class);

	@FindBy(xpath = "//div[@class='desktop-getUserInLinks desktop-getInLinks']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class='desktop-userIconsContainer']//span[@class='desktop-userTitle']")
	private WebElement profile;
	
	@FindBy(xpath = "//input[@autocomplete='new-password']")
	private WebElement loginUser;
	
	@FindBy(xpath = "//div[@class='submitBottomOption']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//div[@class='desktop-infoEmail']")
	private WebElement infoEmail;
	
	public Requirement4(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void userName(String userId) {
		loginUser.sendKeys(userId);
	}
	public void login(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		loginBtn.click();
		userName(prop.getProperty("userId"));
		submitBtn.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		StaleElementHandleByID(profile);
		String infoEmailText=infoEmail.getText();
		Assert.assertEquals(infoEmailText, prop.getProperty("userId"));
	}
	public void StaleElementHandleByID (WebElement profile)
	{
	    int count = 0;
	    Actions act=new Actions(driver);
	    boolean clicked = false;
	    while (count < 4 && !clicked)
	    {
	        try 
	        {
	    		act.moveToElement(profile).build().perform();
	            clicked = true;
	        } 
	        catch (StaleElementReferenceException e)
	        {
	            e.toString();
	            System.out.println("Trying to recover from a stale element :" + e.getMessage());
	            count = count+1;
	        }
	    }
	}
}
