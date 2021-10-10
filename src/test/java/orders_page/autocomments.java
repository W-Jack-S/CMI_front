package orders_page;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page_objects.TestBase;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.By.xpath;

public class autocomments extends TestBase {

    @BeforeEach
    void filterSortPreconditions() {
        chrome();
        initPatterns();
        url.cmiAlpha();
        authorization.cmiAlpha(user_cmi[0], user_cmi[1]);
    }
    @Test
    void filterSort01() throws InterruptedException {
        act.click(xpath("//div[text()=' Заказы ']"));
        List<WebElement> listOfOrders = driver.findElements(By.xpath("//ui-table-row"));
        System.out.println(listOfOrders.size());
        for (int m=2; m<=10; m++) {
            act.click(xpath("//ui-paginator/div["+m+"]"));
        for (int n=1; n<=listOfOrders.size(); n++) {
            if (act.findAssertTrue(xpath("//ui-table-row[" + n + "]/div[2]/div[1]/div[1]/ui-copy/div/ui-middle-ellipsis/div[text()='# ST_AT00']"))) {
                System.out.println("+");
                act.click(xpath("//ui-table-row[" + n + "]/div[2]/div[7]/div[text()='Взять в работу']"));
                act.click(xpath("//button[text()='Перейти к обработке заказа']"));
                act.click(xpath("//button[text()='все комментарии']"));
                for (int i = 1; i <= 10; i++) {
                    act.textInput(xpath("//textarea"), "автоматический тестовый комментарий " + i);
                    act.click(xpath("//button[text()='Сохранить изменения']"));
                    sleep(12000);
                }
                act.click(xpath("//button[text()='Закрыть']"));
                act.click(xpath("//button[text()='Вернуться в очередь']"));
            } else {
                System.out.println("-");
            }
        }

        }
        /////html/body/app-root/div/ng-component/div/app-table-pagination-layout/div/div[1]/div/ui-paginator/div[2]
       // act.find(xpath("//div[@class='left-side' and '@text()='# ST-AT00']"));
        //act.find(xpath(".//div[@class='left-side' and '@text()='# ST-AT00']"));

    }
}
