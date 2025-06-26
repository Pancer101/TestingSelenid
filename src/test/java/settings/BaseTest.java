package settings;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    void setup() {
        Configuration.browserSize = "2160x1440";
        Configuration.timeout = 5000;
        Configuration.pageLoadStrategy = "eager";
    }
    @AfterEach
    void after() {
        Selenide.closeWebDriver();
    }
}
