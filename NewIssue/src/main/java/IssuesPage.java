import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IssuesPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    public IssuesPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 100);
    }

    private By newIssueButton = By.xpath("//span[text()='New issue']");
    private By submitNewIssueButton = By.xpath("//button[@class='btn btn-primary']");
    private By issueTitle = By.xpath("//span[@data-snek-id='issue-title']");
    private By issueTitleField = By.xpath("//input[@id='issue_title']");
    private By issueBodyField = By.xpath("//*[@id='issue_body']");
    private By commentTime = By.xpath("//h3[@class='timeline-comment-header-text f5 text-normal']");
    private By issueText = By.xpath("//tr[@class='d-block']//p");
    private By viewProfileIcon = By.xpath("//summary[@aria-label='View profile and more']");
    private By userName = By.xpath("//a[text()='Signed in as ']//strong");

    private IssuesPage typeTitle(String title) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(issueTitleField)).sendKeys(title);
        return this;
    }

    private IssuesPage typeBody(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(issueBodyField)).sendKeys(text);
        return this;
    }

    private IssuesPage clickNewIssueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(newIssueButton)).click();
        return new IssuesPage(webDriver);
    }

    public IssuesPage clickSubmitNewIssueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitNewIssueButton)).click();
        return new IssuesPage(webDriver);
    }

    public void createNewIssue(String title, String text) {
        this.clickNewIssueButton();
        this.typeTitle(title);
        this.typeBody(text);
        this.clickSubmitNewIssueButton();
    }

    private IssuesPage clickViewProfileIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(viewProfileIcon)).click();
        return new IssuesPage(webDriver);
    }

    public String getUserName() {
        this.clickViewProfileIcon();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userName)).getText();
    }

    public String getCommentTime() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(commentTime)).getText();
    }

    public String getIssueTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(issueTitle)).getText();
    }

    public String getIssueText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(issueText)).getText();
    }
}
