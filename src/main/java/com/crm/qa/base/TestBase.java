package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	@SuppressWarnings("deprecation")
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
	    try{
	    	prop = new Properties();
	    
		FileInputStream ip = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(ip);
	    }catch(FileNotFoundException e) {
	    	e.printStackTrace();
	    }catch(IOException e) {
	    	e.printStackTrace();
	    	
	    }
		
		
	}
	
	@SuppressWarnings("deprecation")
	public static void initialisation(){
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
		System.setProperty("webdriver.com.driver","\"D:\\\\selenium jars and drivers\\\\drivers\\\\chromedriver.exe\"");
		driver = new ChromeDriver();
		}else if(browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver","C:\\Users\\User\\IEDriverServer_x64_4.8.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else if(browserName.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\User\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		driver.get(prop.getProperty("url"));
	}

}
