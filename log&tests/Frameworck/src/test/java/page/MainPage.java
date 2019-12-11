package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    private final String BASE_URL = "https://www.101hotels.ru";

    @FindBy(id = "header")
    private WebElement header;
    @FindBy(id = "client-email")
    private WebElement email;
    @FindBy(id = "client-password")
    private WebElement password;
    @FindBy(css = "button[type=\"submit\"]")
    private WebElement submit;
    @FindBy(className = "[class=\"form-error\"]")
    private WebElement errorForm;
    @FindBy(className = "[class=\"search-main clearfix\"]")
    private WebElement searchDiv;
    @FindBy(className = "[class=\"current-currency\"]")
    private WebElement currency;
    @FindBy(xpath = "//*[@id=\"content-inner\"]/div/span")
    private WebElement changedCurrency;
    @FindBy(className = "[class=\"search-error\"]")
    private WebElement errorMsgInSearchLabel;
    @FindBy(className = "[class=\"menu-item-name\"]")
    private WebElement infoAboutRussiaButton;
    @FindBy (xpath = "//*[@id=\"content-inner\"]/div")
    private WebElement resortInRussiaText;
    By loginButtonLocator = By.cssSelector("[class=\"menu-item account-control right-item js-ac-popup-button logged-off\"]");


    public MainPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public MainPage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }
    public MainPage signIn(User user){
        submit.click();
        header.findElement(loginButtonLocator).click();
    }

    public String getLoggedInUserName()
    {
        WebElement linkLoggedInUser = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(errorForm));
        return linkLoggedInUser.getText();
    }
    public String  getErrorLogin() {
        WebElement loginParrent = email.findElement(By.xpath(".."));
        return  loginParrent.findElement(By.cssSelector("small")).getText();
    }
    public  String getErrorPassword() {
        WebElement passwordParrent = password.findElement(By.xpath(".."));
        return   passwordParrent.findElement(By.cssSelector("small")).getText();
    }

    public MainPage  searchHotelsWithoutData(){
        WebElement  searchButton = searchDiv.findElement(By.className("button button-yellow button-lg button-search"));
        searchButton.click();
    return this;
    }
    public  MainPage changeCurrency(){
        currency.click();
        WebElement newCurrency = currency.findElement(By.cssSelector("USD"));
        newCurrency.click();
        return this;
    }
    public String getCurrency(){
        return changedCurrency.getText();
    }
    public String getErrorMsgInSearchLabel(){
       return errorMsgInSearchLabel.getText();
    }
    public MainPage infoAboutRussia(){
        infoAboutRussiaButton.click();
        WebElement relaxInRussiaButton = infoAboutRussiaButton.findElement(By.xpath("//*[@id=\"menu\"]/li/ul/a"));
        relaxInRussiaButton.click();
        return this;
    }
    public String getTextRelaxInRussia(){
        return resortInRussiaText.getText();
    }
    public MainPage loginWithoutData(){
        submit.click();
        loginButtonLocator.click()
        logger.info("Pressed Button submit without input  data");
        return new MainPage(driver);
    }




}
