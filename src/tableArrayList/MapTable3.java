package tableArrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MapTable3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
		driver.manage().window().maximize();
		
		
		int rowsize=driver.findElements(By.xpath("//table[@table-title=\"Smart Table example\"]//tbody//tr")).size();
		int colsize=driver.findElements(By.xpath("//table[@table-title=\"Smart Table example\"]//thead//th")).size();
		List<String> li=new ArrayList<String>();
		Map<Integer, List<String>> map= new HashMap<Integer, List<String>>();
		for(int rownum=1;rownum<=rowsize;rownum++)
		{
			for(int colnum=1;colnum<=colsize;colnum++)
			{
				boolean flag=true;
				try
				{
					driver.findElement(By.xpath("//table[@table-title='Smart Table example']//tbody//tr["+rownum+"]//td["+colnum+"]"));
				}
				catch(Exception e)
				{
					flag=false;
				}
				if(flag)
				{
				li.add(driver.findElement(By.xpath("//table[@table-title='Smart Table example']//tbody//tr["+rownum+"]//td["+colnum+"]")).getText());
				}
			}
				map.put(rownum, li);
				li=new ArrayList<String>();
				
		}
			System.out.println(map);
			System.out.println(map.get(1));
		

	}

}
