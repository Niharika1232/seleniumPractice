package tableArrayList;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MapTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.way2automation.com/angularjs-protractor/webtables/ ");
		driver.manage().window().maximize();
		//String i=driver.findElement(By.xpath("//table[@table-title=\"Smart Table example\"]//thead//tr[3]//th[1]//span")).getText();
		//System.out.println(i);
		HashMap<String, String> map=new HashMap<String, String>();
		int colsize=driver.findElements(By.xpath("//table//thead//th")).size();
		
		for(int i=1;i<=colsize;i++)
		{
			boolean flag=true;
			try {
				driver.findElement(By.xpath("//table//thead//th["+i+"]//span"));
			}
				catch(Exception e)
			{
					flag=false;
			}
			if(flag==true)
			{
			
			String head=driver.findElement(By.xpath("//table//thead//th["+i+"]//span")).getText();
			String colone=driver.findElement(By.xpath("//table[@table-title=\"Smart Table example\"]//tbody//tr[1]//td["+i+"]")).getText();
			map.put(head, colone);
			}
		}
		System.out.println(map.get("First Name"));
		System.out.println(map.get("Last Name"));
		System.out.println(map.size());

	}

}
