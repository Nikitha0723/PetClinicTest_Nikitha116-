package com.petclinic.test.jbehave.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

public class PetClinicSteps {

	static Logger logger = Logger.getLogger(PetClinicSteps.class);

	WebDriver driver = new ChromeDriver();

	public void userGivesTheValidUrl() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "//src//test//resources//drivers//chromedriver.exe");
		driver.navigate().to("http://localhost:8080/");
		driver.manage().window().maximize();
	}

// This method is to create owner
	
	public void createNewOwner() {
		driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[3]/a/span[2]")).click();
		logger.info("Owner Page Loaded");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.findElement(By.xpath("/html/body/div/div/a")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Nikitha");
		driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Tanneru");
		driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("Reem");
		driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("AbuDhabi");
		driver.findElement(By.xpath("//*[@id=\"telephone\"]")).sendKeys("0587777777");
		driver.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[2]/div/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		logger.info("Owner Created");
	}

// This is method is to add pet for owner

	public void createPetForOwner() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.findElement(By.xpath("/html/body/div/div/a[2]")).click();
		driver.findElement(By.id("name")).sendKeys("snoopi");
		driver.findElement(By.id("birthDate")).sendKeys("2016-12-23");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button")).click();
		logger.info("Pet is Created");
	}
	
// This method is to send invalid owner information
	
	public void createOwnerWithInvalidData() {
		driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[3]/a/span[2]")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.findElement(By.xpath("/html/body/div/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"telephone\"]")).sendKeys("***");
		driver.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[2]/div/button")).click();
	}
	
// This method is to check error message for invalid contact
	
	public void verifyErrorMessage() {
		WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[1]/div[5]/div/span[2]"));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		logger.info("Error Message :" + errorMessage.getText());
	}

	public void webpageLaunches() {
		WebElement home = driver.findElement(By.id("main-navbar"));
		home.getText();
		logger.info("Home Page Loaded");
	}

// This method is used to verify Image
	
	public void verifyImageOnHomepage(String expectedResult, String ActualResult)
	{  
		String expectedImage="http://localhost:8080/resources/images/pets.png";
		WebElement homeImage = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/img"));
		String actualImgage = homeImage.getAttribute("src");
		assertEquals(actualImgage, expectedImage);
		logger.info("Expected Image Loaded on Webpage");
		 
	}

//  This method is used to verify all verifyVeterinarians

	public void verifyVeterinarians() {

		driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[4]/a/span[2]")).click();
		List<WebElement> veterinariansCount = driver.findElements(By.xpath("//table[@id='vets']//tr/td[1]"));
		logger.info("Total Veterinarians count : " + veterinariansCount.size());
		java.util.Iterator<WebElement> names = veterinariansCount.iterator();
		while (names.hasNext()) {
			WebElement eachName = names.next();
			logger.info("Available Veterinarian :" + eachName.getText());
		}
	}
	
	public void ownerPage() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "//src//test//resources//drivers//chromedriver.exe");
		driver.navigate().to("http://localhost:8080/owners");
	}

	public void ownerPageDisplay() {
		driver.findElement(By.xpath("/html/body/div/div/h2")).isDisplayed();
	}

//  This method is used to verify all owners

	public void verifyAllOwners() {
		List<WebElement> ownerNames = driver.findElements(By.xpath("//table[@id='owners']//tr/td[1]/a"));
		logger.info("Total Owners count : " + ownerNames.size());
		java.util.Iterator<WebElement> names = ownerNames.iterator();

		while (names.hasNext()) {
			WebElement eachName = names.next();
			logger.info("Available Owner : " + eachName.getText());

		}
	}

//	This method is used to validate owner and pet information

	public void validateOwner() {
		driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[3]/a/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("tanneru");
		driver.findElement(By.xpath("//*[@id=\"search-owner-form\"]/div[2]/div/button")).click();
		
		WebElement name = driver.findElement((By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td/b")));
		WebElement add = driver.findElement((By.xpath("/html/body/div/div/table[1]/tbody/tr[2]/td")));
		WebElement city = driver.findElement((By.xpath("/html/body/div/div/table[1]/tbody/tr[3]/td")));
		WebElement telephone = driver.findElement((By.xpath("/html/body/div/div/table[1]/tbody/tr[4]/td")));
		WebElement pet = driver.findElement((By.xpath("/html/body/div/div/table[2]/tbody/tr/td[1]/dl/dd[1]")));
		WebElement petType = driver.findElement((By.xpath("/html/body/div/div/table[2]/tbody/tr/td[1]/dl/dd[3]")));
          
		assertTrue("Incorrect Name", name.getText().equals("Nikitha Tanneru"));
		assertTrue("Incorrect Address", add.getText().equals("Reem"));
		assertTrue("Incorrect City", city.getText().equals("AbuDhabi"));
		assertTrue("Incorrect Telephone", telephone.getText().equals("0587777777"));
		assertTrue("Incorrect PetName", pet.getText().equals("snoopi"));
		assertTrue("Incorrect PetType", petType.getText().equals("bird"));
		
	}
	
	public void closeTheBrowser() {
		driver.quit();
	}

}