package CMI_katalog.filters;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page_objects.TestBase;

import java.util.function.BooleanSupplier;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.By.xpath;

public class FilterProperty extends TestBase {

    @BeforeEach
    void filterPropertyPreconditions() {
        chrome();
        initPatterns();
        url.cmiAlpha();
        authorization.cmiAlpha(user_cmi[0], user_cmi[1]);

    }

    @Test
    void filterProperty01() throws InterruptedException {
        act.click(xpath("//div[text()=' Каталог ']"));
        act.click(xpath("//ui-select[@qa-attribute-selector]"));
        assertTrue(act.findAssertTrue(xpath("//div[text()='Только товары И-М']")));
        assertTrue(act.findAssertTrue(xpath("//div[text()='Будут показаны товары интернет-магазина']")));
        assertTrue(act.findAssertTrue(xpath("//div[text()='Только товары с предоплатой']")));
        assertTrue(act.findAssertTrue(xpath("//div[text()='Будут доставлены клиенту после предоплаты']")));
       act.click(xpath("//button[@qa-select-apply]"));
        assertFalse(act.findAssertTrue(xpath("//div[text()=' \n" +
                "            Выбран\n" +
                "            1 элемент\n" +
                "         ']")));
       assertFalse(act.findAssertTrue(xpath("//div[text()=' \n" +
               "            Выбрано\n" +
               "            2 элемента\n" +
               "         ']")));
    }

    @Test
    void filterProperty02() throws InterruptedException {
        act.click(xpath("//div[text()=' Каталог ']"));
        act.click(xpath("//ui-select[@qa-attribute-selector]"));
        act.click(xpath("//button[@qa-select-cancel]"));
        assertFalse(act.findAssertTrue(xpath("//div[text()=' \n" +
                "            Выбран\n" +
                "            1 элемент\n" +
                "         ']")));
        assertFalse(act.findAssertTrue(xpath("//div[text()=' \n" +
                "            Выбрано\n" +
                "            2 элемента\n" +
                "         ']")));
    }

    @Test
    void filterProperty03() throws InterruptedException {
        act.click(xpath("//div[text()=' Каталог ']"));
        act.click(xpath("//ui-select[@qa-attribute-selector]"));
        act.click(xpath("//ui-select-option[1]"));
        act.click(xpath("//button[@qa-select-apply]"));
        assertTrue(act.findAssertTrue(xpath("//div[text()=' \n" +
                "            Выбран\n" +
                "            1 элемент\n" +
                "         ']")));
        given()
                .baseUri("https://api.stable.int.tsum.com")
                .basePath("/v2/catalog/search?page=1&per-page=30&checkAccess=1")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .body("[0].brand_name", equalTo("Brunello Cucinelli"));
    }

    @Test
    void filterProperty04() throws InterruptedException {
        act.click(xpath("//div[text()=' Каталог ']"));
        act.click(xpath("//ui-select[@qa-attribute-selector]"));
        act.click(xpath("//ui-select-option[2]"));
        act.click(xpath("//button[@qa-select-apply]"));
        assertTrue(act.findAssertTrue(xpath("//div[text()=' \n" +
                "            Выбран\n" +
                "            1 элемент\n" +
                "         ']")));
    }

    @Test
    void filterProperty05() throws InterruptedException {
        act.click(xpath("//div[text()=' Каталог ']"));
        act.click(xpath("//ui-select[@qa-attribute-selector]"));
        act.click(xpath("//ui-select-option[1]"));
        act.click(xpath("//ui-select-option[2]"));
        act.click(xpath("//button[@qa-select-apply]"));
        assertTrue(act.findAssertTrue(xpath("//div[text()=' \n" +
                "            Выбрано\n" +
                "            2 элемента\n" +
                "         ']")));
    }


    @AfterEach
    void filterPropertyPostconditions() {
        driver.quit();
    }
}
