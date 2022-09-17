package week2.day1;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/input.xhtml");
		driver.findElement(By.id("j_idt88:name")).sendKeys("Arunraj");
//		driver.findElement(By.id("j_idt88:j_idt91")).clear();
		driver.findElement(By.id("j_idt88:j_idt91")).sendKeys(" India");
		Boolean field = driver.findElement(By.id("j_idt88:j_idt93")).isDisplayed();
		System.out.println("check " + field);
		driver.findElement(By.id("j_idt88:j_idt95")).clear();
		WebElement l = driver.findElement(By.id("j_idt88:j_idt97"));
		String val = l.getAttribute("value");
		System.out.println(val);

		driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("test@gnail.com");
		driver.findElement(By.id("j_idt88:j_idt99")).sendKeys(Keys.TAB);
		driver.findElement(By.id("j_idt88:j_idt101")).sendKeys("hi I am here");
		driver.findElement(By.id("j_idt106:thisform:age")).sendKeys(Keys.ENTER);
		String alert = driver.findElement(By.id("//div[@role='alert']")).getText();
		if (alert.equals("Age is mandatory")) {
			System.out.println("verified");
		}
		

	}

}
