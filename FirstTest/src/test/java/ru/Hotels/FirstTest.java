package ru.Hotels;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class FirstTest extends WebDriverSettings {
    @Test

    public void firstTest() {
        driver.get("https://www.101hotels.ru");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Hotels.com – предложения и скидки при бронировании гостиниц различных категорий, от пятизвездочных до недорогих"));
    }
    @Test
    public void secondTest(){
        driver.manage().window().setSize(new Dimension(100,100));
        driver.get("https://www.101hotels.ru");
        driver.quit();
    }
    @Test
    public void regTestWithBots(){
        WebElement header = driver.findElement(By.id("header"));
        header.findElement(By.cssSelector("[class=\"menu-item account-control right-item js-ac-popup-button logged-off\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        Random random = new Random();
        int n = random.nextInt(100)+1;
        driver.findElement(By.id("client-email")).sendKeys("Lololo"+ n +"@gmail.com");
        driver.findElement(By.id("client-email")).sendKeys("123qwerty123");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class=\"form-error\"]")));
    }
    @Test
    public void regFailureTest(){
        WebElement header = driver.findElement(By.id("header"));
        header.findElement(By.cssSelector("[class=\"menu-item account-control right-item js-ac-popup-button logged-off\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement login = driver.findElement(By.id("client-email"));
        WebElement loginParrent = login.findElement(By.xpath(".."));
        String loginFirstError =  loginParrent.findElement(By.cssSelector("small")).getText();
        Assert.assertTrue(loginFirstError.equals("Пожалуйста, введите адрес электронной почты."));
        WebElement password = driver.findElement(By.id("client-password"));
        WebElement passwordParrent = password.findElement(By.xpath(".."));
        String passwordFirstError =  passwordParrent.findElement(By.cssSelector("small")).getText();
        Assert.assertTrue(loginFirstError.equals("Пожалуйста, введите пароль."));


    }
}
