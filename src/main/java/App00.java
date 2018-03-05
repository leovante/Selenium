import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//https://www.youtube.com/watch?v=zka-SN9yNt4   1.25.20
public class App00 {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "E:/YandexDisk/Programming/GitHub/Selenium/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
//WebDriver webDriver = new FirefoxDriver();
        webDriver.get("http://it-ebooks.info/");
        System.out.println(webDriver.getTitle());
        System.out.println(webDriver.getCurrentUrl());

        webDriver.findElement(By.cssSelector("input[value='title']")).click();
        webDriver.findElement(By.id("q")).clear();

        webDriver.findElement(By.id("q")).sendKeys("Automation");//высокая скорость, уникальность
        webDriver.findElement(By.id("q")).sendKeys(Keys.RETURN);//типо нажали на энтер
//а ещё можно через нажатие кнопочки search на странице через cssSelector
//webDriver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(5000);


//webDriver.findElement(By.name("q"));//практически тоже самое что id
//webDriver.findElement(By.className("q"));//классы повторяются, если состоит из двух и более слов с пробелами, то искать с css селекторами ".q.a.v" это ниже
//webDriver.findElement(By.cssSelector("q")); это лучше, когда нет ид или нейма
//webDriver.findElement(By.xpath("//input[@name='q']"));//абсолютный икспасс нестабильный, когда добавят чо нить в теги, относительный лучше.
//webDriver.findElement(By.tagName("q"));нужно быть аккуратным, возвраащает только первый элемент
//webDriver.findElement(By.linkText("q"));
//webDriver.findElement(By.partialLinkText("q"));

        webDriver.quit(); //закрывает страничку
//webDriver.close(); закрывет процесс

    }
}

