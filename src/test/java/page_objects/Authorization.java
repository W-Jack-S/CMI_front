package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//СПИСОК ПРОЕКТОВ ДЛЯ АВТОРИЗАЦИИ
//ВАРИАНТЫ АВТОРИЗАЦИИ
//!!!! ЗДЕСЬ НЕТ СПИСКА ФИКСИРОВАННЫХ ЛОГИНОВ И ПАРОЛЕЙ!!!!

public class Authorization {
    public WebDriver driver;
    String LoginLocator = "//input[@type='text']";
    String PasswordLocator = "//input[@type='password']";
    String EnterLocator = "//button[@type='button']";
    String CheckboxLocator = "//*[@id='root']/div[1]/div/div[4]/div/div[1]";
    String CheckboxLocatorKRP = "//*[@id='root']/div/div/div/div[3]/div[1]/div";


    public Authorization(WebDriver driver){
        this.driver = driver;
    }

    public void saper(String login, String password) {//АВТОРИЗАЦИЯ В САПЭР БЕЗ "ЗАПОМНИТЬ МЕНЯ"
        if (login != null) {
            driver.findElement(By.xpath(LoginLocator)).sendKeys(login);
        }
        if (password != null) {
            driver.findElement(By.xpath(PasswordLocator)).sendKeys(password);
        }
        driver.findElement(By.xpath(EnterLocator)).click();
    }

    public void demandResponse(String login, String password) {////АВТОРИЗАЦИЯ В DR БЕЗ "ЗАПОМНИТЬ МЕНЯ"
        if (login != null) {
            driver.findElement(By.xpath(LoginLocator)).sendKeys(login);
        }
        if (password != null) {
            driver.findElement(By.xpath(PasswordLocator)).sendKeys(password);
        }
        driver.findElement(By.xpath(EnterLocator)).click();
    }

    public void krp(String login, String password){
        if (login != null) {
            driver.findElement(By.xpath(LoginLocator)).sendKeys(login);
        }
        if (password != null) {
            driver.findElement(By.xpath(PasswordLocator)).sendKeys(password);
        }
        driver.findElement(By.xpath(EnterLocator)).click();
    }

    public void krpCheck(String login, String password){
        if (login != null) {
            driver.findElement(By.xpath(LoginLocator)).sendKeys(login);
        }
        if (password != null) {
            driver.findElement(By.xpath(PasswordLocator)).sendKeys(password);
        }
        driver.findElement(By.xpath(CheckboxLocatorKRP)).click();
        driver.findElement(By.xpath(EnterLocator)).click();
    }

    public void cmiAlpha(String login, String password){
        if (login != null) {
            driver.findElement(By.xpath(LoginLocator)).sendKeys(login);
        }
        if (password != null) {
            driver.findElement(By.xpath(PasswordLocator)).sendKeys(password);
        }
        driver.findElement(By.xpath(EnterLocator)).click();
    }


}
