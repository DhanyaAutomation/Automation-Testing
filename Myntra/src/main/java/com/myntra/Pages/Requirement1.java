package com.myntra.Pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myntra.Base.TestBase;

public class Requirement1 extends TestBase {
	private static final Logger log = Logger.getLogger(Requirement1.class);

	@FindAll({
		   @FindBy(xpath = "//div[@class='desktop-navLink']//a")	   
		})
		private List<WebElement> catagoryList; 
	
	@FindAll({
		   @FindBy(xpath = "//ul[@class='desktop-navBlock'][@data-reactid='27']//li")	   
		})
		private List<WebElement> insideMenCatagoryList; 
	@FindAll({
		   @FindBy(xpath = "//ul[@class='desktop-navBlock'][@data-reactid='186']//li")	   
		})
		private List<WebElement> insideWomenCatagoryList; 
	
	public Requirement1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public int menValidation() {
		WebElement men =catagoryList.get(0);
		Actions action= new Actions(driver);
		action.moveToElement(men).perform();
		List<WebElement>listTop= insideMenCatagoryList;
		for(WebElement list:listTop)
		log.info(list.getText());
		return listTop.size();
	}
	
	public int womenValidation() {
		WebElement men =catagoryList.get(1);
		Actions action= new Actions(driver);
		action.moveToElement(men).perform();
		List<WebElement>listTop= insideWomenCatagoryList;
		for(WebElement list:listTop)
		log.info(list.getText());
		return listTop.size();
	}
}
