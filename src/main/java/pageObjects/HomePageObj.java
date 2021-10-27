package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObj
{
	public WebDriver driver;
	public HomePageObj(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='loginName']")
	WebElement username;
	
	public WebElement usernameObj()
	{
		return username;
	}
	
	@FindBy(xpath="//input[@id='loginPwd']")
	WebElement password;
	
	public WebElement passwordObj()
	{
		return password;
	}
	
	@FindBy(xpath="//div[@id='initialLayer']/p")
	WebElement pageTitle;
	
	public WebElement pageTitleObj()
	{
		return pageTitle;
	}
	
}
