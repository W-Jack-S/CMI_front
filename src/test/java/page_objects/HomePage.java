package page_objects;

import org.openqa.selenium.WebDriver;

public class HomePage {
    public WebDriver driver;

    //СПИСОК URL АДРЕСОВ ДОМАШНИХ СТРАНИЦ

    public void saperDev(){driver.get("http://saper.ic.ntcees.ru/");} //САПЭР - СТЕНД РАЗРАБОТКИ
    public void saperTest(){driver.get("http://saper-test.ic.ntcees.ru/");} //САПЭР - ТЕСТОВЫЙ СТЕНД
    public void drDev(){driver.get("https://dr.ic.ntcees.ru/");} //Demand Response - СТЕНД РАЗРАБОТКИ
    public void drTest(){driver.get("https://dr-test.ic.ntcees.ru/login");} //Demand Response - ТЕСТОВЫЙ СТЕНД
    public void krp(){driver.get("https://ia-ntc-krp.cdu.so/");}
    public void cmiAlpha(){driver.get("https://ng-cc-cmi-alpha.int.tsum.com/");}

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

}
