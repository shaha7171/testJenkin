package screen1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import base.BaseTest;
//import utilities.ExcelReader;
//import utilities.MonitoringMail;

public class core {

	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(core.class);
	public static void click(){
		
	}
	
	public static void click(String locatorKey) {
		if (locatorKey.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locatorKey))).click();
		}
		else if (locatorKey.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).click();
		} else if (locatorKey.endsWith(OR.getProperty("_ID"))) {
			driver.findElement(By.id(locatorKey)).click();
		}			
	}

	@Test
	public void setUp() throws IOException {

		
		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		Config.load(fis);

		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Config.getProperty("testsiteurl"));
		/*click("welcome_CSS");
		click("Connections_CSS");
		driver.navigate().back();
		String text = driver.findElement(By.cssSelector(OR.getProperty("Text_CSS"))).getText();
		assertTrue(text.contains("Welcome to the User Configurable Dashboard!"));*/

		String title  = driver.getTitle();
		System.out.println(title);
	}
}
