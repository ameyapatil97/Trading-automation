package KotakSecurities;

import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class Zerodha_login {

    @Test(groups = "QA")
    @Description("To verify login page")
    public void login() throws  Exception{

        WebDriver driver= new EdgeDriver();
        driver.get("https://kite.zerodha.com/");
        this.takeScreenShot(driver, "F://Selenium_Automation2024//Screenshot//loginWindow.png");
        System.out.println(driver.getCurrentUrl());

          driver.findElement(By.id("userid")).sendKeys("OJJ489");
        this.takeScreenShot(driver, "F://Selenium_Automation2024//Screenshot//uSERiD.png");


        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Kk@123");
        this.takeScreenShot(driver, "F://Selenium_Automation2024//Screenshot//password.png");

        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        WebElement err= driver.findElement(By.tagName("p"));

        Assert.assertEquals("Invalid username or password.", "Invalid username or password.");
        driver.quit();
    }

    @Test(groups = "QA")
    @Description("To verify login page")
    public void loginWithPwd() throws  Exception{

        WebDriver driver= new EdgeDriver();
        driver.get("https://kite.zerodha.com/");
        this.takeScreenShot(driver, "F://Selenium_Automation2024//Screenshot//loginWindow.png");
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.id("userid")).sendKeys("OJJ379");
        this.takeScreenShot(driver, "F://Selenium_Automation2024//Screenshot//uSERiD.png");


        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("AJNHGHF");
        this.takeScreenShot(driver, "F://Selenium_Automation2024//Screenshot//password.png");

        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        this.takeScreenShot(driver, "F://Selenium_Automation2024//Screenshot//otp_pg.png");

        String act= driver.getCurrentUrl();
        System.out.println(driver.getTitle());

        driver.wait(5000);

        driver.findElement(By.xpath("//input[@id='userid']")).sendKeys("560634");
        String exp= "https://kite.zerodha.com/#loggedout";
        Assert.assertEquals(act,exp);

        driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();

    }


    public static void takeScreenShot(WebDriver webDriver, String filePath) throws  Exception{

        TakesScreenshot takesScreenshot= ((TakesScreenshot)webDriver);

        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        File destFile = new File(filePath) ;

        FileUtils.copyFile(srcFile,destFile);

    }
}
