package page;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ecommerce.luma.BaseClass;
import ecommerce.luma.HelperClass;
import ecommerce.luma.lumaConstantLib;
import logs.TestExecutionProp;

public class LumaPage {

	WebDriver driver = null;
	BaseClass baseClass = null;
	WebDriverWait wait = null;
	HelperClass helperClass = null;
	Actions actions = null;
	List<String> userDetails = null;
	private final Logger APP_LOGS = TestExecutionProp.getTestExecutionLogsProperties();
	
	public LumaPage(WebDriver driver) {
		this.driver = driver;
		this.baseClass = new BaseClass();
		this.helperClass = new HelperClass();
		wait = BaseClass.waitInstance(driver, 20);
		actions = new Actions(driver);
		userDetails = helperClass.getUserDetails();
	}
	
	By createAccount = By.xpath(".//div[@class='panel header']/descendant::a[text()='Create an Account']");
	By fName = By.id("firstname");
	By lName = By.id("lastname");
	By email = By.id("email_address");
	By pwd = By.id("password");
	By cofirmPWD = By.id("password-confirmation");
	By submitButton = By.xpath(".//input[@id='password-confirmation']");
	
	By selectMenu = By.xpath(".//ul[@role='menu']/li/a/span[text()='Women']");
	By topMenu = By.xpath(".//ul[@role='menu']/li/a/span[text()='Women']/parent::a/following-sibling::ul/descendant::span[text()='Tops']");
	By jacket = By.xpath(".//ul[@role='menu']/li/a/span[text()='Women']/parent::a/following-sibling::ul/descendant::span[text()='Tops']/parent::a/following-sibling::ul/descendant::span[text()='Jackets']");
	
	By selectSize = By.xpath(".//a[contains(text(),'Olivia')]/parent::strong/following-sibling::div/descendant::div[text()='XS']");
	By selectColor = By.xpath(".//a[contains(text(),'Olivia')]/parent::strong/following-sibling::div/descendant::div[@option-label='Black']");
	By addToCart = By.xpath(".//a[contains(text(),'Olivia')]/parent::strong/following-sibling::div/descendant::span[text()='Add to Cart']");
	By shoppingList = By.xpath(".//a[text()='shopping cart']");
	By checkout = By.xpath(".//span[text()='Proceed to Checkout']");
	By itemCart = By.xpath(".//span[text()='Item in Cart']");
	By address = By.xpath(".//input[@name='street[0]']");
	By city = By.xpath(".//input[@name='city']");
	By zipCode = By.xpath(".//input[@name='postcode']");
	By selectRegion = By.xpath(".//select[@name='region_id']");
	By selectCountry = By.xpath(".//select[@name='country_id']");
	
	By telephone = By.xpath(".//input[@name='telephone']");
	By shippingMethod = By.xpath(".//input[@name='ko_unique_3']");
	By nextButton = By.xpath(".//span[text()='Next']");
	
	By placeOrder = By.xpath(".//*[text()='Place Order']");
	By continueButton = By.xpath(".//*[text()='Continue Shopping']");
	
	By orderID = By.xpath(".//div[@class='checkout-success']/p/a");
	
	public void registerUser() throws InterruptedException{
		APP_LOGS.info("User Registration Started.....");
		driver.findElement(createAccount).click();
		driver.findElement(fName).sendKeys(userDetails.get(0));
		driver.findElement(lName).sendKeys(userDetails.get(1));
		driver.findElement(email).sendKeys(userDetails.get(2));
		driver.findElement(pwd).sendKeys(lumaConstantLib.PASSWORD);
		driver.findElement(cofirmPWD).sendKeys(lumaConstantLib.PASSWORD);
		driver.findElement(submitButton).submit();
		APP_LOGS.info("User has Registered Successfully.....");
	}
	
	public void menuSelection(){
		APP_LOGS.info("Menu Selection started.....");
		wait.until(ExpectedConditions.elementToBeClickable(selectMenu));
		actions.moveToElement(driver.findElement(selectMenu)).build().perform();
		actions.moveToElement(driver.findElement(topMenu)).build().perform();
		driver.findElement(jacket).click();
		APP_LOGS.info("Done with the menu selection.....");
	}
	
	public void selectAProduct() throws InterruptedException{
		APP_LOGS.info("Product Selection started.....");
		wait.until(ExpectedConditions.elementToBeClickable(selectMenu));
		driver.findElement(selectSize).click();
		driver.findElement(selectColor).click();
		Thread.sleep(1000);
		driver.findElement(addToCart).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(shoppingList)));
		wait.until(ExpectedConditions.elementToBeClickable(shoppingList));
		APP_LOGS.info("Done with Product Selection.....");
	}
	
	public void shoppingCart() throws InterruptedException{
		APP_LOGS.info("Shopping Cart.....");
		driver.findElement(shoppingList).click();
		wait.until(ExpectedConditions.elementToBeClickable(checkout));
		driver.findElement(checkout).click();
		Thread.sleep(3000);
	}
	
	public void orderProduct() throws InterruptedException{
		APP_LOGS.info("Order a product process started.....");
		wait.until(ExpectedConditions.elementToBeClickable(itemCart));
		driver.findElement(itemCart).click();
		driver.findElement(address).sendKeys(userDetails.get(3));
		driver.findElement(city).sendKeys(lumaConstantLib.CITY);
		new Select(driver.findElement(selectCountry)).selectByVisibleText(lumaConstantLib.COUNTRY);
		new Select(driver.findElement(selectRegion)).selectByVisibleText(lumaConstantLib.STATE);
		driver.findElement(zipCode).sendKeys(lumaConstantLib.ZIPCODE);
		driver.findElement(telephone).sendKeys(userDetails.get(4));
		Thread.sleep(5000);
		driver.findElement(nextButton).click();
		APP_LOGS.info("Done with order a product.....");
	}
	
	public void placeOrder() throws InterruptedException{
		APP_LOGS.info("Placing a order process started.....");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(placeOrder));
		driver.findElement(placeOrder).click();
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		String orderId = driver.findElement(orderID).getText();
		APP_LOGS.info("Your Order ID is : " + orderId);
		APP_LOGS.info("Done with the order placing.....");
	}
}
