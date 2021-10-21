package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage extends BasicPage {
	

	public CartSummaryPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js, Actions actions) {
		this.driver = driver;
		this.wait = wait;
		this.js = js;
		this.actions = actions;
		
	}
	//PROVERITI DIVOVE za ovaj element!!!!
	public String getEmptyCartText() {
		return driver.findElement(By.xpath("/html/body/div[2]/div")).getText(); 
	}

	
	public WebElement getClearAll() {
		return this.driver.findElement(By.xpath("//*[@id=\"cartSummary\"]/div/div[1]/a[2]"));
	
	}
	public void clearCart() {
		this.getClearAll().click();
	}
}
