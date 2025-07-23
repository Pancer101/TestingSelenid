package com.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.utils.TimeoutDuration.*;

public class SomeFeaturesPages {

    private final SelenideElement colorButton = $("#colorChange");
    private final SelenideElement tabButton = $("#tabButton");
    private final SelenideElement homeFolderExpand = $x("//button[@title='Toggle']");
    private final String documentsCheckbox = "//label[@for='tree-node-documents']";
    private final SelenideElement hoverButton = $("#toolTipButton");
    private final SelenideElement hover = $("#buttonToolTip");
    private final SelenideElement slider = $("#sliderContainer input[type='range']");
    private final SelenideElement sliderValue = $("#sliderValue");

    @Getter private final String END_POINT_COLOR = "/dynamic-properties";
    @Getter private final String END_POINT_WINDOWS = "/browser-windows";
    @Getter private final String END_POINT_CHECKBOX = "/checkbox";
    @Getter private final String END_POINT_HOVER = "/tool-tips";
    @Getter private final String END_POINT_SLIDER = "/slider";

    public SomeFeaturesPages checkColorChange() {

        colorButton
                .shouldHave(cssValue("color","rgba(255, 255, 255, 1)"), TIMEOUT_MIDDLE)
                .shouldNotHave(cssValue("color","rgba(255, 255, 255, 1)"), TIMEOUT_MIDDLE);

        return this;
    }

    public SomeFeaturesPages checkSwitchTabs() {

        tabButton.shouldBe(visible).click();

        // Переключаемся на новое окно
        switchTo().window(1);

        // Проверяем надпись в новом окне
        $("#sampleHeading").shouldHave(text("This is a sample page"));

        return this;
    }

    public SomeFeaturesPages checkCheckbox() {

        homeFolderExpand.shouldBe(visible).click();
        $x(documentsCheckbox).shouldBe(visible).click();
        $x(documentsCheckbox + "//span[1]").shouldBe(selected);

        return this;
    }

    public SomeFeaturesPages checkHover() {

        hoverButton.shouldBe(visible).hover();
        hover.shouldBe(visible).shouldHave(text("You hovered over the Button"));

        return this;
    }

    public SomeFeaturesPages checkSlider() {

        // Генерируем случайное значение от 0 до 100
        Random random = new Random();
        int randomValue = random.nextInt(101); // 0 до 100 включительно
        double percentage = (double) (randomValue) / 100; // Преобразуем в процент для смещения

        // Получаем ширину слайдера
        int sliderWidth = slider.getSize().width;
        int movePixels = (int) (percentage * sliderWidth);

        // Выполняем смещение слайдера с помощью мыши
        Actions actions = new Actions(getWebDriver());
        actions.clickAndHold(slider)
                .moveByOffset(movePixels - (sliderWidth / 2), 0) // Смещение относительно центра
                .release()
                .perform();

        // Проверяем значение через shouldHave
        sliderValue.shouldHave(value(String.valueOf(randomValue)));

        return this;
    }
}
