package tableArrayList;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MapTable2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
		HashMap<String, String> map=new HashMap<String, String>();
		int colsize=driver.findElements(By.xpath("//table//thead//th")).size();
		for(int i=1;i<=colsize;i++)
		{
			boolean flag=true;
			try
			{
				driver.findElement(By.xpath("//table//thead//th["+i+"]//span"));
			}
			catch(Exception e)
			{
				flag=false;
			}
			if(flag==true)
			{
			String header=driver.findElement(By.xpath("//table//thead//th["+i+"]//span")).getText();
			String colthree=driver.findElement(By.xpath("//table[@table-title=\"Smart Table example\"]//tbody//tr[3]//td["+i+"]")).getText();
		
		map.put(header, colthree);
		}
	}
		System.out.println(map.get("First Name"));
	}
	

}
