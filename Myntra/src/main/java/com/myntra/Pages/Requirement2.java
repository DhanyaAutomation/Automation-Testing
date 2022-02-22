package com.myntra.Pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.myntra.Base.TestBase;

public class Requirement2 extends TestBase {
	private static final Logger log = Logger.getLogger(Requirement2.class);

	@FindAll({ @FindBy(xpath = "//div[@class='desktop-pSearchlinks']//a") })
	private List<WebElement> popularSearchList;

	@FindBy(xpath = "//div[@class='desktop-pSearchTitle']")
	private WebElement popularSearchTitle;

	public Requirement2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> popularSearch() {
		List<WebElement> searchList = popularSearchList;
		for (int i = 0; i < searchList.size(); i++) {
			String searchLink = searchList.get(i).getAttribute("href");
			System.out.println(searchLink);
			searchList.get(i).click();
			// String url="https://www.myntra.com"+searchLink;
			// log.info(url);
			String urlTitle = driver.getCurrentUrl();
			log.info(urlTitle);
			SoftAssert softAssert = new SoftAssert();
			// System.out.println(urlTitle);
			softAssert.assertEquals(urlTitle.equalsIgnoreCase(searchLink), true);
			driver.navigate().back();
		}
		return popularSearchList;

	}
}
