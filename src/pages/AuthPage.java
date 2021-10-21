package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js, Actions actions) {
		this.driver = driver;
		this.wait = wait;
		this.js = js;
		this.actions = actions;
	}
	
	public WebElement getDropDownMenu() {
		return this.driver.findElement(By.xpath("//*[@class='user-trigger-js']"));
	}

	public WebElement getMyAccount() {
		return this.driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[2]/div[2]/ul/li/div/ul/li[1]/a"));
	}
	
	public WebElement getLogout() {
		return this.driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[2]/div[2]/ul/li/div/ul/li[2]/a"));
	}
	
	public String getLogoutNotificationMessageText() {
		return driver.findElement(By.xpath("///html/body/div[2]/div/div/ul/li")).getText(); 
	}
	
	public void userLogout() {
		this.getDropDownMenu().click();
		this.getLogout().click();
	}

}
