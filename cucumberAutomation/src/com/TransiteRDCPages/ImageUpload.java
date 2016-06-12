package com.TransiteRDCPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ImageUpload {
	
	static String fimage = "C:\\Users\\fvf767\\Desktop\\Personal\\Checks For Automation\\$160.06_Front.jpg";
	
	static String bimage = "C:\\Users\\fvf767\\Desktop\\Personal\\Checks For Automation\\Back.jpg";
			
	public static  WebDriver transiteImageUpload(WebDriver driver,String amount, String accountnumber, String Memo) throws Exception {
	
		driver.findElement(By.xpath("//*[@id='tab_Transfer Money']/span")).click();
		
		driver.findElement(By.xpath("//*[@id='tab_mega_UploadCheck']")).click();
			
		driver.findElement(By.id("amount")).sendKeys(amount);
		
		driver.findElement(By.xpath("//*[@id='accountNumber']")).sendKeys("360 Checking");
		
		driver.findElement(By.id("memo")).sendKeys("ImageUpload");
		
		driver.findElement(By.xpath("//*[@id='PageForm']/div[3]/div/div/span/a")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='lb_modalContinue']/a")).click();
		
		Liabrary.Utility.robotClass(driver, "Check Info Entered Successfully");
	
		driver.findElement(By.id("frontFile")).sendKeys(fimage);
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("backFile")).sendKeys(bimage);
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("continueButton")).click();
					
		return driver;
			
	}
	
}