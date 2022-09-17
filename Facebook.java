package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.linkText("Create New Account")).click();

		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("fb");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9874561230");
		driver.findElement(By.id("password_step_input")).sendKeys("9874561230");

		WebElement day = driver.findElement(By.id("day"));
		Select dd = new Select(day);
		dd.selectByValue("1");

		WebElement month = driver.findElement(By.id("month"));
		Select mm = new Select(month);
		mm.selectByValue("8");

		WebElement year = driver.findElement(By.id("year"));
		Select yy = new Select(year);
		yy.selectByValue("1994");

		driver.findElement(By.xpath("//label[contains(text(),'Female')]")).click();
		driver.close();

	}

}
