public class ItBooksTests {
WebDriver webDriver;
MainPage mainPage;

@Before
public void setUp(){
WebDriver webDriver = new ChromeDriver();
WebDriverWait wait = new WebDriverWait(webDriver, 30, 500);

mainPage = new MainPage(webDriver);

WebDriver.get("http://it-ebooks.info/");

//System.out.println(webDriver.getTitle());
//System.out.println(webDriver.getCurrentURL());

//webDriver.findElement(By.cssSeelctor("input[value='title']")).click(); заменил на mainPage
mainPage.switchSearchToTitle();

/* перенес в MainPage
webDriver.findElement(By.id("q")).clear();
webDriver.findElement(By.id("q")).sendKeys("Automation");//высокая скорость, уникальность
webDriver.findElement(By.cssSelector("input[type='submit']")).click();
**/

wait.until(ExpectedConditions.presenceOfElementLocated(By.className("top")));
}

@Test
public void testSearshBookUrl(){
Assert.assertTrue(webDriver.getCurrentUrl().contains("search/?q=Automation&type=title"));
}

@Test
public void testBooksSearch(){
Assert.assertTrue(
	webDriver.findElement(By.className("top"))
	.findElement(By.tagName("table")) //в принципе это можно исключить
	.findElements(By.tagNme("tr"))
	.size()==10);
Thread.sleep(20000);
}

@After
public void tearDown(){
	if (webDriver != null)
	   webDriver.quit();
}
}