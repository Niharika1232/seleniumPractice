package jun28;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
ArrayList<String> temp= new ArrayList<String>();
int rowsize=driver.findElements(By.xpath("//table[@table-title='Smart Table example']//tbody//tr")).size();
int colsize=driver.findElements(By.xpath("//table[@table-title='Smart Table example']//tbody//tr[1]//td")).size();
for(int i=1;i<=rowsize;i++)
{
	
	for(int j=1;j<=colsize;j++)
	{
		temp.add(driver.findElement(By.xpath("//table[@table-title='Smart Table example']//tbody//tr["+i+"]//td["+j+"]")).getText());
		
	}
}
	for(String s:temp)
	{
		System.out.println(s);
	}


	}

}
