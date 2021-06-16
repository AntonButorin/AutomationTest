import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    private By repositoryLink = By.xpath("//a[@class='v-align-middle']");
    private By searchField = By.xpath("//form[@role='search']//input[1]");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 100);
    }

    private MainPage typeSearchQuery(String query) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys(query);
        return this;
    }

    private MainPage clickEnter() {
        webDriver.findElement(searchField).sendKeys(Keys.ENTER);
        return this;
    }

    private RepositoryPage clickOnRepositoryLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(repositoryLink)).click();
        return new RepositoryPage(webDriver);
    }

    public RepositoryPage openRepository(String repository) {
        this.typeSearchQuery(repository);
        this.clickEnter();
        this.clickOnRepositoryLink();
        return new RepositoryPage(webDriver);
    }
}
