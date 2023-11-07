package makemytripporject;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class basecode {
	WebDriver wd;
	Robot bot;
	JavascriptExecutor j;
	WebDriverWait w;
	ExtentReports er;
	ExtentTest extentTest;

	
	@BeforeTest
	public void code1() throws AWTException {

		WebDriverManager.chromedriver().setup();
		wd=new ChromeDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
		 er = new ExtentReports();
	     er.attachReporter(htmlReporter);
		w=new WebDriverWait(wd, 30);
		
	}
	@Test
	public void test1() throws AWTException, InterruptedException {
		ExtentTest test=er.createTest("the first test");
		//Thread.sleep(2000);
		//wd.get("https://www.makemytrip.com/");
		//wd.navigate().refresh();
		//wd.navigate().refresh();
		//wd.navigate().refresh();
	//wd.navigate().refresh();
		//wd.navigate().refresh();
		///T/hread.sleep(1000);
	     //   try {
	         //   WebElement popUp = wd.findElement(By.xpath("//*[@id='webklipper-publisher-widget-container-notification-container']"));
	          //  if (popUp.isEnabled()) {
	              //  wd.findElement(By.xpath("//*[@id='webklipper-publisher-widget-container-notification-close-div']")).click();
	          //  }
	        //} catch (org.openqa.selenium.NoSuchElementException e) {
	            // Pop-up not found, continue
	      //  }
	       // test.pass("popup is disabled");
			
		//wd.findElement(By.linkText("Holiday Packages")).click();
			wd.get("https://www.makemytrip.com/holidays-india");
		test.pass("holiday package is selected");
		wd.navigate().refresh();
					
		Thread.sleep(3000);
		   try {
	            WebElement popUp = wd.findElement(By.xpath("//*[@class='modalContainer']"));
	            if (popUp.isEnabled()) {
	                wd.findElement(By.xpath("//*[@class='primaryBtnWhite border-btn font16 latoBold']")).click();
	            }
	        } catch (org.openqa.selenium.NoSuchElementException e) {
	            // Pop-up not found, continue
	        }
		   test.pass("popup for area is disabled");
	
				
	//selecting bangalore
		wd.findElement(By.xpath("(//*[@class='hdsw_inner']/div)[1]")).click();
		
		wd.findElement(By.xpath("//*[@class='citypicker_input']")).clear();
		wd.findElement(By.xpath("//*[@class='citypicker_input']")).sendKeys("bangalore");
		wd.findElement(By.xpath("//*[@class='searchedCity']/ul/li")).click();
		test.pass("banglore is selected");
				
		//selecting singapore
		wd.findElement(By.xpath("(//*[@class='hdsw_inner']/div)[2]")).click();
		wd.findElement(By.xpath("//*[@class='dest-search-input']")).clear();
		wd.findElement(By.xpath("//*[@class='dest-search-input']")).sendKeys("singapore");
		Thread.sleep(3000);
		wd.findElement(By.xpath("(//*[@class='dest-city-container'])[1]")).click();
		System.out.println("3");
		test.pass("singapore is selected");
		
		wd.findElement(By.xpath("//*[@aria-label='Thu Sep 14 2023']")).click();
		test.pass("date is Selected");
		
		
		wd.findElement(By.xpath("//*[@class='applyBtn']")).click();
		test.pass("the no of people are selected");
		
		wd.findElement(By.xpath("//*[@class='action']")).click();
		test.pass("filters are applied");
		
		wd.findElement(By.id("search_button")).click();
		test.pass("search is initiated");		
		Thread.sleep(1000);
		
		wd.findElement(By.xpath("//*[@class='skipBtn']")).click();
		test.pass("help is skipped");
		Thread.sleep(10000);
		
		   try {
	            WebElement popUp = wd.findElement(By.xpath("//*[@id='modalpopup']"));
	            if (popUp.isEnabled()) {
	            	wd.findElement(By.xpath("//*[@class='close closeIcon']")).click();
	            }
	        } catch (org.openqa.selenium.NoSuchElementException e) {
	            // Pop-up not found, continue
	        }
		
		test.pass("dialouge is closed");
		Thread.sleep(6000);
		JavascriptExecutor JS = (JavascriptExecutor) wd;
         JS.executeScript("window.scrollBy(0,3500)");
         Thread.sleep(3000);
         JS.executeScript("window.scrollBy(0,1500)");
         test.pass("scroll down");
// 
         System.out.println("scroll down");
         wd.findElement(By.xpath("(//*[@class='slick-arrow slick-next '])[3]")).click() ;
	      wd.findElement(By.xpath("(//*[@data-index='4'])[2]")).click() ;
	      test.pass("package is selected");
	      
	      List<String> tabs = new ArrayList<>(wd.getWindowHandles());
	      wd.switchTo().window(tabs.get(tabs.size() - 1));
	      
	      wd.switchTo();
	      wd.navigate().refresh();
	      wd.navigate().refresh();
	      Thread.sleep(3000);
	      test.pass("tab switched and applied");
	      
	      wd.findElement(By.xpath("(//*[@id='change'])[3]")).click();
	      test.pass("intiation to change hotels");
	    Thread.sleep(2000);
	      
	    wd.findElement(By.xpath("(//*[@class='primaryBtn fill selectBtn'])[12]")).click();
	    System.out.println("hotel selected ");
	    Thread.sleep(2000);
	    
	    wd.findElement(By.xpath("//*[@id='updateHotelBtnClick']")).click();
	    System.out.println("changes added to hotel packagge");
	    Thread.sleep(2000);
	    
	    WebElement ScrollTo = wd.findElement(By.xpath("//*[@class='hotel-row highlight ']"));

	 ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", ScrollTo);
	    
	    WebElement hotel1 = wd.findElement(By.xpath("//*[@class='hotel-row-details-title']"));
	    String itineraryHotelInfo = hotel1.getText();
	    System.out.println(itineraryHotelInfo);
	    
	    SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(itineraryHotelInfo, "Hotel Royal @ Queens");
	    test.pass("hotel varification done");

	      
	    wd.findElement(By.xpath("(//*[@class='add-activity-button'])[1]")).click();
	    test.pass("activity addtion intitiated");
	    Thread.sleep(1000);
	    
	    wd.findElement(By.xpath("//*[@class='searchBarContainer']/input ")).clear();
	    wd.findElement(By.xpath("//*[@class='searchBarContainer']/input ")).sendKeys("mir");
	    wd.findElement(By.xpath("//*[@class='activityPanel_rightContainerFooter flex']/span")).click();
	    wd.findElement(By.xpath("//*[@class='updatePackageBtnWrapper btn']")).click();
	    Thread.sleep(2000);
	    test.pass("activity added");
	    
	    WebElement acti = wd.findElement(By.xpath("//*[@class='activity-row-details-title']"));
	    String actinfo = acti.getText();
	    System.out.println(actinfo);
	    
	    Assert.assertEquals(actinfo,"Jewel Changi Airport (Mirror Maze)- Ticket Only");
	    test.pass("activity verified");

	      
	    //checking the plan
	    wd.findElement(By.xpath("(//*[@class='initerary-nav '])/li")).click();
	    WebElement plan = wd.findElement(By.xpath("(//*[@class='initerary-nav '])/li/b"));
	    String planinfo = plan.getText();
	    System.out.println(planinfo);
	    
	    Assert.assertEquals(planinfo,"4");
	    test.pass("plan verified");

	 	  //checking the flights
	    wd.findElement(By.xpath("(//*[@class='initerary-nav '])/li[2]")).click();
	    WebElement flight=wd.findElement(By.xpath("(//*[@class='initerary-nav '])/li[2]/b"));
	    String flightinfo = flight.getText();
	    System.out.println(flightinfo);

	    Assert.assertEquals(flightinfo,"2");
	    test.pass("flight verified");
	    
	    //checking the hotel
	    wd.findElement(By.xpath("(//*[@class='initerary-nav '])/li[3]")).click();
	    WebElement hotel=wd.findElement(By.xpath("(//*[@class='initerary-nav '])/li[3]/b"));
	    String hotelinfo = hotel.getText();
	    System.out.println(hotelinfo);
	    
	    Assert.assertEquals(hotelinfo,"1");
	    test.pass("hotel verified");


	    //checking the transfers
	    wd.findElement(By.xpath("(//*[@class='initerary-nav '])/li[4]")).click();
	    WebElement transfer=wd.findElement(By.xpath("(//*[@class='initerary-nav '])/li[4]/b"));
	    String transferinfo =transfer.getText();
	    System.out.println(transferinfo);
	    
	    Assert.assertEquals(transferinfo,"2");
	    test.pass("transfers verified");

	    	    //checking the activity
	    wd.findElement(By.xpath("(//*[@class='initerary-nav '])/li[5]")).click();
	    WebElement activity=wd.findElement(By.xpath("(//*[@class='initerary-nav '])/li[5]/b"));
	    String activityinfo = activity.getText();
	    System.out.println(activityinfo);

	    Assert.assertEquals(activityinfo,"1");
	    test.pass("activity verified again");
	}
	@AfterTest
	public void at1() {
		wd.close();
	    er.flush();
	}
	

	

}
