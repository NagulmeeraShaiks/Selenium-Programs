package abcpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserHistoryDemo {
	WebDriver d;
	@Test
	public void browserHistory() throws Exception
	{
		//Load web page
		d.navigate().to("http://docs.seleniumhq.org/");
		Assert.assertEquals("Selenium - Web Browser Automation",d.getTitle());
		//Click on Download
		d.findElement(By.linkText("Download")).click();
		Thread.sleep(3000);
		d.navigate().back();
		Thread.sleep(3000);
		d.navigate().forward();
		Thread.sleep(3000);
		d.navigate().refresh();
		Thread.sleep(3000);
	}
	@BeforeMethod
	public void setUp()
	{

		//Launch browser
		d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\DriverServer\\chromedriver.exe");
		//d=new ChromeDriver();
		System.setProperty("webdriver.ie.driver", "E:\\DriverServer\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		d.manage().deleteAllCookies();		
	}
	@AfterMethod
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
