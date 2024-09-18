package testCases;

import org.testng.annotations.Test;
import pageObjects.RegisterPage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertTrue;

public class RegisterUserTest extends  BaseClass {
   @Test
   public void registerUser() throws IOException {
      logger.info("Reading values from excel from registration");
      
      // reading values of excel in arraylist
      ArrayList<String> result = readExcel.readingExcel();

      // adding implicit wait of 12 secs
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
      // object of RegisterPage page class
      RegisterPage registerPage = new RegisterPage(driver);
      logger.info("Starting registration");
      
      // input first and last name
      for (int i = 0; i <result.size(); i++) {
         String[] names = result.get(i).split(",");
         registerPage.inputFirstname(names[0]);
         registerPage.inputLastname(names[1]);
      }
      
      // click register button
      registerPage.clickRegister();
      logger.info("Verification of entered values");
      
      // verify value input in the first name
      if (registerPage.getFirstName().equalsIgnoreCase("Ram")){
	  
         // assertions to test case
         assertTrue(true);
      } else {
         assertTrue(false);
      }
      
      // verify value input in the last name
      if (registerPage.getLastName().equalsIgnoreCase("Ganesh")){
	  
         // assertions to test case
         assertTrue(true);
      } else {
         assertTrue(false);
      }
   }
}