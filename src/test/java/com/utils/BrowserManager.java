package com.utils;

import static com.config.ConfigurationManager.config;

public class BrowserManager {
    public static void startDriver() {
        BrowserFactory
                .valueOf(config().browser().toUpperCase())
                .setup(config().baseUrl(), config().timeout(), config().headless(), config().pageLoadTimeout(), config().browserSize(), config().browserVersion());
    }
}
