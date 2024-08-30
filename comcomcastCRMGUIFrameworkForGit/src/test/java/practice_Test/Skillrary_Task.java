package practice_Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

public class Skillrary_Task {
	@Test
	public void login() throws InterruptedException, Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoapp.skillrary.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().window().maximize();
		driver.findElement(By.linkText("LOGIN")).click();
		driver.findElement(By.id("email")).sendKeys("chanduchondira@gmail.com");
		driver.findElement(By.id("password")).sendKeys("user");
		driver.findElement(By.id("last")).click();
		//driver.findElement(By.linkText("SIGNUP")).click();
		driver.findElement(By.name("firstname")).sendKeys("Chandrika");
		
		driver.findElement(By.name("lastname")).sendKeys("Kaspadi");
		Thread.sleep(3000);
		
	
		driver.findElement(By.name("password")).sendKeys("user");
		driver.findElement(By.name("repassword")).sendKeys("user");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		
	}
	

}
