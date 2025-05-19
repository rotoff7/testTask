package pages.modals;

import io.qameta.allure.Step;
import pages.BasePage;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static selectors.modals.DefaultModalSelectors.*;

public class DefaultModalPage extends BasePage {

    //ACTIONS
    @Step("Закрытие модального окна")
    public MainPage closeModal(){
        btnModalClose.hover();
        clickWithJS(btnModalClose);
        assertTrue(waitDisappear(modalWindow), "Ошибка закрытия МО");
        return new MainPage();
    }

    //ASSERTS
    @Step("Проверка открытия МО")
    public DefaultModalPage verifyModalOpened(String modalName){
        assertTrue(waitVisible(modalWindow), "Ошибка открытия МО: " + modalName);
        assertEquals(modalName, modalTitle.getText(), "Некорректное названия МО.\n" +
                "Ожидаемый результат: " + modalName + "\n" +
                "Фактический результат: " + modalTitle.getText());
        return this;
    }

    @Step("Проверка отображения изображения в МО")
    public DefaultModalPage verifyImageIsDisplayed(){
        assertTrue(waitVisible(modalImage), " Ошибка отображения изображения в модальном окне");
        return this;
    }

    @Step("Проверка описания в МО")
    public DefaultModalPage verifyModalDescription(String text){
        assertEquals(text, modalDescription.getText(), "Некорректное описание МО");
        return this;
    }

}
