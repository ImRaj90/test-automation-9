package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.ReadingConfigValues;
import utilities.ReadExcel;

public class BaseClass {

   // reading values from external files
   ReadingConfigValues readingConfigValues = new ReadingConfigValues();
   ReadExcel readExcel = new ReadExcel();
   public String baseUrl = readingConfigValues.getURL();
   public static WebDriver driver;
   public static Logger logger;
   
   @BeforeClass
   @Parameters("browser")
   public void setup(String browser){
      logger = LogManager.getLogger(BaseClass.class);
      logger.info("Application Launched");
      
      // Initiate browser driver as per browser value
      if (browser.equalsIgnoreCase("Chrome")) {
         driver = new ChromeDriver();
         System.out.println("Browser opened in Chrome");
      } else if (browser.equalsIgnoreCase("Edge")) {
         driver = new EdgeDriver();
         System.out.println("Browser opened in Edge");
      }
	  
      // launch application
      driver.get(baseUrl);
   }
   @AfterClass
   public void tearDown(){
   
      // quitting browser
      driver.quit();
   }
}