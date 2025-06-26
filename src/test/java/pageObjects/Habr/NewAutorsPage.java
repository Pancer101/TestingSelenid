package pageObjects.Habr;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class NewAutorsPage {

    private final SelenideElement nazvanieElementa = $x("//a[text()='Как стать автором']");
    private final SelenideElement newAutors = $x("//a[text()='Новые авторы']");
    private final ElementsCollection newAutorsPosts = $$x("//div[@data-test-id='sandbox_article_list']//h2[@data-test-id='articleTitle']//span");

    public NewAutorsPage clickNazvanieElementa(){
        nazvanieElementa.shouldBe(visible).click();
        return this;
    }

    public NewAutorsPage clickNewAutors(){
        newAutors.shouldBe(visible).click();
        return this;
    }

    public NewAutorsPage assertNewAutorsPost(String element){
        newAutorsPosts.find(text(element)).shouldBe(visible);
        return this;
    }
}
