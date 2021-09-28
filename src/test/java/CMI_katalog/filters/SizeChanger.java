package CMI_katalog.filters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page_objects.TestBase;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.By.xpath;

public class SizeChanger extends TestBase {

    @BeforeEach
    public void authorizationTestsPreconditions () {
        chrome();
        initPatterns();
        url.cmiAlpha();
        authorization.cmiAlpha(user_cmi[0], user_cmi[1]);
    }


    @Test
    void balanceEnergyTestsChainTest01() throws InterruptedException {
        act.click(xpath("//div[text()=' Каталог ']"));
        act.click(xpath("//app-catalog-card-new[2]/app-card/div[1]/div[1]/div/app-widget-frame[5]/app-sizes-widget/app-size-select/div/div[2]"));
        act.click(xpath("//app-catalog-card-new[3]/app-card/div[1]/div[1]/div/app-widget-frame[5]/app-sizes-widget/app-size-select/div/div[3]"));
        act.click(xpath("//app-catalog-card-new[2]/app-card/div[2]/button"));
        act.click(xpath("//app-catalog-card-new[3]/app-card/div[2]/button"));

    }
}
