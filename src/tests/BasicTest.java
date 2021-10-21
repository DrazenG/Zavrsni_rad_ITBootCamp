package tests;

import java.io.File;
import java.nio.file.Files;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.FactoryUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;

public abstract class BasicTest {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	
	// Pages - Stranice koje se unose i povezuju na package "Pages" klikom na njih u okviru menija
	
	protected LocationPopupPage locationPopupPage;
	protected LoginPage loginPage;
	protected NotificationSystemPage notificationSystemPage;
	protected CartSummaryPage cartSummaryPage;
	protected MealPage mealPage;
	protected ProfilePage profilePage;
	protected AuthPage authPage;

	// URL-ovi / linkovi koje koristimo za testove tj njihove adrese stranica
	
	protected String baseUrl = "https://demo.yo-meals.com/";
	protected String loginPageUrl = "https://demo.yo-meals.com/guest-user/login-form";
	protected String profilePageUrl = "https://demo.yo-meals.com/member/profile";
	
	// Login Data - podaci za logovanje korisnika
	
	protected String username = "customer@dummyid.com";
	protected String password = "12345678a";
	
	// Profile image Path - putanja za pristup profilnoj slici
	
	protected String profilePicturePath = "\\img\\Slika.jpg";
	
	// Beforemethod i ispod njega su postavke za rad sa drajverima, implicitnim i explicitnim(waiter) cekanjima,
	//kao i uvecanjem stranice kod otvaranja ali i cekanjem da se otvori prilikom load-a
	// ispod odvojeno je povezivanje i odnos ka stranicama povezanim u "pages" delu
	
	@BeforeMethod
	
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		Actions actions = new Actions(driver);
		
		locationPopupPage = new LocationPopupPage(driver, wait, js, actions);
		loginPage = new LoginPage(driver, wait, js, actions);
		profilePage = new ProfilePage(driver, wait, js, actions);
		authPage = new AuthPage(driver, wait, js, actions);
		mealPage = new MealPage(driver, wait, js, actions);
		notificationSystemPage = new NotificationSystemPage(driver, wait, js, actions);
		cartSummaryPage = new CartSummaryPage(driver, wait, js, actions);
		//searchResultPage = new SearchResultPage(driver, wait, js, actions);
		//Ovde treba() eventualno, ako se stigne uneti zadnju stavku  i skinuti dve kose crte. 
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws InterruptedException {

		// Za kompletno resenje ovoga su mi trebale neke biblioteke za FILEUTILS koje nisam uspeo da pronadjem... :/
		//Tako da ovo ne radi
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
	
				TakesScreenshot screenshot = (TakesScreenshot) driver;
			
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				
				String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date(0));
				//FileUtils.copyFile(src, new File("screenshots\\" + result.getName() + " - " + timestamp + ".png"));
				System.out.println("Successfully captured a screenshot");
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}
		Thread.sleep(3200);
		driver.quit();

	}
}
