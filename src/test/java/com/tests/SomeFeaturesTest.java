package com.tests;

import com.pages.SomeFeaturesPages;
import com.settings.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class SomeFeaturesTest extends BaseTest {

    private final SomeFeaturesPages someFeaturesPages = new SomeFeaturesPages();

    @BeforeEach
    void before() {
        open(someFeaturesPages.getEND_POINT());
    }

    @Test
    @DisplayName("")
    void checkColorTest() {
        open(someFeaturesPages.getEND_POINT_COLOR());
        someFeaturesPages
                .checkColorChange();
    }

    @Test
    @DisplayName("")
    void checkSwitchTabsTest() {
        open(someFeaturesPages.getEND_POINT_WINDOWS());
        someFeaturesPages
                .checkSwitchTabs();
    }

    @Test
    @DisplayName("")
    void checkCheckboxTest() {
        open(someFeaturesPages.getEND_POINT_CHECKBOX());
        someFeaturesPages
                .checkCheckbox();
    }

    @Test
    @DisplayName("")
    void checkHoverTest() {
        open(someFeaturesPages.getEND_POINT_HOVER());
        someFeaturesPages
                .checkHover();
    }

    @Test
    @DisplayName("")
    void checkSliderTest() {
        open(someFeaturesPages.getEND_POINT_SLIDER());
        someFeaturesPages
                .checkSlider();
    }
}
