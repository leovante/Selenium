import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItBooksTests {
    WebDriver webDriver;
    MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:/YandexDisk/Programming/GitHub/Selenium/chromedriver.exe");
        webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 30, 500);

        mainPage = new MainPage(webDriver);

        webDriver.get("http://it-ebooks.info/");

        System.out.println("Step 1: Switch to search by title");
        mainPage.switchSearchToTitle();

        System.out.println("Step 2: Enter search phrase");
        mainPage.enterSearchableText("Automation");

        System.out.println("Step 3: Click Search Buton");
        mainPage.clickSearchButton();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("top")));
    }

    @Test
    public void testSearshBookUrl() {
        System.out.println("Check url");
        Assert.assertTrue(webDriver.getCurrentUrl().contains("search/?q=automation&type=title"));
    }

    @Test
    public void testBooksSearch() {
        System.out.println("Check search results");
        Assert.assertTrue(
                webDriver.findElement(By.className("top"))
                        //.findElement(By.tagName("table")) //� �������� ��� ����� ���������
                        .findElements(By.tagName("tr"))
                        .size() == 10);
    }

    @After
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit();
    }
}