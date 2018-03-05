public class MainPage {
private WebDriver webDriver;
private WeDriverWait wait;

@FindBy(css = "input[type='title']")
WebElement titleRadionBtn;

public MainPage(WebDriver driver){
webDriver = driver;
wait = new WebDriverWait(webDriver, 30);
PageFactory.initElements(webDriver,this);
}

public void switchSearchToTitle(){
titleRadioBtn.click();
}

public void searchFor(String text){
webDriver.findElement(By.id("q")).clear();
webDriver.findElement(By.id("q")).sendKeys("Automation");//высокая скорость, уникальность
webDriver.findElement(By.cssSelector("input[type='submit']")).click();

}
}