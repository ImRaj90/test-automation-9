package test.java.org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrow {
   public static void main(String[] args) throws InterruptedException {

      // setting Chrome options to browser in headless mode
      ChromeOptions opt = new ChromeOptions();
      opt.addArguments("--headless=new");

      // Initiate the Webdriver
      WebDriver driver = new ChromeDriver(opt);

      // adding implicit wait of 20 secs
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

      // Opening the webpage
      driver.get("https://www.tutorialspoint.com/selenium/practice/date-picker.php");

      // getting page title
      System.out.println("Getting the page title: " + driver.getTitle());

      // Quitting browser
      driver.quit();
   }
}
