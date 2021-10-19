package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		
		locationPopupPage = new LocationPopupPage(driver, wait);
		loginPage = new LoginPage(driver, wait);
		profilePage = new ProfilePage(driver, wait);
		
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(2500);
		//driver.quit();
		//driver.close();
	}
}
