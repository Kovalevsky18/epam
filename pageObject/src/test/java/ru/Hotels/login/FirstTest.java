package ru.Hotels.login;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import ru.Hotels.WebDriverSettings;

public class FirstTest extends WebDriverSettings {
    @Test

    public void firstTest() {
      HomePage homePage = PageFactory.initElements(driver, HomePage.class);
      homePage.open();
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Hotels.com – предложения и скидки при бронировании гостиниц различных категорий, от пятизвездочных до недорогих"));
    }
    @Test
    public void secondTest(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        driver.manage().window().setSize(new Dimension(100,100));
        driver.get("https://www.101hotels.ru");
        driver.quit();
    }
    @Test
    public void regTestWithBots(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getStarted();
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.Email("lollolo@gmail.com");
        loginPage.Password("123qwe123aasd");
        loginPage.submitForm();
        loginPage.getText();
        Assert.assertTrue(loginPage.getText().equals("Пожалуйста, подтвердите, что вы не робот."));
    }
    @Test
    public void regFailureTest(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getStarted();
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        Assert.assertTrue(loginPage.getErrorLogin().equals("Пожалуйста, введите адрес электронной почты."));
        Assert.assertTrue(loginPage.getErrorPassword().equals("Пожалуйста, введите пароль."));

    }
}
