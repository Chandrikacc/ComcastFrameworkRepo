package Practice_DataProvider;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import comComCastCRMGenericFileUtility.ExcelUtility;

public class GetProdInfoFromExcelUsingDataProvider_Test {
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
	public Object[][] getData() throws IOException, Throwable{
		ExcelUtility elib=new ExcelUtility();
		int rowCount=elib.getRowCount("Product");
		int cellCOunt=elib.getCellCount("Product");
		Object[][] objArr=new Object[rowCount][2];
		for(int i=0;i<rowCount;i++) {
			objArr[i][0]=elib.getDataFromExcelFile("product", i+1, 0);
			objArr[i][1]=elib.getDataFromExcelFile("product", i+1, 1);
		}
			return objArr;
		
	}

}

