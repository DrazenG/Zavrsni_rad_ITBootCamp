package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js, Actions actions) {
		this.driver = driver;
		this.wait = wait;
		this.js = js;
		this.actions = actions;
	}

	// Elements -Elementi koji su na potrebni i koji se nalaze u okviru zahtevane
	// funkcionalnosti

	public WebElement getFirstName() {
		return this.driver.findElement(By.xpath("//*[@name='user_first_name']"));
	}

	public WebElement getLastName() {
		return this.driver.findElement(By.xpath("//*[@name='user_last_name']"));
	}

	public WebElement getAddress() {
		return this.driver.findElement(By.xpath("//*[@name='user_address']"));
	}

	public WebElement getPhoneNumber() {
		return this.driver.findElement(By.xpath("//*[@name='user_phone']"));
	}

	public WebElement getZipCode() {
		return this.driver.findElement(By.xpath("//*[@name='user_zip']"));
	}

	public Select getCountry() {
		return new Select(this.driver.findElement(By.id("user_country_id")));
	}

	public Select getState() {
		return new Select(this.driver.findElement(By.id("user_state_id")));
	}

	public Select getCity() {
		return new Select(this.driver.findElement(By.id("user_city)")));
	}

	// proveriti ovo za slike, ne znam da li je ok
	public WebElement getProfilePicture() {
		return this.driver.findElement(By.xpath("//*[@class='avatar']/img"));
	}
	
	public WebElement getAvatarArea() {
		return driver.findElement(By.className("avatar"));
	}

	public WebElement getUploadButton() {
		return this.driver.findElement(By.xpath("//*[@title='Uplaod']"));
	}
	
	public WebElement getDeleteButton() {
		return this.driver.findElement(By.xpath("//*[@title='Remove']"));
	}


	// html/head/body/form/ id=form-upload, input type="file" a ima i name="file";
	// na samom pocetku odmah od body-a
	public WebElement getProfilePictureInput() {
		return this.driver.findElement(By.xpath("//body/form/input"));
	}

	public WebElement getSaveButton() {
		return this.driver.findElement(By.xpath("//*[@class='col-sm-12']"));
	}
		
		public String getSaveNotificationMessageText() {
			return driver.findElement(By.xpath("//html/body/div[2]/div")).getText(); 
		}
		
		public String getUploadImageText() {
			return driver.findElement(By.xpath("/html/body/div[2]/div")).getText(); 
			
		}
		public String getDeletedImageText() {
			return driver.findElement(By.xpath("/html/body/div[2]/div")).getText(); 
			
		}
		
		// Upload slike 
		public void UploadPhoto() throws IOException, AWTException {
			actions.moveToElement(getAvatarArea()).perform();
			getProfilePicture().click();

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);

			File image = new File("img/slika.jpg");
			String photo = image.getAbsolutePath();
			getUploadButton().sendKeys(photo);
		}

		// Removes photo from the user profile
		public void removePhoto() throws AWTException {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", getDeleteButton());
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
		}
		
			// napraviti method get notification da ispravim gresku. promeniti naziv zbog cekanja slike
	//	public WebElement getNotification() {
		//	return driver.findElement(By.xpath("//*[contains(@class, 'alert--success')]"));
	//	}
		
	//		public void waitUntilElementNotPresent() {
	//			wait.until(ExpectedConditions.attributeContains(getNotification(), "hidden", "hidden"));
	//			System.out.println("Element vise nije prisutan.");
		// Gornji element je zamenjen ovim ispod
		
		public void waitUntilElementNotPresent() {
			wait.until(ExpectedConditions.attributeContains(By.xpath("//*[contains(@class, 'system_message')]"), "style",
					"display: none;"));
			System.out.println("Element vise nije prisutan.");

	}

	// dobra strana za pomoc,jos googlati...
	// https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/interactions/Actions.html
	
	public void saveProfileChanges() {
		getSaveButton().click();
	}
		
		public void changeAllBasicUserInputs(
				String firstName, String lastName, String address, int phoneNumber,
				int zipCode, String Country, String State, String City)throws InterruptedException {
		this.getFirstName().clear();
		this.getFirstName();
		this.getLastName().clear();
		this.getLastName();
		this.getAddress().clear();
		this.getAddress();
		this.getPhoneNumber().clear();
		this.getPhoneNumber();
		this.getZipCode().clear();
		this.getZipCode();
		Thread.sleep(500);
		this.getCountry().selectByVisibleText(Country);
		Thread.sleep(500);
		this.getState().selectByVisibleText(State);
		Thread.sleep(500);
		this.getCity().selectByVisibleText(City);
		getSaveButton().click();
		
		
		}
		
	}
