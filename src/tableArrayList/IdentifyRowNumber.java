package tableArrayList;

//import java.awt.List;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IdentifyRowNumber {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.way2automation.com/angularjs-protractor/webtables/ ");
		driver.manage().window().maximize();
		
		IdentifyRowNumber ob=new IdentifyRowNumber();
		System.out.println(ob.identifyRowNumber("novak"));
		
	}

	public int identifyRowNumber(String colDataName) {
		int rowNum=0;
		try {
			int useNameColNumber=identifyColNumber("User Name");
			List<String> colData=new ArrayList<String>();
			int rowSize=driver.findElements(By.xpath("//table[@table-title='Smart Table example']//tbody//tr")).size();
			for(int i=1;i<=rowSize;i++) {
				colData.add(driver.findElement(By.xpath("//table[@table-title='Smart Table example']//tr["+i+"]//td["+useNameColNumber+"]")).getText());
			}
			
			for(int i=0;i<colData.size();i++) {
				if(colData.get(i).equals(colDataName)) {
					rowNum=i+1;
				}
			}
		}catch(Exception e) {
			
		}
		return rowNum;
	}

	public int identifyColNumber(String headerName) {
		int coluNum=0;
		try {
			int colSize=driver.findElements(By.xpath("//table[@table-title='Smart Table example']//thead//tr//th")).size();
			for(int col=1;col<=colSize;col++) {
				boolean flag=isElementPresent(By.xpath("//table[@table-title='Smart Table example']//thead//tr//th["+col+"]"));
				if(flag) {
					String header=driver.findElement(By.xpath("//table[@table-title='Smart Table example']//thead//tr//th["+col+"]")).getText();
					if(header.equals(headerName)) {
						coluNum=col;
					}
				}
			}
			//table[@table-title='Smart Table example']//th//span
		}catch(Exception e) {
			
		}
		
		return coluNum;
	}

	public boolean isElementPresent(By xpath) {
		try {
			driver.findElement(xpath);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	

	
		public static int rowcolsize(By xpath)
		{
			return driver.findElements(xpath).size();
		}
		

	}

	


