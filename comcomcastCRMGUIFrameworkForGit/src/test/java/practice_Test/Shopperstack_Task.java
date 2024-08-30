package practice_Test;

import java.awt.Desktop.Action;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Shopperstack_Task {

	@Test
	public void Task() throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("https://shoppersstack.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		Random random=new Random();
		int randomNum = random.nextInt(9);
		driver.findElement(By.id("loginBtn")).click();
		driver.findElement(By.xpath("//span[text()='Create Account']")).click();
		String firstName=getDataFromExcelFile("Shoperstack", 1,0);
		String lastName=getDataFromExcelFile("Shoperstack", 1,1);
		String phoneNumber=getDataFromExcelFile("Shoperstack", 1,2);
		String emailAddress=getDataFromExcelFile("Shoperstack", 1,3);
		String password=getDataFromExcelFile("Shoperstack", 1,4);
		String confirmPassword=getDataFromExcelFile("Shoperstack", 1,5);

		driver.findElement(By.id("First Name")).sendKeys(firstName);
		driver.findElement(By.id("Last Name")).sendKeys(lastName);
		driver.findElement(By.id("Female")).click();
		driver.findElement(By.id("Phone Number")).sendKeys(phoneNumber+randomNum);
		driver.findElement(By.id("Email Address")).sendKeys(emailAddress+randomNum+"@gmail.com");
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("Confirm Password")).sendKeys(confirmPassword);
		driver.findElement(By.id("Terms and Conditions")).click();
		driver.findElement(By.id("btnDisabled")).click();
		Thread.sleep(2000);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String time=LocalDateTime.now().toString().replace(':','-');
		FileUtils.copyFile(srcFile, new File("./screenshot/registerPage"+time+".png"));
		

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
