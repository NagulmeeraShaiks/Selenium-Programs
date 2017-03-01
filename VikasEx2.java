package VikasPackTestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VikasEx2 {
		static String driverpath="C:\\vikas";
		protected static WebDriver d;
		@BeforeClass
		public void setUp()
		{
			System.out.println("*******************");
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", driverpath+"\\chromedriver.exe");
			d = new ChromeDriver();
			//d=new FirefoxDriver();
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
		}
		@Test
		public void testMouseOver() throws Exception
		{
			//Load web page
			d.get("https://www.policybazaar.com/");
			Assert.assertEquals("Compare Insurance Quotes Online: Life | Car | Health | Travel",d.getTitle());
			Actions a=new Actions(d);
			a.moveToElement(d.findElement(By.xpath("//div[@id='navbar']/ul[2]/li/a"))).perform();
			d.findElement(By.linkText("Child Plans")).click();
			Thread.sleep(4000);
			d.navigate().back();
			a.moveToElement(d.findElement(By.xpath("//*[@id='navbar']/ul[2]/li[2]/a"))).perform();
			d.findElement(By.linkText("Health Plans")).click();
			Thread.sleep(4000);
			d.navigate().back();
			a.moveToElement(d.findElement(By.xpath("//*[@id='navbar']/ul[2]/li[5]/a"))).perform();
			d.findElement(By.linkText("Ask a Question")).click();
			WebElement textone=d.findElement(By.cssSelector("#db_title"));
			Actions textoneaction=new Actions(d);
			Action textonepass=textoneaction
					.moveToElement(textone)
					.keyDown(textone,Keys.SHIFT)
					.sendKeys("ITS SECURE").build();
			textonepass.perform();
		}
}
