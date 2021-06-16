import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RepositoryPage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    private By issuesTab = By.xpath("//span[contains(., 'Issues')]");

    public RepositoryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 100);
    }

    public IssuesPage clickIssues() {
        wait.until(ExpectedConditions.elementToBeClickable(issuesTab)).click();
        return new IssuesPage(webDriver);
    }
}
