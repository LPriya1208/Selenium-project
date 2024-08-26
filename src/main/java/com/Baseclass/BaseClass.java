package com.Baseclass;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BaseClass {
	
	public static WebDriver driver;
	public static ExtentReports extentReports;
	public static File file;
	
     //Browser launch and Chrome Options
	protected static WebDriver browserLaunch(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("incognito");
			options.addArguments("start-maximized");
			options.addArguments("disabled-extension");
			options.addArguments("disabled-popup-blocking");
			options.addArguments("headless");	
			driver=new ChromeDriver(options);
			
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
			
		}else if(browserName.equalsIgnoreCase("IE")){
			driver=new InternetExplorerDriver();
			
		}
		driver.manage().window().maximize();
		return driver;
		
	}   
	
	public static void extentReportStart(String location) {
		extentReports = new ExtentReports();
		file = new File(location);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		
	}
	public static void extentReportTearDown(String location) throws IOException {
		extentReports.flush();
		file =new File(location);
		Desktop.getDesktop().browse((file).toURI());
	}
	
	
    public String takeScreenShot() throws IOException{
    	TakesScreenshot screenshot =(TakesScreenshot) driver;
    	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    	File sc= screenshot.getScreenshotAs(OutputType.FILE);
    	File des=new File("C:\\Users\\User\\eclipse-workspace\\open_MRS\\Screenshot.png" +"_"+timeStamp+".png");
    	FileUtils.copyFile(sc,des);
		return des.getAbsolutePath();
    }
	
	
	//geturl
		protected static void launchingUrl(WebDriver driver, String urlLink) {
			
			try {
				driver.get(urlLink);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
/*protected static String title(WebDriver driver, WebElement element) {
			
	String title="";		
	try {
				 title = driver.getTitle();
				System.out.println("Page Title: " + title);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return title;
			
		}*/


		//getTitle
      protected static void titleUrl(WebDriver driver, String pageTitle) {
			
			try {
				String title = driver.getTitle();
				System.out.println("Page Title: " + title);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
      //getCurrentUrl
      protected static void currentUrl(WebDriver driver,String urlCurrent) {
			
			try {
				String currentUrl=driver.getCurrentUrl();
				System.out.println("Page Current url : " + currentUrl);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
      //GetText
      protected static String getText(WebDriver driver, WebElement element ) {
			
			try {
				String text = element.getText();
				System.out.println(text);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
					
		}
      protected void explicitWaitVisible(WebDriver driver, WebElement element) {
  		try {
  			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  	}
      public void validation(WebDriver driver2, String home) {
  		// TODO Auto-generated method stub
  		
  	}

		

      //pass input
      protected static void inputPassing(WebDriver driver, WebElement element, String value) {
			try {
				element.sendKeys(value);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("The errors in basemethod inputPassing");
				e.printStackTrace();
			}	
	}
		//click element
		protected void clickElement(WebDriver driver,WebElement element) {
			try {
				new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element))
				.click();
			}catch (Exception e) {
				e.printStackTrace();
			}	
		} 
		/*protected static void clickElement(WebDriver driver,WebElement element) {
        	try {
				element.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}        	
        }*/
        
        protected void staticWait(long sec) {
    		try {
    			Thread.sleep(sec);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
        
        //close browser
        protected static void closeBrowser(WebDriver driver) {
        	driver.close();
        }
        //terminate browser
        protected static void terminateBrowser() {
        	driver.quit();
        }
        protected static boolean isEnabled(WebDriver driver, WebElement element)
        {
        	try {
				element.isEnabled();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return true;
        }
        protected static boolean isDisplayed(WebDriver driver, WebElement element)
        {
        	try {
				element.isDisplayed();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return true;
        }
        protected static boolean isSelected(WebDriver driver, WebElement element)
        {
        	try {
				element.isSelected();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return true;
        }
        //Browser Navigation
        protected static void navigateTo(WebDriver driver, String url)
        {
        	try {
				driver.navigate().to(url);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        protected static void navigateBack(WebDriver driver)
        {
        	try {
				driver.navigate().back();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
        }
        
        protected static void navigateForward(WebDriver driver)
        {
        	try {
				driver.navigate().forward();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
        }
        protected static void pageRefresh(WebDriver driver)
        {
        	try {
				driver.navigate().refresh();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
        }
        
        //Screenshot
        protected static void takeScreenShot(String fileName, WebDriver driver){
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	File source = ts.getScreenshotAs(OutputType.FILE);
        	File Dest= new File("C:\\Users\\User\\eclipse-workspace\\SeleniumScreenshot\\Amazonhome.png");
        	try {
				FileHandler.copy(source,Dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
        //Full Screenshot	
   //     protected static void fullScreenShot(String fileName, WebDriver driver) throws IOException{
        	
//        ScreenshotException take = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
//        ImageIO.write(take.getImage(),"PNG",new File(System.getProperty("user.dir")+"C:\\Users\\User\\eclipse-workspace\\SeleniumTesting\\Screenshot\\FacebookHomePage.png"));
//        
        
   //     Screenshot takeScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        
    //    ImageIO.write(takeScreenshot.getImage(), "PNG", new File(System.getProperty("user.dir")+"C:\\Users\\User\\eclipse-workspace\\SeleniumTesting\\Screenshot\\"+fileName+".png"));
   //     }
        //Mouse Action
        protected static void mouseAction(WebDriver driver, WebElement element, String typeActions, WebElement element1, WebElement element2) {
        	Actions ac=new Actions(driver);
        	if(typeActions.equalsIgnoreCase("click"))
        			{
        		ac.click(element).build().perform();
        	}
        	else if(typeActions.equalsIgnoreCase("rightclick")) {
        		ac.contextClick(element).build().perform();
        	}
        	else if(typeActions.equalsIgnoreCase("doubleclick")) {
        		ac.doubleClick(element).build().perform();
        	}
        	else if(typeActions.equalsIgnoreCase("draganddrop")) {
        		ac.dragAndDrop(element1, element2).build().perform();
        }
        }
        //JSE
        protected static void scrollUpDown(WebDriver driver, WebElement element , int x ,int y) {
        	JavascriptExecutor js =(JavascriptExecutor)driver;
        	 try {
				js.executeScript("window.scrollBy("+x+","+y+")");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
        
        //SimpleAlert
        protected static void simpleAlert(WebDriver driver,WebElement element) {
        	 Alert simplealert = driver.switchTo().alert();
        	 try {
				simplealert.accept();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        //confirmAlert
        protected static void confirmAlert(WebDriver driver,WebElement element, String ok, String cancel) {
       	 Alert confirmalert = driver.switchTo().alert();
       	 if(ok.equalsIgnoreCase("accept")) {
       		 confirmalert.accept();
       	 }else if(cancel.equalsIgnoreCase("dismiss")) {
       			 confirmalert.dismiss();
       		 }
       	 }
       	 //PromptAlert
    		protected static void promptAlert(WebDriver driver,WebElement element, String popup, String inputText, String cancel) {
    	       	 Alert promptalert = driver.switchTo().alert();
    	       	 if(popup.equalsIgnoreCase("prompt")) {
    	       		 promptalert.sendKeys(inputText);
    	       		 promptalert.accept();
    	       	}else if(cancel.equalsIgnoreCase("dismiss")) {
          			 promptalert.dismiss();
    	       	 
    	       		 }
    	       	 }
    		//Dropdown
    		protected static void dropDown(WebDriver driver, WebElement element, String selectoption, String selecttype) {
    		Select s =new Select(element);
    		if(selecttype.equalsIgnoreCase("value")) {
    			s.selectByValue(selectoption);
    		}else if(selecttype.equalsIgnoreCase("index")){
    			int index =Integer.parseInt(selectoption);
    			s.selectByIndex(index);
    		}
    			else if(selecttype.equalsIgnoreCase("text")){
    				s.selectByVisibleText(selectoption);
    			}
    		}
}
    		
    		

       
        

