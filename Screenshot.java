package KotakSecurities;

import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class Screenshot {

    @Test(groups = "QA")
    @Description("To verify login screensshot")
    public void take_ss() throws Exception{

        WebDriver driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.kotaksecurities.com/trade/login");
        System.out.println(driver.getCurrentUrl());
        this.takeSnapShot(driver, "F://Selenium_Automation2024//Screenshot//test.png") ;

        driver.quit();
    }

    public static void takeSnapShot(WebDriver webDriver,String filePath) throws Exception{

        //Convert web driver object to TakeScreenshot
        TakesScreenshot takesScreenshot= ((TakesScreenshot)webDriver);
      //Call getScreenshotAs method to create image file
        File srcFile= takesScreenshot.getScreenshotAs(OutputType.FILE);

//Move image file to new destination

        File DestFile= new File(filePath);
        //Copy file at destination
        FileUtils.copyFile(srcFile,DestFile);
    }
}
