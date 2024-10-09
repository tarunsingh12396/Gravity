package test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class MobileApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "OnePlus AC2001");
		capabilities.setCapability("platformname", "Android");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("platformversion", "12");

		capabilities.setCapability("appPackage", "com.oneplus.calculator");
		capabilities.setCapability("appActivity", "com.oneplus.calculator.Calculator");

		URL url = URI.create("http://127.0.0.1:4723/").toURL();

		AndroidDriver driver = new AndroidDriver(url, capabilities);
		Thread.sleep(5000);
		System.out.println("Application Started");

		WebElement num8 = driver.findElement(By.id("com.oneplus.calculator:id/digit_8"));
		num8.click();

		WebElement plus = driver.findElement(By.id("com.oneplus.calculator:id/op_add"));
		plus.click();

		WebElement num2 = driver.findElement(By.id("com.oneplus.calculator:id/digit_2"));
		num2.click();

		WebElement equal = driver.findElement(By.id("com.oneplus.calculator:id/eq"));
		equal.click();

		WebElement result = driver.findElement(By.id("com.oneplus.calculator:id/result"));
		String resultString = result.getText();

		if (resultString.equals("10")) {
			System.out.println("Pass");
		} else {
			System.out.println("fail");
		}

		driver.quit();

	}

}