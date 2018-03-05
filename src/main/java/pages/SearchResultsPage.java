package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by pro22 on 05.03.2018.
 */
public class SearchResultsPage {
    WebDriver  webDriver;
    WebDriverWait wait;
    public SearchResultsPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
    }

    public void waitForSearchResults(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("top")));
    }


}
