package testcase;

import org.testng.annotations.Test;

import ecommerce.luma.BaseClass;
import ecommerce.luma.HelperClass;
import logs.TestExecutionProp;
import page.LumaPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class TC_Luma_Purchase_Product {
	
	public WebDriver driver = null;
	public BaseClass basePage = null;
	public LumaPage lumaPage = null;
	private final Logger APP_LOGS = TestExecutionProp.getTestExecutionLogsProperties();
	
	@BeforeTest
	@Parameters({ "url" })
	public void setUp(String url) throws InterruptedException {
		APP_LOGS.info("Inside Before Test - Setup");
		HelperClass hp = new HelperClass();
		BaseClass basePage = new BaseClass();
		driver = basePage.loadURL(url);
		lumaPage = new LumaPage(driver);
		lumaPage.registerUser();
	}
  
  @Test
  public void purchaseAProduct() throws InterruptedException {
	  APP_LOGS.info("Inside Actual Test");
	  lumaPage.menuSelection();
	  lumaPage.selectAProduct();
	  lumaPage.shoppingCart();
	  lumaPage.orderProduct();
	  lumaPage.placeOrder();
  }

  @AfterSuite
  public void afterMethod() {
	  APP_LOGS.info("Inside After Test - closing");
	  driver.close();
  }

}
