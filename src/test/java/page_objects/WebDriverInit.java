package page_objects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverInit {
    public WebDriver driver;

    //ИНИЦИАЛИЗАЦИЯ БРАУЗЕРА

    //СТАРТОВЫЕ ПАРАМЕТРЫ БРАУЗЕРА
    public void startSetting(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    //ЗАПУСК GOOGLE CHROME
    public void chrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        startSetting();
    }

    //ЗАПУСК MOZILLA FIREFOX
    public void fireFox(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        startSetting();
    }

    //ЗАПУСК БРАУЗЕРА OPERA
    public void opera(){
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        startSetting();
    }

    //ЗАПУСК БРАУЗЕРА EDGE
    public void edge(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        startSetting();

    }
}
