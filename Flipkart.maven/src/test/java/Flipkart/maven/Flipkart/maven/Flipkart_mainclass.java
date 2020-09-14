package Flipkart.maven.Flipkart.maven;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Flipkart.maven.Flipkart.maven.Flipkart_baseclass.class)
public class Flipkart_mainclass extends Flipkart_baseclass{

	@Test(priority =1)
	public void SelectElement() throws Exception {
		logger = extent.createTest("Select Electronics Element");
		ActionMouseOver(Electronics);
		ActionMouseClick(Elec_mi);
		Thread.sleep(3000);

		//	driver.findElement(By.xpath(pic2)).click();
		String Parentwin = driver.getWindowHandle();
		System.out.println("Parentwindoe"+Parentwin);
		driver.findElement(By.xpath(K20pro)).click();
		for (String chindwin:driver.getWindowHandles()) {
			driver.switchTo().window(chindwin);
		}
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/button")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Buynow)).click();
		driver.findElement(By.xpath(Name)).sendKeys(username);
		driver.findElement(By.xpath(MobNo)).sendKeys(Number);
		driver.findElement(By.xpath(Pincod)).sendKeys(PinNum);
		driver.findElement(By.xpath(Locality)).sendKeys(Location);
		driver.navigate().back();
		Thread.sleep(3000);
		ActionMouseOver(Babynkids);
		ActionMouseClick(RCT);

		String Childwin = driver.getWindowHandle();
		System.out.println("childwindow"+Childwin);
		driver.findElement(By.xpath(Miniracecar)).click();
		for(String childtwo : driver.getWindowHandles()) {
			driver.switchTo().window(childtwo);
		}
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath(addtocrt)).click();
		Thread.sleep(3000);     
		driver.findElement(By.xpath(search1)).sendKeys(Searchdata1);
		driver.findElement(By.xpath("//button[@class='vh79eN']//*[local-name()='svg']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Price)).click();
		driver.findElement(By.xpath(Threek)).click();
		Thread.sleep(3000);
		String Childtwo = driver.getWindowHandle();
		System.out.println("shoeswin"+Childtwo);
		driver.findElement(By.xpath(Nikeshoes)).click();
		for(String shoeswin : driver.getWindowHandles()) {
			driver.switchTo().window(shoeswin);
		}
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.findElement(By.xpath(Size)).click();
		driver.findElement(By.xpath(AddNike)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(PlaceOrder)).click();
		driver.findElement(By.xpath(PC)).click();
	}
}

