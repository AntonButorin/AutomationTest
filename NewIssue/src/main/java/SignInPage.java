import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    private By loginField = By.xpath("//input[@id='login_field']");
    private By passField = By.xpath("//input[@id='password']");
    private By signInButton = By.xpath("//input[@value='Sign in']");

    public SignInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 100);
    }

    private SignInPage typeLogin(String login) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginField)).sendKeys(login);
        return this;
    }

    private SignInPage typePassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passField)).sendKeys(password);
        return this;
    }

    private MainPage clickSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
        return new MainPage(webDriver);
    }

    public MainPage signIn (String login, String password) {
        this.typeLogin(login);
        this.typePassword(password);
        this.clickSignInButton();
        return new MainPage(webDriver);
    }
}
