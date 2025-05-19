package tests;

import com.codeborne.selenide.Selenide;
import configs.WebDriverBuilder;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public interface UITestsInit {

    @BeforeAll
    static void beforeAll(){
        WebDriverBuilder.selectBaseURL();
        WebDriverBuilder.chromeDriver();
    }

    @BeforeEach
    default void beforeEach(){
    }

    @AfterEach
    default void afterEach(){
        Selenide.closeWebDriver();
    }

    @AfterAll
    static void afterAll(){
    }

}
