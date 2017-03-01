package ts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.*;



public class BrowserHistory {
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
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser)
	{

		//Launch browser
    	if(browser.equals("FF"))
    	{
    		d=new FirefoxDriver();
    	}
    	else if(browser.equals("GC"))
    	{
    		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Batch_files\\Lib\\chromedriver.exe");
    		d=new ChromeDriver();
    	}
    	else if(browser.equals("IE"))
    	{
    		System.setProperty("webdriver.ie.driver", "D:\\Selenium_Batch_files\\Lib\\IEDriverServer.exe");
    		d=new InternetExplorerDriver();
    	}
		
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

