// eto pattern proektirovania facad
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BooksSite;

public class ItBooksTests {
    WebDriver webDriver;
    BooksSite website;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:/YandexDisk/Programming/GitHub/Selenium/chromedriver.exe");
        webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 30, 500);

        website = new BooksSite(webDriver);

        webDriver.get("http://it-ebooks.info/");

        System.out.println("Step 1: Switch to search by title");
        website.mainPage().switchSearchToTitle();

        System.out.println("Step 2: Enter search phrase");
        website.mainPage().enterSearchableText("automation");

        System.out.println("Step 3: Click Search Buton");
        website.mainPage().clickSearchButton();

        System.out.println("Step 4: Wait For search Results");
        website.searchResultsPage().waitForSearchResults();
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