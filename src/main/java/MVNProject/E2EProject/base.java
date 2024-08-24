package MVNProject.E2EProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base
{
	public WebDriver driver;
	public Properties prop;
	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver startUp() throws IOException
	{
		System.out.println(System.getProperty("user.dir")+"\\resources\\data.properties");
		prop = new Properties();
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+"\\resources\\data.properties");
		prop.load(stream);
		
		String browserName = System.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+"\\resources\\chromedriver.exe"));
			driver = new ChromeDriver();
			log.info("Driver invoked");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to("https://iltr.gridsensehealth.com/GS_UI/gridsense/loginScreen.html");
		return driver;
	}
	
	public String getScreenshot(String methodname, WebDriver driver) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		System.out.println(System.getProperty("user.dir")+"/report/" );
		String destination = System.getProperty("user.dir")+"/report/"+methodname+".PNG";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}
}
