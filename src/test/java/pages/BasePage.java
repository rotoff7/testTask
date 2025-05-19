package pages;


import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;
import io.qameta.allure.Step;

import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class BasePage {

    @Step("Переход на стартовую страницу")
    public static MainPage openApp(){
        return open("", MainPage.class);
    }

    // ↓↓↓ МЕТОДЫ ДЕЙСТВИЙ ↓↓↓ -->

    // КЛИКИ -->

    @Step("Скорлл и клик по элементу")
    public void clickElementWithScroll(SelenideElement element){
        element.shouldBe(exist, Duration.ofSeconds(7))
                .scrollTo()
                .shouldBe(visible, Duration.ofSeconds(7))
                .click();
    }

    @Step("Клик по элементу с удержанием")
    public void clickAndHold(SelenideElement element, int holdMillis) {
        new Actions(WebDriverRunner.getWebDriver())
                .clickAndHold(element)
                .pause(holdMillis)
                .release()
                .perform();
    }
    @Step("Клик по элементу используя JS")
    public void clickWithJS(SelenideElement element){
        waitEnable(element, 7);
        element.click(ClickOptions.usingJavaScript());
    }
    // <-- КЛИКИ

    // ↑↑↑ МЕТОДЫ ДЕЙСТВИЙ ↑↑↑ <--

    //*********************//

    // ↓↓↓ МЕТОДЫ ПРОВЕРОК ↓↓↓ -->

    @Step("Ожидание отображение элемента {0}")
    public boolean waitVisible(SelenideElement element){
        return waitVisible(element, 7);
    }

    @Step("Ожидание отображение элемента {0}")
    public boolean waitVisible(SelenideElement element, int seconds){
        try {
            element.shouldBe(visible, Duration.ofSeconds(seconds));
            return true;
        } catch (AssertionError e) {
            return false;
        }
    }

    //"Проверка, что элемент виден в viewport", Поскольку waitVisible всегда выдает true
    public boolean isElementInViewport(SelenideElement element, int timeoutSeconds) {
        long endTime = System.currentTimeMillis() + timeoutSeconds * 1000L;
        while (System.currentTimeMillis() < endTime) {
            if ((Boolean) Selenide.executeJavaScript(
                    "const rect = arguments[0].getBoundingClientRect();" +
                            "return (" +
                            "    rect.top >= 0 &&" +
                            "    rect.left >= 0 &&" +
                            "    rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&" +
                            "    rect.right <= (window.innerWidth || document.documentElement.clientWidth)" +
                            ");", element)) {
                return true;
            }
            sleep(250); // Пауза между проверками
        }
        return false;
    }

    @Step("Ожидание скрытия элемента {0}")
    public boolean waitDisappear(SelenideElement element){
        return waitDisappear(element, 7);
    }

    @Step("Ожидание скрытия элемента {0}")
    public boolean waitDisappear(SelenideElement element, int seconds){
        try {
            element.shouldBe(disappear, Duration.ofSeconds(seconds));
            return true;
        } catch (AssertionError error){
            return false;
        }
    }

    @Step("Ожидание активности элемента: {0}")
    public boolean waitEnable(SelenideElement element){
        return waitEnable(element, 7);
    }

    @Step("Ожидание активности элемента {0}")
    public boolean waitEnable(SelenideElement element, int seconds){
        return element.shouldBe(enabled, Duration.ofSeconds(seconds)).isEnabled() && waitVisible(element);
    }

    @Step("Ожидание неактивности элемента: {0}")
    public boolean waitDisable(SelenideElement element){
        return waitDisable(element, 7);
    }

    @Step("Ожидание неактивности элемента {0}")
    public boolean waitDisable(SelenideElement element, int seconds){
        return !element.shouldBe(disabled, Duration.ofSeconds(seconds)).isEnabled();
    }

    @Step("Ожидание корректного текста элемента {0}")
    public boolean waitEqualsText(SelenideElement element, String expectedText){
        return waitEqualsText(element, expectedText, 7);
    }

    @Step("Ожидание корректного текста элемента {0}")
    public boolean waitEqualsText(SelenideElement element, String expectedText, int seconds){
       return element.shouldHave(ownText(expectedText), Duration.ofSeconds(seconds))
               .getOwnText().equals(expectedText);
    }

    @Step("Ожидание корректного текста элемента и его дочерних элементов {0}")
    public boolean waitEqualsTextBlock(SelenideElement element, String expectedText){
        return waitEqualsTextBlock(element, expectedText, 7);
    }

    @Step("Ожидание корректного текста элемента и его дочерних элементов  {0}")
    public boolean waitEqualsTextBlock(SelenideElement element, String expectedText, int seconds){
        return element.shouldHave(text(expectedText), Duration.ofSeconds(seconds))
                .getText().equals(expectedText);
    }

    // ↑↑↑ МЕТОДЫ ПРОВЕРОК ↑↑↑ <--
}
