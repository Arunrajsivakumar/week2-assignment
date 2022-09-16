package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String name = "Hemalatha";
		String companyname = "change";

		driver.get("http://leaftaps.com/opentaps/");
		driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(name);
		// click find leads
		driver.findElement(
				By.xpath("//div[@class='x-panel-footer x-panel-footer-noborder']//td[@class='x-panel-btn-td']"))
				.click();
		Thread.sleep(2000);
		// Click on first resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))
				.click();
		// Verify title of the page
		if (driver.getTitle().contains("View Lead")) {
			System.out.println("Title verified successfully");
		} else {
			System.out.println("Title not verified");
		}
		// Click Edit
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
		// Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyname);
		// click update
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		// Confirm the changed name appears
		WebElement retrive = driver.findElement(By.id("viewLead_companyName_sp"));
		String value = retrive.getText();
		if (value.contains(companyname)) {
			System.out.println("Changed name is confirmed ");

		} else {
			System.out.println("changed name is not confirmed ");
		}
			driver.close();
	}

}
