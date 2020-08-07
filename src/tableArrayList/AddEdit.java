package tableArrayList;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddEdit {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
		driver.manage().window().maximize();
		click(By.xpath("//button[@class='btn btn-link pull-right']"));
		sendkeys(By.xpath("//input[@name='FirstName']"), "TestN");
		sendkeys(By.xpath("//input[@class='ng-pristine ng-valid' and @name='LastName']"), "TestNN");
		sendkeys(By.xpath("//input[@class='ng-pristine ng-invalid ng-invalid-required' and @name='UserName']"), "TestNNN");
		sendkeys(By.xpath("//input[@type='password']"), "TestNNNN");
		click(By.xpath("//label[text()='Company AAA']"));
		Select sc=new Select(driver.findElement(By.name("RoleId")));
		sc.selectByIndex(1);
		sendkeys(By.name("Email"), "TestNNNNN@gmail.com");
		sendkeys(By.name("Mobilephone"), "9999922233");
		click(By.xpath("//button[contains(text(),'Save')]"));
		//int rowsize=driver.findElements(By.xpath("//table[@class=\"smart-table table table-striped\"]//tbody//tr")).size();
		//int colsize=driver.findElements(By.xpath("//table[@class=\"smart-table table table-striped\"]//thead//th")).size();
		AddEdit ae=new AddEdit();
		//int testnnncolnum=ae.findcolumnnumber("TestNNN");
		System.out.println(ae.identifyrownumber("TestNNN"));
	}
	public int identifyrownumber(String coldataname)
	{
		int rownum=0;
		try
		{
		
		int testnnncolnum=findcolumnnumber("User Name");
		List<String> li=new ArrayList<String>();
		
		
		int rowsize=driver.findElements(By.xpath("//table[@table-title='Smart Table example']//tbody//tr")).size();
		for(int j=1;j<=rowsize;j++)
		
		{
		
		li.add(driver.findElement(By.xpath("//table[@table-title='Smart Table example']//tr["+j+"]//td["+testnnncolnum+"]")).getText());
		}
		for(int k=0;k<=li.size();k++)
		{
			if(li.get(k).equals(coldataname))
			{
			rownum=k+1;	
			click(By.xpath("//table[@class=\"smart-table table table-striped\"]//tbody//tr[1]//button[1]"));
			Thread.sleep(3000);
			click(By.xpath("//button[@class=\"btn btn-success\"]"));
			}
		}
		
		
		}
		catch(Exception e)
		{
			
		}
		return rownum;
			
	}
	public int findcolumnnumber(String headername)
	{
	int colnum=0;
	try
	{
		int colSize=driver.findElements(By.xpath("//table[@table-title='Smart Table example']//thead//tr//th")).size();	
		for(int i=1;i<=colSize;i++)
		{
			
		
	
		
		boolean flag=isElementPresent(By.xpath("//table[@table-title='Smart Table example']//thead//tr//th["+i+"]"));
		if(flag)
		{
			
			String header=driver.findElement(By.xpath("//table[@table-title='Smart Table example']//thead//tr//th["+i+"]")).getText();
			
			if(header.equals(headername))
			{
				colnum=i;
			}
		}
		}
	
		
	}	
	
	catch(Exception e)
	{
	}
	return colnum;
	}
public boolean isElementPresent(By xpath)
{
	try
	{
		driver.findElement(xpath);
		return true;
		
	}
	catch(Exception e)
	{
		return false;
	}
	}
public static void click(By xpath)
{
	driver.findElement(xpath).click();
}
public static void sendkeys(By xpath, String data)
{
	driver.findElement(xpath).sendKeys(data);
}

	}


