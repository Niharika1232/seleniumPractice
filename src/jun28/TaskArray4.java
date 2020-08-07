package jun28;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskArray4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/accessing-nested-table.html");
		ArrayList<String> temp=new ArrayList();
		
		List<WebElement> row=driver.findElements(By.xpath("//table//tbody//tr"));
		int rowsize=row.size();
		for(int i=1;i<=rowsize;i++)
		{
			List<WebElement> col=row.get(i).findElements(By.tagName("td"));
			int colsize=col.size();
			
		
			for(int j=1;j<=colsize;j++)
			{
				String celltext=col.get(j).getText();
				temp.add("celltext");
				
			}
		}
		for(String s:temp)
		{
			System.out.println(s);
		}
	}

}
