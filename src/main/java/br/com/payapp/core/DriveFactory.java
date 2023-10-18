package br.com.payapp.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class DriveFactory {

    @BeforeMethod
    public WebDriver setUp(){
        FirefoxOptions options = new FirefoxOptions();
//        options.setHeadless(true);
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.get("https://payapp.space/avaliadordemarcas/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @AfterMethod
    public void tearDown(WebDriver driver) {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
