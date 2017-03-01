package VikasPackTestNg;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DhEvets {
	protected WebDriver d;
	String driverpath="C:\\vikas";
	@BeforeClass
	public void setUp()
	{
		//launch the browser
		System.setProperty("webdriver.chrome.driver",driverpath+"\\chromedriver.exe");
		//System.setProperty("webdriver.ie.driver", driverpath+"\\IEDriverServer.exe");
		d=new ChromeDriver();
		//DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		//caps.setCapability("ignoreZoomSetting", true);
		//d = new InternetExplorerDriver(caps);
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
	}
	@Test
	public void testMuseandKeyboardEvents() throws Exception
	{
		d.get("http://www.gico.it/en#");
		d.findElement(By.cssSelector("#chiudi")).click();
		Actions mouseaction=new Actions(d);
		/*d.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "90"));
		Thread.sleep(5000);
		//WebElement htmal = d.findElement(By.tagName("html"));
		//html.sendKeys(Keys.chord(Keys.CONTROL, "90"));
		//htmal.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		//mouseaction.keyUp(Keys.CONTROL.SUBTRACT).perform();*/
		mouseaction.moveToElement(d.findElement(By.cssSelector("a[title='Products']")))
		.moveToElement(d.findElement(By.cssSelector("a[title='Cooking Systems']")))
		.moveToElement(d.findElement(By.cssSelector("a[title='G5001 Series']")))
		.build().perform();
		d.findElement(By.xpath("//a[contains(@href, '/en/products/modular_cooking_systems/g5001-series/g5001-bain-marie')]")).click();
		mouseaction.moveToElement(d.findElement(By.xpath("//nav[@id='menu']/ul/li/span"))).perform();
		List<WebElement> firstlinks=d.findElements(By.cssSelector("#menu>ul[class='sf-menu ul_liv_1 ']>li>ul[class='ul_liv_2 ul_liv_2L_azienda']>li"));
		System.out.println("No of links:"+firstlinks.size());
		String clickliks[]=new String[firstlinks.size()];
		int i=0;
		for(WebElement e:firstlinks)
		{
			System.out.println(e.getText());
			clickliks[i]=e.getText();
			i++;
		}
		for(String f:clickliks)
		{
			mouseaction.moveToElement(d.findElement(By.xpath("//nav[@id='menu']/ul/li/span"))).perform();
			d.findElement(By.linkText(f)).click();
			if(d.getTitle().contains("404"))
			{
				System.out.println("link not avalable");
			}
			else
			{
				System.out.println("linkavalable");
			}
		}
		mouseaction.moveToElement(d.findElement(By.cssSelector("a[title='Products']")))
		.moveToElement(d.findElement(By.cssSelector("a[title='Cooking Systems']")))
		.moveToElement(d.findElement(By.cssSelector("a[title='G5001 Series']")))
		.build().perform();
		List<WebElement> sublistlinks=d.findElements(By.xpath("//nav[@id='menu']/ul/li[2]/ul/li[2]/ul/li[4]/ul/li"));
		String sublinkstore[]=new String[sublistlinks.size()];
		System.out.println("no of sub links:"+sublistlinks.size());
		int k=0;
		for(WebElement g:sublistlinks)
		{
			System.out.println(g.getText());
			sublinkstore[k]=g.getText();
			k++;
		}
		for(String h:sublinkstore)
		{
			mouseaction.moveToElement(d.findElement(By.cssSelector("a[title='Products']")))
			.moveToElement(d.findElement(By.cssSelector("a[title='Cooking Systems']")))
			.moveToElement(d.findElement(By.cssSelector("a[title='G5001 Series']")))
			.build().perform();
			//d.findElement(By.cssSelector("#chiudi")).click();
			Thread.sleep(5000);
			d.findElement(By.linkText(h)).click();
			if(d.getTitle().contains("404"))
			{
				System.out.println("link not avalable");
			}
			else
			{
				System.out.println("link avalable");
			}
		}
		
	}
	

}
