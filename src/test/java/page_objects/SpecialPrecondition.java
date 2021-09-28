package page_objects;

import static org.openqa.selenium.By.xpath;

public class SpecialPrecondition extends TestBase{
    public void make2020Year() {
        act.click(nsi);
        act.moveCursor(energyTab);
        act.click(calendarMenu);
        act.click(xpath("//div[text()='Год']"));
        int year = 2020;
        act.click(calendarCreate);
        act.textInput(xpath("//input"),Integer.toString(year));
        act.click(create);
        act.find(xpath("//p[2][text()='Календарь создан!']"));
        act.click(xpath("//div[text()='Год']"));
        act.click(xpath("//div[@title='Выбрать' and text()='" + year + "']"));
    }
}
