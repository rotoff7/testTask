package configs;

import com.codeborne.selenide.Configuration;

public class WebDriverBuilder {

    public static void chromeDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.browserSize = "1920x1020";
        Configuration.timeout = 15000; // Таймаут для поиска элементов (ms)
        Configuration.pageLoadTimeout = 60000;
        Configuration.pageLoadStrategy = "normal";
    }


    public static void selectBaseURL(){
        String baseURL = "";
        String environment = System.getProperty("environment", "test").toLowerCase();

        switch (environment) {
            case "dev" -> baseURL = "https://www.rmteam.ru";
            case "test" -> baseURL = "https://www.rmteam.ru/routing/public";
            case "prod" -> baseURL = "https://www.rmteam.ru/";
            default -> throw new IllegalArgumentException("Неподдерживаемое окружение: " + environment);
        }

        Configuration.baseUrl = baseURL;
    }


}
