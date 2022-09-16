package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://leaftaps.com/opentaps/");
		driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("987");
		WebElement fID = driver
				.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext']"));

		String ID = fID.getText();
		// Click First Resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext']"))
				.click();
		// Click Delete
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		// find lead
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		// pass the lead id
		driver.findElement(By.xpath("//label[contains(text(),'Lead ID:')]/following::input[1]")).sendKeys(ID);

		driver.findElement(
				By.xpath("//div[@class='x-panel-footer x-panel-footer-noborder']//td[@class='x-panel-btn-td']"))
				.click();
		WebElement value = driver
				.findElement(By.xpath("//div[@class='x-toolbar x-small-editor']//div[@class='x-paging-info']"));
		String op = value.getText();
		System.out.println(op);
		if (op.contains("No records to display")) {
			System.out.println("Lead deleted successfully");
		} else {
			System.out.println("Lead not deleted");
		}

	}

}
