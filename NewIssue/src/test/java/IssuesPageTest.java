import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IssuesPageTest {
    private WebDriver webDriver;
    private IssuesPage issuesPage;

    @Before
    public void SetUp() {
        String login = "";
        String password = "";
        String repository = "AntonButorin/web-app";
        String startUrl = "https://github.com/login";
        String chromePath = "";

        System.setProperty("webdriver.chrome.driver", chromePath);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(startUrl);
        issuesPage = new SignInPage(webDriver).signIn(login, password).openRepository(repository).clickIssues();
    }

    @After
    public void cleanUp() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Test
    public void testCreateNewIssue() {
        String title = "3";
        String text = "12345";
        String userName;
        issuesPage.createNewIssue(title, text);
        userName = issuesPage.getUserName();
        Assert.assertTrue(issuesPage.getCommentTime().contains(userName)
                && issuesPage.getIssueTitle().equals(title)
                && issuesPage.getIssueText().equals(text));

    }
}
