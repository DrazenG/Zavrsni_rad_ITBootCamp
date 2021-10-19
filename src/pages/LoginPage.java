package pages;



	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class LoginPage extends BasicPage {
		
		
		public LoginPage(WebDriver driver, WebDriverWait wait) {
			super(driver, wait);
		}
		
		// Elements -Elementi koji su na potrebni i koji se nalaze u okviru zahtevane funkcionalnosti
		
		
		public WebElement getUsername() {
			return driver.findElement(By.name("username"));
		}

		
		public WebElement getPassword() {
			return driver.findElement(By.name("password"));
		}
		
		public WebElement getLoginButton() {
			return driver.findElement(By.name("btn_submit"));
		}
		
		
		// Methods  - Metode koje koristimo kao deo rseavanja ili ispunjavanja neke funkcionalnosti
		
		public void login(String username, String password) {
			
			this.getUsername().clear();
			this.getUsername().sendKeys(username);
			this.getPassword().clear();
			this.getPassword().sendKeys(password);
			this.getLoginButton().click();
}
}