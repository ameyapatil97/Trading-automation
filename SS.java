package KotakSecurities;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class SS {
    @Test
    public void testBStackTakeScreenShot() throws Exception{

        /*WebDriver driver ;
        System.setProperty("webdriver.firefox.marionette","c:\\geckodriver.exe");
        driver = new FirefoxDriver();*/
        WebDriver driver= new EdgeDriver();

//goto url
        driver.get("https://www.browserstack.com");
//Call take screenshot function
        this.takeSnapShot(driver, "E://test.png") ;
    }
    /**
     * This function will take screenshot
     * @param webdriver
     * @param fileWithPath
     * @throws Exception
     */
    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
//Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
        File DestFile=new File(fileWithPath);
//Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
}