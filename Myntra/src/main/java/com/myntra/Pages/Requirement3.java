package com.myntra.Pages;

import java.util.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.myntra.Base.TestBase;

public class Requirement3 extends TestBase {
	private static final Logger log = Logger.getLogger(Requirement3.class);

	@FindAll({ @FindBy(xpath = "//li[@class='desktop-suggestion null']") })
	private List<WebElement> autoSearchList;

	@FindBy(xpath = "//input[@placeholder='Search for products, brands and more']")
	private WebElement search;

	@FindBy(xpath = "//label//input[@type='checkbox' ][@value='Tshirts']")
	private WebElement catagoryTshirt;

	@FindAll({ @FindBy(xpath = "//li[@class='product-base']") })
	private List<WebElement> TshirtList;
	
	@FindAll({ @FindBy(xpath = "//li[@class='product-base']//div//h3") })
	private List<WebElement> TshirtNameList;

	@FindBy(xpath = "//div//span[@class='myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center']")
	private WebElement addToBag;

	@FindAll({
			@FindBy(xpath = "//div[@class='size-buttons-buttonContainer']//button[@class='size-buttons-size-button size-buttons-size-button-default']") })
	private List<WebElement> size;
	
	@FindBy(xpath = "//a[@class='desktop-cart']")
	private WebElement bag;
	
	@FindBy(xpath = "//div[@class='itemContainer-base-brand']")
	private WebElement insidebag;
	
	public Requirement3(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void autoSearch() {
		String searchTerm = "Tshirt";
		search.clear();
		search.sendKeys(searchTerm);
		List<WebElement> autoSearch = autoSearchList;
		for (int i = 0; i < autoSearch.size(); i++) {
			System.out.println(autoSearch.get(i).getText());
			Assert.assertTrue(autoSearch.get(i).getText().contains(searchTerm),
					"Search result validation failed at instance [ + i + ].");
		}
		for (int i = 0; i < autoSearch.size(); i++) {
			if (autoSearch.get(i).getText().equalsIgnoreCase("Tshirts For Men")) {
				autoSearch.get(i).click();
				break;
			}
		}
		Actions act = new Actions(driver);
		act.moveToElement(catagoryTshirt).click().perform();
		// catagoryTshirt.click();
		String tshirt=TshirtList.get(0).getText();
		String tshirtName=TshirtNameList.get(0).getText();
		System.out.println(tshirt);
		TshirtList.get(0).click();
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
				size.get(0).click();
				addToBag.click();
				Actions act1= new Actions(driver);
				act1.moveToElement(bag).click().perform();
				String cart=insidebag.getText();
				System.out.println(cart);
				Assert.assertEquals(tshirtName, cart);
				driver.close();
			}
		}
		// switch to the parent window
		driver.switchTo().window(parent);
		
	}
}
