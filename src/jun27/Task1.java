package jun27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task1 {
	static WebDriver driver;

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("http://www.way2automation.com/angularjs-protractor/webtables/ ");
		driver.manage().window().maximize();
		click(By.xpath("//button[@class='btn btn-link pull-right']"));
		sendkey((By.xpath("//input[@name='FirstName']")), "test");
		sendkey((By.xpath("//input[@name='LastName']")), "test11");
		sendkey((By.xpath("//input[@name='UserName']")), "test111");
		sendkey((By.xpath("//input[@name='Password']")), "testing");
        click(By.xpath("//label[text()='Company AAA']"));
        Select sc=new Select(driver.findElement(By.name("RoleId")));
        sc.selectByIndex(1);
        sendkey((By.name("Email")), "asd@gmail.com");
        sendkey((By.name("Mobilephone")), "1234567");
        click(By.xpath("//div/button[text()='Save']"));
        
        
        
        
        //rbtn.click();
        
        //System.out.println(rbtn.isSelected());
         
	}
	public static void click(By xpath)
	{
	driver.findElement(xpath).click();
	}
	public static void sendkey(By xpath, String data)
	{
		driver.findElement(xpath).sendKeys(data);
		//return data;
	}

}
