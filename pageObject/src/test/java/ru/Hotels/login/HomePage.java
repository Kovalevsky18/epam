package ru.Hotels.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver,10);
    }
    @FindBy(id = "header")
    private WebElement header;

    By loginButtonLocator = By.cssSelector("[class=\"menu-item account-control right-item js-ac-popup-button logged-off\"]");

    public void open(){

        driver.get("https://www.101hotels.ru");
    }

    public void getStarted() {

        header.findElement(loginButtonLocator).click();
    }
}
