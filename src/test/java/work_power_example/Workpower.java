package work_power_example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page_objects.TestBase;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.By.xpath;

public class Workpower extends TestBase {
    //Тест-кейсы Рабочая мощность

    @BeforeEach //ОБЩЕЕ НАЧАЛО КАЖДОГО ТЕСТА
    public void Start() throws InterruptedException {
        chrome();
        initPatterns();
        url.saperDev();
        authorization.saper(user_dep_rdu[0], user_dep_rdu[1]);
        Thread.sleep(1000);
        act.click(calculation);
        act.moveCursor(brrm);
        act.click(brrm_1);
    }

    @AfterEach //ОБЩЕЕ ОКОНЧАНИЕ КАЖДОГО ТЕСТА
    public void end(){
        driver.quit();
    }

    @Test //Выбор всех объектов
    public void Test01() throws InterruptedException {
        act.click(formCalculation);
        Thread.sleep(1000);
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/div[2]/div[1]/div[1]/div"));
        calculationRun();
        driver.findElement(calculationDoneSuccess);
    }

    @Test //Выбор нескольких станций
    public void Test02() throws InterruptedException {
        act.click(formCalculation);
        Thread.sleep(1000);
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/div[2]/div[1]/div[1]/div"));
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div"));
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[3]/div[2]/div[2]/div[1]/div"));
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[3]/div[2]/div[5]/div[1]/div"));
        calculationRun();
        driver.findElement(calculationDoneSuccess);
    }

    @Test //Выбор станции с агрегатами
    public void Test03() throws InterruptedException {
        act.click(formCalculation);
        Thread.sleep(1000);
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/div[2]/div[1]/div[1]/div"));
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div"));
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[3]/div[2]/div[3]/div[1]/div"));
        calculationRun();
        driver.findElement(calculationDoneSuccess);
    }

    @Test //Выбор станции без оборудования
    public void Test04() throws InterruptedException {
        act.click(formCalculation);
        Thread.sleep(1000);
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/div[2]/div[1]/div[1]/div"));
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div"));
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[3]/div[2]/div[2]/div[1]/div"));
        calculationRun();
        driver.findElement(calculationDoneSuccess);
    }

    @Test //Выбор одной ОЭС
    public void Test05() throws InterruptedException {
        act.click(formCalculation);
        Thread.sleep(1000);
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/div[1]/div"));
        calculationRun();
        driver.findElement(calculationDoneSuccess);
    }

    @Test //Выбор одной Энергосистемы
    public void Test06() throws InterruptedException {
        act.click(formCalculation);
        Thread.sleep(1000);
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/div[2]/div[1]/div[1]/div"));
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[2]/div[2]/div[2]/div[1]/div"));
        calculationRun();
        driver.findElement(calculationDoneSuccess);
    }

    @Test //Выбор одного месяца
    public void Test07() throws InterruptedException {
        act.click(formCalculation);
        Thread.sleep(1000);
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/div[2]/div[1]/div[1]/div"));
        act.click(changeMonth);
        act.click(clearMonth);
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[2]/div[3]/div[1]/div[7]/div"));
        act.click(voidPlace);
        calculationRun();
        driver.findElement(calculationDoneSuccess);
    }

    @Test //Выбор нескольких месяцев
    public void Test08() throws InterruptedException {
        act.click(formCalculation);
        Thread.sleep(1000);
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/div[2]/div[1]/div[1]/div"));
        act.click(changeMonth);
        act.click(clearMonth);
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[2]/div[3]/div[1]/div[2]/div"));
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[2]/div[3]/div[1]/div[8]/div"));
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[2]/div[3]/div[1]/div[9]/div"));
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[2]/div[3]/div[1]/div[11]/div"));
        act.click(voidPlace);
        calculationRun();
        driver.findElement(calculationDoneSuccess);
    }

    @Test //Не выбирать объект
    public void Test09() throws InterruptedException {
        act.click(formCalculation);
        Thread.sleep(1000);
        List<WebElement> listOfCalculation = driver.findElements(By.xpath("//table/tbody/tr"));
        int beforeResult = listOfCalculation.size();
        act.click(startCalculation);
        List<WebElement> listOfCalculationResult = driver.findElements(By.xpath("//table/tbody/tr"));
        int afterResult = listOfCalculationResult.size();
        assertTrue((afterResult - beforeResult) == 0);
        act.moveCursor(errorIconObjects);
        driver.findElement(By.xpath("//div[text()='Необходимо выбрать хотя бы 1 объект']"));
    }

    @Test //Выбор другого варианта рабочей мощности
    public void Test10() throws InterruptedException {
        act.click(changeCalculationMethod);
        int numBalance = 1;
        while (act.findAssertTrue(xpath("//div[text()='Вариант " + numBalance + "']")) == false) {
            numBalance++;}
        act.click(xpath("//div[text()='Вариант " + numBalance + "']"));
        act.click(formCalculation);
        Thread.sleep(1000);
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/div[2]/div[1]/div[1]/div"));
        calculationRun();
        driver.findElement(calculationDoneSuccess);
    }

    @Test //Не выбирать объект
    public void Test11() throws InterruptedException {
        act.click(formCalculation);
        Thread.sleep(1000);
        act.click(xpath("//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/div[2]/div[1]/div[1]/div"));
        act.click(changeMonth);
        act.click(clearMonth);
        act.click(voidPlace);
        List<WebElement> listOfCalculation = driver.findElements(By.xpath("//table/tbody/tr"));
        int beforeResult = listOfCalculation.size();
        act.click(startCalculation);
        List<WebElement> listOfCalculationResult = driver.findElements(By.xpath("//table/tbody/tr"));
        int afterResult = listOfCalculationResult.size();
        assertTrue((afterResult - beforeResult) == 0);
        act.moveCursor(errorIconMonth);
        driver.findElement(By.xpath("//div[text()='Необходимо выбрать хотя бы 1 фактический месяц']"));
    }
}
