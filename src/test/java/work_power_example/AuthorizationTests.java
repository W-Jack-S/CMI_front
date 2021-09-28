package work_power_example;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import page_objects.TestBase;

public class AuthorizationTests extends TestBase {

    @BeforeEach
    public void authorizationTestsPreconditions () {
        chrome();
        initPatterns();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Login_Base_KRP_good.csv", delimiter = ';')
    public void authorizationTestKRP(String login, String password) {
        url.krp();
        authorization.krp(login, password);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Login_Base_KRP_good.csv", delimiter = ';')
    public void authorizationTestKRPempty(String login, String password) {
        url.krp();
        authorization.krp(login, password);
    }

    @AfterEach
    public void end(){
        driver.quit();
    }

}
