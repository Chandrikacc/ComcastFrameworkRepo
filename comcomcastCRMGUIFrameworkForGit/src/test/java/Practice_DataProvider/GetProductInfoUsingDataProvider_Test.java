package Practice_DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfoUsingDataProvider_Test {
	@Test(dataProvider = "getData")
	public void getProductInfo_Test(String brandName,String productName) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys(brandName,Keys.ENTER);
		String price=driver.findElement(By.xpath("//div[text()='"+productName+"']/../..//div[@class='Nx9bqj _4b5DiR']")).getText();	
		System.out.println(price);
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr=new Object[3][2];
		objArr[0][0]="iphone";
		objArr[0][1]="Apple iPhone 12 (Blue, 64 GB)";
		objArr[1][0]="iphone";
		objArr[1][1]="Apple iPhone 15 (Black, 128 GB)";
		objArr[2][0]="iphone";
		objArr[2][1]="Apple iPhone 14 Plus (Starlight, 128 GB)";
				
		return objArr;
		
	}

}
