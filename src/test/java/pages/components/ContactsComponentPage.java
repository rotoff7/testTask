package pages.components;

import io.qameta.allure.Step;
import pages.BasePage;
import pages.modals.FeedBackFormPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static selectors.components.ContactsComponentSelectors.btnContactUs;
import static selectors.components.ContactsComponentSelectors.contactsComponentTitle;


public class ContactsComponentPage extends BasePage {

    @Step("Открыть окно 'Связаться с нами'")
    public FeedBackFormPage openFeedBackForm(){
        btnContactUs.click();
        return new FeedBackFormPage();
    }

    // ASSERTS
    @Step("Проверка отображения раздела 'Контакты'")
    public ContactsComponentPage verifyContactsBlockDisplayed(){
        verifyContactTitle();
        //Можно добавить несколько ассертов
        return this;
    }

    private void verifyContactTitle(){
        assertTrue(waitVisible(contactsComponentTitle),
                "Ошибка отображения заголовка блока 'Продукты'");
        assertTrue(isElementInViewport(contactsComponentTitle, 1), "Элемент вне видимости окна пользователя");
    }
}
