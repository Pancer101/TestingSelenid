package com.settings;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.utils.BrowserManager.startDriver;

abstract class BaseTest {

    @BeforeEach
    void before() {
        startDriver();
    }

    @AfterEach
    void after() {
        closeWebDriver();
    }
}
