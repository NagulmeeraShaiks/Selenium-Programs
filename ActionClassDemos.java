package VikasPackTestNg;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionClassDemos {
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
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	@Test
	public void TestDragNDrop() throws Exception
	{
		d.get("http://code.makery.ch/library/dart-drag-and-drop/");
		List<WebElement> frames=d.findElements(By.tagName("iframe"));
		System.out.println("no of frames in drag and drop   :"+frames.size());
		d.findElement(By.cssSelector(".pull-right")).click();
		Set<String> wind=d.getWindowHandles();
		String windowhndls[]=new String[wind.size()];
		int i=0;
		for(String e:wind)
		{
			System.out.println(e);
			windowhndls[i]=e;
			i++;
		}
		d.switchTo().window(windowhndls[1]);
		d.findElement(By.linkText("Example Source on GitHub")).click();
		d.navigate().back();
		Actions dragtodestbin=new Actions(d);
		//dragtodestbin.dragAndDrop(d.findElement(By.xpath("//div[@class='container']/img")),d.findElement(By.cssSelector(".trash"))).perform();
		dragtodestbin.dragAndDrop(d.findElement(By.xpath("//img")),d.findElement(By.cssSelector(".trash"))).perform();
		Thread.sleep(2000);
		dragtodestbin.dragAndDrop(d.findElement(By.xpath("//img[2]")),d.findElement(By.cssSelector(".trash"))).perform();
		Thread.sleep(2000);
		dragtodestbin.dragAndDrop(d.findElement(By.xpath("//img")),d.findElement(By.cssSelector(".trash"))).perform();
		Thread.sleep(2000);
		dragtodestbin.dragAndDrop(d.findElement(By.xpath("//img")),d.findElement(By.cssSelector(".trash"))).perform();
		Thread.sleep(2000);
		d.close();
		d.switchTo().window(windowhndls[0]);
		d.switchTo().frame(1);
		dragtodestbin.dragAndDrop(d.findElement(By.xpath("//img")),d.findElement(By.cssSelector(".trash"))).perform();
		Thread.sleep(2000);
		dragtodestbin.dragAndDrop(d.findElement(By.xpath("//img[2]")),d.findElement(By.cssSelector(".trash"))).perform();
		Thread.sleep(2000);
		dragtodestbin.dragAndDrop(d.findElement(By.xpath("//img")),d.findElement(By.cssSelector(".trash"))).perform();
		Thread.sleep(2000);
		dragtodestbin.dragAndDrop(d.findElement(By.xpath("//img")),d.findElement(By.cssSelector(".trash"))).perform();
		Thread.sleep(2000);
		Thread.sleep(2000);
		d.switchTo().defaultContent();
		d.switchTo().frame(6);
		dragtodestbin.dragAndDropBy(d.findElement(By.cssSelector("div.container>div.draggable")), 400,0).perform();
		Thread.sleep(4000);
		d.switchTo().defaultContent();
		d.switchTo().frame(5);
		dragtodestbin.dragAndDropBy(d.findElement(By.cssSelector("div.container>div.draggable")), 400,0).perform();

		
	}
	@Test
	public void testSlider() throws Exception
	{
		//Load web page
		d.get("http://jqueryui.com/slider/");
		//assertEquals("Slider | jQuery UI",d.getTitle());
		//Switch driver focus to frame
		d.switchTo().frame(0);
		Actions a=new Actions(d);
		a.dragAndDropBy(d.findElement(By.xpath("//div[@id='slider']/span")), 200,0).perform();
		Thread.sleep(4000);
	}
	@Test
	public void testSlider1() throws Exception
	{
		d.get("http://code.makery.ch/library/dart-drag-and-drop/");
		for (int n=0;n<10;n++)
        {
           ((RemoteWebDriver) d).executeScript("window.scrollBy(0,300)");
           Thread.sleep(1000);
        }
    }
	@Test
	public void irctcslider() throws Exception
	{
		d.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		d.findElement(By.linkText("Food-on-Track")).click();
		Set<String> window=d.getWindowHandles();
		String vikasirctc[]=new String[window.size()];
		int i=0;
		for(String e:window)
		{
			System.out.println(e);
			vikasirctc[i]=e;
			i++;
		}
		d.switchTo().window(vikasirctc[1]);
		d.findElement(By.linkText("Station List")).click();
		//d.findElement(By.id("contdiv"));
		Point hoverItem =d.findElement(By.xpath("//*[@id='contdiv']/div[2]")).getLocation();
		((JavascriptExecutor)d).executeScript("window.scrollBy(0,"+(hoverItem.getY())+");");
		/*for (int n=0;n<10;n++)
        {
           ((RemoteWebDriver) d).executeScript("window.scrollBy(0,300)");
           Thread.sleep(1000);
        }*/
		
				
	}
	@Test()
	public void TestClick() throws Exception
	{
		d.get("http://newtours.demoaut.com/");
		WebElement Home=d.findElement(By.linkText("Home"));
		WebElement td_Home = d
                .findElement(By
                .xpath("//html/body/div"
                + "/table/tbody/tr/td"
                + "/table/tbody/tr/td"
                + "/table/tbody/tr/td"
                + "/table/tbody/tr")); 
		Actions builder = new Actions(d);
        Action mouseOverHome = builder
                .moveToElement(Home)
                .build();
        String bgColor = td_Home.getCssValue("background-color");
        System.out.println("Before hover: " + bgColor);        
        mouseOverHome.perform();        
        bgColor = td_Home.getCssValue("background-color");
        System.out.println("After hover: " + bgColor);
       Thread.sleep(5000);
	}
/*	@Test
	public void ATestFaceBook()
	{
		   d.get("http://www.facebook.com");
		   WebElement txtUserName = d.findElement(By.id("email"));
		   Actions builder = new Actions(d);
		   Action seriesOfActions = builder
		              .moveToElement(txtUserName)
		              .click()
		              .keyDown(txtUserName, Keys.SHIFT) //this will type the "hello" in uppercase
		              .sendKeys(txtUserName, "pydeepu")
		              .keyUp(txtUserName, Keys.SHIFT)
		              .doubleClick(txtUserName) // this will highlight/select the text "hello"
		              .contextClick() // this will bring up the context menu
		              .build();
		   seriesOfActions.perform();
		}*/
	@Test
	public void ATestVikasEx()
	{
		d.get("http://www.facebook.com");
		WebElement username = d.findElement(By.id("email"));
		WebElement passwoard=d.findElement(By.id("pass"));
		WebElement login=d.findElement(By.id("u_0_l"));
		Actions vikasBuilding=new Actions(d);
		Actions cntvaction= vikasBuilding
				.moveToElement(username)
				.click()
				.keyDown(username,Keys.SHIFT)
				.sendKeys("pydeepu");
		cntvaction.perform();
		Action cntvaction1=vikasBuilding
				.moveToElement(passwoard)
				.click()
				.keyUp(passwoard,Keys.SHIFT)
				.sendKeys("vikas")
				.doubleClick()
				.contextClick()
				.build();
		cntvaction1.perform();
		login.click();
		
		
	}
}	