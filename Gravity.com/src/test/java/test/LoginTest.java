package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/");

		WebElement username = driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
		username.sendKeys("standard_user");

		WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		password.sendKeys("secret_sauce");

		WebElement login = driver.findElement(By.xpath("//input[@id=\"login-button\"]"));
		login.click();

		String expected_title = "Swag Labs";
		String actual_title = driver.getTitle();

		if (expected_title.equals(actual_title)) {
			System.out.println("Login Successful");

		} else {
			System.out.println("Login Failed");
		}
		
		driver.quit();

	}

}
