package ecommerce.luma;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver = null;
	public WebDriverWait wait = null;

	public WebDriver loadURL(String url) {
		driver = loadDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver loadDriver() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		return driver;
	}

	public static WebDriverWait waitInstance(WebDriver driver, long timeDuration) {
		WebDriverWait wait = null;
		wait = new WebDriverWait(driver, timeDuration);
		return wait;
	}
	
	public static WebDriver getDriverObject() {
		return driver;
	}
	
	public void closeBrowser() {
		driver.close();
	}
}
