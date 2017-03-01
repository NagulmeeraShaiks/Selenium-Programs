package VikasPackTestNg;

import java.awt.RenderingHints.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EventsAndActions {
	String driverpath="C:\\vikas";
	protected WebDriver d;
	@BeforeClass
	public void setUp()
	{
		
		System.out.println("*******************");
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverpath+"\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	@Test
	public void TestMouseFlow() throws Exception
	{
		d.get("https://mouseflow.com/");
		d.findElement(By.xpath("//a[contains(@href, '/tour/')]")).click();
		Actions fomeanalitical=new Actions(d);
		fomeanalitical.moveToElement(d.findElement(By.xpath("//li[4]/div/a/span"))).click().build().perform();
		d.navigate().back();
		d.findElement(By.xpath("(//a[contains(text(),'Sign Up Now')])[2]")).click();
		fomeanalitical.moveToElement(d.findElement(By.cssSelector(".form-control")))
		.click().sendKeys("birruchennaia@gmail.com").build().perform();
		fomeanalitical.moveToElement(d.findElement(By.cssSelector("input[placeholder='Password']"))).click()
		.sendKeys("vikas1234").doubleClick().contextClick().build().perform();
		Thread.sleep(5000);
		fomeanalitical.moveToElement(d.findElement(By.cssSelector("#domain"))).click()
		.sendKeys("vikascbasedlanguages.webs.com").doubleClick().build().perform();
		d.findElement(By.cssSelector("#plan")).click();
		List<WebElement> planlist=d.findElements(By.xpath("//*[@id='plan']/option"));
		System.out.println(planlist.size());
		for(WebElement e:planlist)
		{
			System.out.println(e.getText());
		}
		if(planlist.size()>=5)
		{
			for(int i=0;i<2;i++)
			{
				d.findElement(By.cssSelector("#plan")).sendKeys(Keys.ARROW_DOWN);
				Thread.sleep(2000);
			}
			//d.findElement(By.cssSelector("#plan")).sendKeys(Keys.ENTER);
			d.findElement(By.cssSelector("#plan")).sendKeys(Keys.RETURN);
		}
		d.findElement(By.cssSelector("#term")).click();
		List<WebElement> termlist=d.findElements(By.cssSelector("#term"));
		System.out.println(termlist.size());
		for(WebElement e:termlist)
		{
			System.out.println(e.getText());
		}
		if(termlist.size()>=1)
		{
			for(int i=0;i<1;i++)
			{
				d.findElement(By.cssSelector("#term")).sendKeys(Keys.ARROW_UP);
				Thread.sleep(2000);
			}
			d.findElement(By.cssSelector("#term")).sendKeys(Keys.RETURN);			
		}
		WebElement chech=d.findElement(By.id("accept"));
		Assert.assertFalse(chech.isSelected());
		chech.click();
		d.findElement(By.linkText("Next")).click();
	}
	
	

}