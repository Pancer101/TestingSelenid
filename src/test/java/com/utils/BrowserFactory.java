package com.utils;

import com.codeborne.selenide.Configuration;

public enum BrowserFactory {

    CHROME {
        @Override
        public void setup(String baseUrl, int timeout, boolean headless, int pageLoadTimeout, String browserSize, String browserVersion) {
            configureCommonSettings("chrome", baseUrl, timeout, headless, pageLoadTimeout, browserSize, browserVersion);
        }
    },

    FIREFOX {
        @Override
        public void setup(String baseUrl, int timeout, boolean headless, int pageLoadTimeout, String browserSize, String browserVersion) {
            configureCommonSettings("firefox", baseUrl, timeout, headless, pageLoadTimeout, browserSize, browserVersion);
        }
    },

    EDGE {
        @Override
        public void setup(String baseUrl, int timeout, boolean headless, int pageLoadTimeout, String browserSize, String browserVersion) {
            configureCommonSettings("edge", baseUrl, timeout, headless, pageLoadTimeout, browserSize, browserVersion);
        }
    };

    public abstract void setup(String baseUrl, int timeout, boolean headless, int pageLoadTimeout, String browserSize, String browserVersion);

    private static void configureCommonSettings(String browser, String baseUrl, int timeout, boolean headless, int pageLoadTimeout, String browserSize, String browserVersion) {
        Configuration.browser = browser;
        Configuration.baseUrl = baseUrl;
        Configuration.timeout = timeout;
        Configuration.headless = headless;
        Configuration.pageLoadTimeout = pageLoadTimeout;
        Configuration.browserSize = browserSize;
        Configuration.browserVersion = browserVersion;
    }
}