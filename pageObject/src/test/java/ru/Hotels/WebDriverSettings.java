package ru.Hotels;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {

    public ChromeDriver driver ;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/kovalevsky/Downloads/chromedriver");
        ChromeDriver driver = new ChromeDriver();
    }
    @After
    public void close(){
        driver.quit();
    }
}
