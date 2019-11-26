package page;

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

}
