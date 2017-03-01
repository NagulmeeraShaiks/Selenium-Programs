package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseOverDemo {
	WebDriver d;
	@Test
	public void mouseOver() throws Exception
	{
		//Load web page
		d.get("http://www.policybazaar.com/");
		assertEquals("Compare Insurance Quotes Online: Life | Car | Health | Travel",d.getTitle());
		Actions a=new Actions(d);
		a.moveToElement(d.findElement(By.linkText("Life Insurance"))).perform();
		a.moveToElement(d.findElement(By.linkText("Life Insurance"))).click(d.findElement(By.linkText("Investment Plans"))).build().perform();
		Thread.sleep(4000);
	}
	@BeforeMethod
	public void setUp()
	{
		//Launch browser
		d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium_Scripts_May16\\Lib\\chromedriver.exe");
		//d=new ChromeDriver();
		System.setProperty("webdriver.ie.driver", "E:\\Selenium_Scripts_May16\\Lib\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterMethod 
	public void tearDown()
	{
		//Close the browser
        d.quit();
	}

}
