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

import io.github.bonigarcia.wdm.WebDriverManager;

public class base
{
	public WebDriver driver;
	public Properties prop;
	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver startUp() throws IOException
	{
		
		prop = new Properties();
		FileInputStream stream = new FileInputStream("/home/sanvar/workspaceSelenium/E2EProject/resources/data.properties");
		prop.load(stream);
		
		if(prop.getProperty("browser").equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Driver invoked");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
