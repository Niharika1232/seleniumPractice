package tableArrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListMap {
	static String rowname;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.way2automation.com/angularjs-protractor/webtables");
		driver.manage().window().maximize();
		int rowsize=driver.findElements(By.xpath("//table[@table-title='Smart Table example']//tbody//tr")).size();
		int colsize=driver.findElements(By.xpath("//table//thead//th")).size();
		List<String> li=new ArrayList<String>();
		Map<String, List<String>> map=new HashMap<String, List<String>>();
		//String rowname = null;
		
			for(int colnum=1;colnum<=colsize;colnum++)
			{
				for(int rownum=1;rownum<=rowsize;rownum++){
				boolean headFlag=true;
				boolean flag=true;
				//boolean headFlag=true;
				try
				{
					driver.findElement(By.xpath("//table[@table-title='Smart Table example']//tbody//tr["+rownum+"]//td["+colnum+"]"));
				}
				catch(Exception e)
				{
					flag=false;
				}
				try {
					driver.findElement(By.xpath("//table//thead//th["+colnum+"]//span"));
				}
				catch(Exception e) {
					headFlag=false;
				}
				if(flag&&headFlag)
				{
			
									
				  rowname=driver.findElement(By.xpath("//table//thead//th["+colnum+"]//span")).getText();
				li.add(driver.findElement(By.xpath("//table[@table-title='Smart Table example']//tbody//tr["+rownum+"]//td["+colnum+"]")).getText());
				}
				
			}
			
				map.put(rowname, li);
			li=new ArrayList<String>();
			
			
		}
		//System.out.println(map.get(1));
		//System.out.println(map.get(2));
		//System.out.println(map.get(3));
		
System.out.println(map.get("First Name"));
System.out.println(map.get("Last Name"));
	}

}
