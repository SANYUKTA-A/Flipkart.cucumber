package Flipkart.maven.Flipkart.maven;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestListener;

public class Flipkart_baseclass implements ITestListener {
	/* Interface Class */
	public static WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public static Actions action;



	/*All Xpath List*/
	//1 -> Login Element Xpath List
	String usernameL = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input";
	String passwordL = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input";
	String loginBtnL = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button";
	
	//2 -> Header Menu Xpath list
	String Electronics = "//*[@id=\"container\"]/div/div[2]/div/ul/li[1]/span";
	String Elec_mi = "/html/body/div/div/div[2]/div/ul/li[1]/ul/li/ul/li[1]/ul/li[2]/a";
	
	//Mobile Xpath List
	String K20pro = "//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]";
	String pic2 = "//*[@id=\"swatch-1-color\"]/a/div";
	String Buynow = "//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[2]/form/button";
	
	//afetr buy now details
	String Name = "//*[@id=\"container\"]/div/div[2]/div/div[1]/div[2]/div/div/div/div/div/label/div[2]/div/form/div/div[2]/div[1]/input";
	String MobNo = "//*[@id=\"container\"]/div/div[2]/div/div[1]/div[2]/div/div/div/div/div/label/div[2]/div/form/div/div[2]/div[2]/input";
	String Pincod = "//*[@id=\"container\"]/div/div[2]/div/div[1]/div[2]/div/div/div/div/div/label/div[2]/div/form/div/div[3]/div[1]/input";
	String Locality = "//*[@id=\"container\"]/div/div[2]/div/div[1]/div[2]/div/div/div/div/div/label/div[2]/div/form/div/div[3]/div[2]/input";
	
	//Select Baby and kids product
	String Babynkids = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[5]/span[1]";
	String RCT = "//a[contains(text(),'Remote Control Toys')]";
	String Miniracecar = "//div[@class='_1HmYoV _35HD7C']//div[2]//div[1]//div[3]//div[1]//a[1]//div[1]//div[1]//div[1]";
	String addtocrt = "//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button";
	
    // Search Nike shoes
	String search1 = "//input[@placeholder='Search for products, brands and more']";
	String Price = "//*[@id=\"container\"]/div/div[3]/div[2]/div/div[1]/div/div/div/section[2]/div[4]/div[3]/select";
	String Threek = "//div[@class='_1YoBfV']//option[5]";
	String Nikeshoes = "//div[@class='_1HmYoV _35HD7C']//div[2]//div[1]//div[4]//div[1]//a[1]//div[1]//div[1]//div[1]//div[1]";
	String AddNike = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/button[1]";
	String Size = "//*[@id=\"swatch-0-size\"]";
	
	//place all orders
	String PlaceOrder = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/form[1]/button[1]/span[1]";
	String PC = "//input[@name='pincode']";



	/*user Data List*/
	String usernameD = "sanyuktaamberkar@gmail.com";
	String passwordD ="Sanyukta1996";
	String username = "Sanyukta";
	
	//Buy now details
	String Number = "8169928289";
	String PinNum = "400093"; 
	String Location = "Mumbai";
	
	//Nike shoes search data
	String Searchdata1 = "Nikeshoes";
	/*Actions Methods*/

	public void ActionMouseOver(String XPath) throws InterruptedException {
		Thread.sleep(4000);
		action = new Actions(driver);
		WebElement element  = driver.findElement(By.xpath(XPath));
		action.moveToElement(element).build().perform();
		Thread.sleep(4000);
	}

	public void ActionMouseClick(String XPath) throws InterruptedException {
		Thread.sleep(4000);
		action = new Actions(driver);
		WebElement element  = driver.findElement(By.xpath(XPath));
		action.moveToElement(element).click().perform();
		Thread.sleep(4000);
	}


	@BeforeTest
	public void launch () throws Exception {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito","--disable-notifications");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		// -> Login Pop Handling----------------------------------------------
		// Step1- Collect windows
		Set<String> mainwindow = driver.getWindowHandles();

		// Setp2- Collect all windows for interations
		Iterator<String> iterator = mainwindow.iterator();

		// Step3- Focus from mainwindow to child window		
		String childWin = iterator.next();

		// Step4- focuses driver on child window
		driver.switchTo().window(childWin);
		//--------------------------------------------------------------------

		// Now Handles Elements-----------------------------------------------
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); 
		WebElement username = driver.findElement(By.xpath(usernameL));
		username.clear();
		username.sendKeys(usernameD);

		WebElement password = driver.findElement(By.xpath(passwordL));
		password.clear();
		password.sendKeys(passwordD);

		WebElement loginClk = driver.findElement(By.xpath(loginBtnL));
		loginClk.click();
		//-------------------------------------------------------------------



		// Extent Report Desgining-------------------------------------------
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
		// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Flipkart");
		extent.setSystemInfo("Environment", "TestPortal");
		extent.setSystemInfo("User Name", "Sanyukta");
		htmlReporter.config().setDocumentTitle("Flipkart Test Report ");
		// Name of the report
		htmlReporter.config().setReportName(" Test Execution Report ");
		// Dark Theme
		htmlReporter.config().setTheme(Theme.DARK);	
		//--------------------------------------------------------------------

	}

	//This method is to capture the screenshot and return the path of the screenshot.
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case is successfully pass: "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case is failed due to some error: "+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case is skipped due null exception: "+result.getName());
	}
	@AfterTest
	public void Close() throws Exception {

		extent.flush();
		driver.quit();
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception{
		if(result.getStatus() == ITestResult.FAILURE){
			//MarkupHelper is used to display the output in different colors
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
			//We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.
			//String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
			String screenshotPath = getScreenShot(driver, result.getName());
			//To add it in the extent report
			logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
		}
		else if(result.getStatus() == ITestResult.SKIP){
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" - Test Case PASSED", ExtentColor.GREEN));
		}

		Thread.sleep(3000);

	}
}

