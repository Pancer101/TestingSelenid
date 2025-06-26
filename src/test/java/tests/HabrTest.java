package tests;

import org.junit.jupiter.api.Test;
import pageObjects.Habr.NewAutorsPage;
import settings.BaseTest;

import static com.codeborne.selenide.Selenide.open;

public class HabrTest extends BaseTest {

    private final static String baseURL = "https://habr.com/ru";
    NewAutorsPage newAutorsPage = new NewAutorsPage();

    @Test
    public void NewAutorsPostsTest() {
        open(baseURL);
        newAutorsPage
                .clickNazvanieElementa()
                .clickNewAutors()
                .assertNewAutorsPost("Дрейф в облаке: криминалистическое исследование дрейфа контейнеров");
    }
}
