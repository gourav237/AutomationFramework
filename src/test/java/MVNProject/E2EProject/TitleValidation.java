package MVNProject.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePageObj;

public class TitleValidation extends base
{
	WebDriver driver;
	@BeforeTest
	public void homePageNav() throws IOException, InterruptedException
	{
		driver = startUp();
		System.out.println("Driver invoked");
	}
	
	@Test
	public void validateTitle()
	{
		HomePageObj homeobj = new HomePageObj(driver);
		log.info("Going for title assertion");
		AssertJUnit.assertEquals("Welcome to ILTR Registry Manager",homeobj.pageTitleObj().getText());
	}
}