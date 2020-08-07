package tableArrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class mapofMap {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://www.way2automation.com/angularjs-protractor/webtables/ ");
	driver.manage().window().maximize();
	
	int rowSize=driver.findElements(By.xpath("//table[@table-title='Smart Table example']//tbody//tr")).size();
	int colSize=driver.findElements(By.xpath("//table[@table-title='Smart Table example']//thead//tr//th")).size();
	
	
	
	Map<Integer, Map<String, String>> map=new HashMap<Integer, Map<String,String>>();
	
	Map<String, String> child=new HashMap<String, String>();
	
	for(int rowNumber=1;rowNumber<=rowSize;rowNumber++) {
		
		for(int colNumber=1;colNumber<=colSize;colNumber++) {
			
			boolean flag=true;
			boolean headerFlag=true;
			try {
				driver.findElement(By.xpath("//table[@table-title='Smart Table example']//tbody//tr["+rowNumber+"]//td["+colNumber+"]"));
			}catch(Exception e) {
				flag=false;
			}
			
			try {
				driver.findElement(By.xpath("//table[@table-title='Smart Table example']//thead//th["+colNumber+"]//span"));
			}catch(Exception e) {
				headerFlag=false;
			}
			
			if(flag&&headerFlag) {
				String header=driver.findElement(By.xpath("//table[@table-title='Smart Table example']//thead//th["+colNumber+"]//span")).getText();
				String rowValue=driver.findElement(By.xpath("//table[@table-title='Smart Table example']//tbody//tr["+rowNumber+"]//td["+colNumber+"]")).getText();
				child.put(header, rowValue);
			}
			
			
		}
		
		
		map.put(rowNumber, child);
		child=new HashMap<String, String>();
	}
	
	
	System.out.println(map);
	
	System.out.println(map.get(1));
}
}
