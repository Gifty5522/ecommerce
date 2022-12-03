package testcase;

import org.testng.annotations.Test;

import ecommerce.luma.BaseClass;
import page.LumaPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TC_Luma_Purchase_Product {
	
	public WebDriver driver = null;
	public BaseClass basePage = null;
	public LumaPage lumaPage = null;
	
	@BeforeTest
	@Parameters({ "url" })
	public void setUp(String url) throws InterruptedException {
		BaseClass basePage = new BaseClass();
		driver = basePage.loadURL(url);
		lumaPage = new LumaPage(driver);
		
	}
  
  @Test
  public void purchaseAProduct() throws InterruptedException {
	  lumaPage.orderProcessing();
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("HELL");
	  driver.close();
  }

}
