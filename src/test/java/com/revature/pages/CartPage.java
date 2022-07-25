package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CartPage {


	//ASSIGNING THE WEB DRIVER FOR THE CARTPAGE
	private WebDriver driver;
	private HomePage hp;
	private LoginPage loginPage;
	
	// a constructor to create an instance of this Page, and also initialize the web elements on the page.
	public CartPage(WebDriver driver) {
		this.driver = driver;
		// this next bit of code is working from the PageFactory
		PageFactory.initElements(driver, this);
		
	}
	
	// SETTING UP ALL THE ELEMENTS THAT WE ARE GOING TO BE USING
	
	
	
	
	private By shoppingCartEmptyMessage = By.xpath("/html/body/app-root/app-cart/div[1]/h4");
	private By addToCartButton = By.xpath("//*[@id=\"games\"]/div/div[2]/div/div[4]/div/button[2]");
	private By cartTable = By.xpath("/html/body/app-root/app-cart/div/div/div[2]/table/tbody");
	private By cartTableFirstItem = By.xpath("/html/body/app-root/app-cart/div/div/div[2]/table/tbody/tr/td[2]/span[1]/b");
	
	public By getCartTable() {
		return cartTable;
	}
	
	public String getCartTableFirstItemName() {
		return driver.findElement(cartTableFirstItem).getText();
	}
	
	public void loginThenNavigateToCart() {
		driver.findElement(hp.getLoginLink()).click();
		hp.getLoginLink();
		
//		hp.loginForHomePage("joshua_test", "test_joshua");
//		driver.findElement(navCartButton).click();
	}
	
	
	public void moveToLogin() {
		hp.navToLoginPage();
	}
	
	
//	public void noItemsInCartPage() {
//		
//		driver.findElement(shoppingCartEmptyMessage).click();
//	}
//	
//	public void proceedToCheckout() {
////		driver.findElement(proceedToCheckout).click();
////		driver.findElement(orderButton).click();
//	}
	
//	public String successfulOrderText() {
////		return thankYouText;
//	}
	
//	public String emptyCartString() {
////		return emptyCartText;
//	}
//	private cartTblRemoveButtons = cartTable.findElement((SearchContext) By.tagName("button"));
	// THIS LOCATES THE TOP LEVEL NAVIGATION CART BUTTON
//	@FindBy(xpath = "/html/body/app-root/router-outlet/app-nav-bar/ul/li[3]/a")
//	public WebElement navCartButton;
	
	
	
	// THIS LOCATES THE TOP LEVEL NAVIGATION CART BUTTON
//	@FindBy(xpath = "/html/body/app-root/app-cart/div[1]/h4")
//	public WebElement shoppingCartEmptyMessage;
	
	
//	@FindBy(xpath = "//*[@id=\"games\"]/div/div[2]/div/div[4]/div/button[2]")
//	public WebElement addToCartButton;
	
	
	// THIS CART TABLE WILL ONLY APPEAR IF THERE IS AN ITEM IN THE CART
//	@FindBy(xpath = "/html/body/app-root/app-cart/div/div/div[2]/table/tbody")
//	public WebElement cartTable;
	
	
	// THIS WILL BRING UP ALL THE BUTTONS INSIDE OF THE cartTable
//	public WebElement cartTblRemoveButtons = cartTable.findElement(By.tagName("button"));
	
	
	
//	String noElements = "/html/body/app-root/app-cart/div[1]/h4";
//	driver.findElement(By.xpath(noElements));
	
	
//	@Test
//	public void randoTesto() throws InterruptedException {
////		File chrome = new File("src/test/resources/chromedriver.exe");
////		System.setProperty("webdriver.chrome.driver",chrome.getAbsolutePath());
//		
////		WebDriver driver = new ChromeDriver();
//		
////		System.out.println("I ran here");
//		driver.get("http://localhost:4200/");
//		System.out.println("I instantiated");
//		
//		
////		String navCartButtonPath = "/html/body/app-root/router-outlet/app-nav-bar/ul/li[3]/a";
////		String shoppingCartEmptyMessagePath = "/html/body/app-root/app-cart/div[1]/h4";
////		String addToCartButtonPath = "//*[@id=\"games\"]/div/div[2]/div/div[4]/div/button[2]";
////		String cartTablePath ="/html/body/app-root/app-cart/div/div/div[2]/table/tbody";
////				cartTblRemoveButtonsPath =
//		int millies = 800;
//		driver.wait(millies);
//		
////		WebElement navBtn = cartPage.navCartButton;
////		navBtn.click();
////		driver.wait(millies)
////		driver.wait(millies ,ExpectedConditions.elementToBeClickable(By.xpath(navCartButtonPath))).click();
////		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(navCartButtonPath))).click();
////		WebElement web = driver.findElement(By.xpath(navCartButtonPath));
////		web.click();
//	}

	
}
