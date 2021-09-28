package CMI_katalog.filters;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page_objects.TestBase;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.By.xpath;

public class FilterSort extends TestBase {

    @BeforeEach
    void filterSortPreconditions() {
        chrome();
        initPatterns();
        url.cmiAlpha();
        authorization.cmiAlpha(user_cmi[0], user_cmi[1]);
    }


    @Test
    void filterSort01() throws InterruptedException {
        act.click(xpath("//div[text()=' Каталог ']"));
        assertTrue(act.findAssertTrue(xpath("//div[text()=' Популярности ']")));

    }

    @Test
    void filterSort02() throws InterruptedException {
        act.click(xpath("//div[text()=' Каталог ']"));
        act.click(xpath("//div[@class='description ng-star-inserted']"));
        act.click(xpath("//ui-select-option[1]/div"));
       assertTrue(act.findAssertTrue(xpath("//div[text()=' Возрастанию цены ']")));

    }

    @Test
    void filterSort03() throws InterruptedException {
        act.click(xpath("//div[text()=' Каталог ']"));
        act.click(xpath("//div[@class='description ng-star-inserted']"));
        act.click(xpath("//ui-select-option[2]/div"));
        assertTrue(act.findAssertTrue(xpath("//div[text()=' Убыванию цены ']")));

    }

    @Test
    void filterSort04() throws InterruptedException {
        act.click(xpath("//div[text()=' Каталог ']"));
        act.click(xpath("//div[@class='description ng-star-inserted']"));
        act.click(xpath("//ui-select-option[3]/div"));
        assertTrue(act.findAssertTrue(xpath("//div[text()=' Новизне ']")));

    }

    @Test
    void filterSort05() throws InterruptedException {
        act.click(xpath("//div[text()=' Каталог ']"));
        act.click(xpath("//div[@class='description ng-star-inserted']"));
        act.click(xpath("//ui-select-option[4]/div"));
        assertTrue(act.findAssertTrue(xpath("//div[text()=' Популярности ']")));

    }

    @AfterEach
    void filterSortPostconditions() {
        driver.quit();
    }
}
