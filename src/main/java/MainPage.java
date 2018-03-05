import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(css = "input[type='title']")
    WebElement titleRadionBtn;

    @FindBy(id= "q")
    WebElement searchInpuField;

    @FindBy(css = "input[type='submit']")
    WebElement searchButton;

    public MainPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
        PageFactory.initElements(webDriver, this);
    }

    public void switchSearchToTitle() {
        titleRadionBtn.click();
    }

    public void enterSearchableText(String text) {
        searchInpuField.clear();
        searchInpuField.sendKeys(text);
        webDriver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    public void  clickSearchButton(){
        searchButton.click();
    }




}