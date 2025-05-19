package tests.uiTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.MainPage;
import tests.UITestsInit;

class MainPageUITests implements UITestsInit {
    MainPage mainPage;

    @Test
    @DisplayName("Загрузка главной страницы сайта")
    void mainPageLoaded() {
        mainPage = BasePage.openApp()
                .waitMainPageLoaded();
    }


}
