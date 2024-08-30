package practice_Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Shopperstack_task2 {
	@Test
	public void Task() throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("https://shoppersstack.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		Random random=new Random();
		int randomNum = random.nextInt(9);
		driver.findElement(By.id("loginBtn")).click();
		
		String firstName=getDataFromExcelFile("Shoperstack", 1,0);
		String lastName=getDataFromExcelFile("Shoperstack", 1,1);
		String phoneNumber=getDataFromExcelFile("Shoperstack", 1,2);
		String emailAddress=getDataFromExcelFile("Shoperstack", 1,3);
		String password=getDataFromExcelFile("Shoperstack", 1,4);
		String confirmPassword=getDataFromExcelFile("Shoperstack", 1,5);	
		
		driver.findElement(By.id("Email")).sendKeys("chandu78@gmail.com");
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Women']")).click();
		driver.findElement(By.xpath("//span[text()='FOREVER 21  Casual Regular Sleeves ...']/../..//button[contains(@class,'css-k58djc')]")).click();
		driver.findElement(By.id("cartIcon")).click();
		driver.findElement(By.xpath("//span[text()='Buy Now']")).click();
		driver.findElement(By.xpath("//span[text()='Add New Address']")).click();
		driver.findElement(By.id("Name")).sendKeys(firstName);
		driver.findElement(By.id("House/Office Info")).sendKeys("231");
		driver.findElement(By.id("Street Info")).sendKeys("hebbal");
		driver.findElement(By.id("Landmark")).sendKeys("Balmuri Temple");
		driver.findElement(By.id("Pincode")).sendKeys("571234");
		driver.findElement(By.id("Phone Number")).sendKeys("9972623269");
		WebElement countryDropdown = driver.findElement(By.id("Country"));
		WebElement stateDropdown = driver.findElement(By.id("State"));
		WebElement cityDropdown = driver.findElement(By.id("City"));


		selectByValue(countryDropdown, "India");
		selectByValue(stateDropdown, "Karnataka");
		selectByValue(cityDropdown, "Bengaluru");
		driver.findElement(By.id("addAddress")).click();
		driver.findElement(By.id("52041")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String time=LocalDateTime.now().toString().replace(':','-');
		FileUtils.copyFile(srcFile, new File("./screenshot/registerPage"+time+".png"));
		Thread.sleep(5000);



	}

	public String getDataFromExcelFile(String sheetName,int rowNum,int cellNum) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("./TestData/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;		
	}

	public void selectByValue(WebElement element,String value) {
		Select select =new Select(element);
		select.selectByValue(value);
	}

}



