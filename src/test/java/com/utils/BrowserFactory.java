package com.utils;

import com.codeborne.selenide.Configuration;

public enum BrowserFactory {

    CHROME {
        @Override
        public void setup(String baseUrl, int timeout, boolean headless, int pageLoadTimeout, String browserSize) {
            configureCommonSettings("chrome", baseUrl, timeout, headless, pageLoadTimeout, browserSize);
        }
    },

    FIREFOX {
        @Override
        public void setup(String baseUrl, int timeout, boolean headless, int pageLoadTimeout, String browserSize) {
            configureCommonSettings("firefox", baseUrl, timeout, headless, pageLoadTimeout, browserSize);
        }
    },

    EDGE {
        @Override
        public void setup(String baseUrl, int timeout, boolean headless, int pageLoadTimeout, String browserSize) {
            configureCommonSettings("edge", baseUrl, timeout, headless, pageLoadTimeout, browserSize);
        }
    };

    public abstract void setup(String baseUrl, int timeout, boolean headless, int pageLoadTimeout, String browserSize);

    private static void configureCommonSettings(String browser, String baseUrl, int timeout, boolean headless, int pageLoadTimeout, String browserSize) {
        Configuration.browser = browser;
        Configuration.baseUrl = baseUrl;
        Configuration.timeout = timeout;
        Configuration.headless = headless;
        Configuration.pageLoadTimeout = pageLoadTimeout;
        Configuration.browserSize = browserSize;
    }
}