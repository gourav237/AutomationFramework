package MVNProject.E2EProject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePageObj;

public class HomePageTest extends base
{
	@BeforeTest
	public void homePageNav() throws IOException, InterruptedException
	{
		driver = startUp();
		System.out.println("Driver invoked");
		System.out.println("I am here");
	}
	
	@Test(dataProvider="loginData")
	public void login(String username, String password)
	{
		driver.navigate().to("https://iltr.gridsensehealth.com/GS_UI/gridsense/loginScreen.html");
		HomePageObj homeobj = new HomePageObj(driver);
		
		WebElement usernameElement = homeobj.usernameObj();
		usernameElement.sendKeys(username);
		
		WebElement pwdElement = homeobj.passwordObj();
		pwdElement.sendKeys(password);
		
		System.out.println("Assertion");
		Assert.assertTrue(true);
		
	}
	
	
	@DataProvider(name="loginData")
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		
		data[0][0] = "gourav@metamagics.com";
		data[0][1] = "Hello";
		
		data[1][0] = "gourav1@metamagics.com";
		data[1][1] = "Hello";
		
		return data;
	}
	
	@AfterTest
	private void terminator()
	{
		System.out.println("End of Test");
	}
}