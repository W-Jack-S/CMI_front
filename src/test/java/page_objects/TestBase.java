package page_objects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.By.xpath;


public class TestBase extends WebDriverInit {
    public Authorization authorization;
    public PageActions act;
    public HomePage url;

    //СПИСОК ОБЩИХ ЗНАЧЕНИЙ (!!!!ПОЗЖЕ ВЫНЕСТИ ОТДЕЛЬНО!!!!)

    public By mainPage = xpath("//div[text()='Главная страница']");
    public By voidPlace = xpath("//*[@id='root']");
    public By errorNotification = xpath("//div[2]/p[1][text()='Ошибка!']");

    public By LoginLocator = xpath("//input[@type='text']");
    public By PasswordLocator = xpath("//input[@type='password']");
    public By EnterLocator = xpath("//button[@type='button']");
    public By CheckboxLocator = xpath("//*[@id='root']/div[1]/div/div[4]/div/div[1]");

    //ТАБЫ
    public By calculation = xpath("//div[text()='Расчеты']");
    public By nsi = xpath("//div[text()='НСИ']");
    public By calendarTab = xpath("//div[text()='Календарь']");
    public By calendarMenu = xpath("//a[text()='Календарь']");
    public By brrm = xpath("//div[text()='Блок расчетов рабочей мощности']");
    public By brrm_1 = xpath("//a[text()='Расчет рабочей мощности по агрегатам электростанции']");
    public By brgg = xpath("//div[text()='Блок расчетов ГГ']");
    public By brgg_1 = xpath("//a[text()='Распределение выработки по суткам, агрегатам и ГГ']");
    public By brgg_2 = xpath("//a[text()='Расчет пределов ГГ']");
    public By energyTab = xpath("//div[text()='Энергетическая схема']");
    public By energyMenu_1 = xpath("//a[text()='Варианты энергетической схемы']");

    //КАЛЕНДАРЬ
    public By calendarCreate = xpath("//div[text()='Создать новый календарь']");
    public By create = xpath("//div[contains(text(),'Создать')]");

    //РАБОЧАЯ МОЩНОСТЬ
    public By formCalculation = xpath("//div[text()='Формирование расчета']");
    public By startCalculation = xpath("//span[text()=' Запустить расчет ']");
    public By changeMonth = xpath("//div[text()='Месяцы']");
    public By clearMonth = xpath("//div[text()='Сброс выбора']");
    public By errorIconObjects = xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[4]");
    public By errorIconMonth = xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[2]/div[1]");
    public By changeCalculationMethod = xpath("//div[text()='Вариант рабочей мощности']");
    public By calculationDoneSuccess = xpath("//table/tbody/tr[1]/td[1]/div[@title='Расчет завершен']");

    //ЭНЕРГЕТИЧЕСКИЙ УЗЕЛ
    //public By energyCreate = xpath("//div[text()='Создать узел']");

    //БАЛАНС
    public By inputBalance = xpath("//div[text()='Ввод / Просмотр баланса электроэнергии']");
    public By save = xpath("//div[text()='Сохранить']");
    public By input = xpath("//input");

    //ПОЛЬЗОВАТЕЛИ
    public String[] user_dep_rdu = {"test_3","test_3"};
    public String[] user_cmi = {"sssinitsa@tsum.ru","qwertsum759426"};

    //ИНИЦИАЛИЗАЦИЯ ПАТТЕРНОВ
    public void initPatterns(){
        url = new HomePage(driver);
        act = new PageActions(driver);
        authorization = new Authorization(driver);
    }

    //ЗАПУСК И ВАЛИДАЦИЯ УСПЕШНОСТИ РАСЧЕТА
    public void calculationRun() {
        List<WebElement> listOfCalculation = driver.findElements(By.xpath("//table/tbody/tr"));
        int beforeResult = listOfCalculation.size();
        act.click(startCalculation);
        List<WebElement> listOfCalculationResult = driver.findElements(By.xpath("//table/tbody/tr"));
        int afterResult = listOfCalculationResult.size();
        assertTrue((afterResult - beforeResult) == 1);
    }


}
