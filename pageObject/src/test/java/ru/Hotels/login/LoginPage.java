package ru.Hotels.login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
private WebDriver driver;
private WebDriverWait wait;

public LoginPage(WebDriver driver){
    this.driver = driver;
    wait = new WebDriverWait(driver,10);

}

    @FindBy(id = "client-email")
    private WebElement email;
    @FindBy(id = "client-password")
    private WebElement password;
    @FindBy(css = "button[type=\"submit\"]")
    private WebElement submit;
    @FindBy(className = "[class=\"form-error\"]")
    private WebElement errorForm;

   public void Email(String emailforPerson){
   email.sendKeys(emailforPerson);
}
   public void Password(String passwordforPerson){
        password.sendKeys(passwordforPerson);
    }

    public void submitForm() {
        submit.click();
    }
    public  String getText() {
        return errorForm.getText();

    }


    ///////ERRORS TEST
    public String  getErrorLogin() {
        WebElement loginParrent = email.findElement(By.xpath(".."));
        return  loginParrent.findElement(By.cssSelector("small")).getText();
    }
    public  String getErrorPassword() {
        WebElement passwordParrent = password.findElement(By.xpath(".."));
        return   passwordParrent.findElement(By.cssSelector("small")).getText();
    }
}

