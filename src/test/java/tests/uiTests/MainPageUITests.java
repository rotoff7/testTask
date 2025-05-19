package tests.uiTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.MainPage;
import pages.components.ContactsComponentPage;
import pages.components.ProductComponentPage;
import tests.UITestsInit;

import static enums.MainCategories.CONTACTS;
import static enums.MainCategories.PRODUCTS;
import static enums.TextData.CARD_DESIGNER_OPTION;

class MainPageUITests implements UITestsInit {
    MainPage mainPage;
    ProductComponentPage productComponentPage = new ProductComponentPage();
    ContactsComponentPage contactsComponentPage = new ContactsComponentPage();

    @Test
    @DisplayName("Боковое меню, работа кнопки управления \"Продукты\". Отображение блока пользователю")
    void navigationMenuProductBtnTest() {
        mainPage = BasePage.openApp()
                .waitMainPageLoaded()
                .clickOnMainMenuItem(PRODUCTS);
        productComponentPage
                .verifyProductsBlockDisplayed()
                .verifyGisPortalCard()
                .verifySmartlinkCard();
    }

    @Test
    @DisplayName("Просмотр информации о продукте. Smartlink - Конструктор визитки")
    void smartLinkCardDesignerOptionTest() {
        mainPage = BasePage.openApp()
                .waitMainPageLoaded()
                .clickOnMainMenuItem(PRODUCTS);
        productComponentPage
                .verifyProductsBlockDisplayed()
                .clickOnProductIndicator("SmartLink", "Конструктор визитки")
                .verifyModalOpened("Конструктор визитки")
                .verifyImageIsDisplayed()
                .verifyModalDescription(CARD_DESIGNER_OPTION.getMainText())
                .closeModal();
    }

    @Test
    @DisplayName("Форма обратной связи")
    void feedBackFormTest(){
        mainPage = BasePage.openApp()
                .waitMainPageLoaded()
                .clickOnMainMenuItem(CONTACTS);
        contactsComponentPage
                .verifyContactsBlockDisplayed()
                .openFeedBackForm()

                //Проверка дефолтного состояния формы (частичное)
                .verifyFeedBackFormOpened()
                .verifyGetCodeBtnDisabled()
                .verifyContactMeBtnDisabled()

                //Заполнение данных
                .inputFio("Маэль Дессандр") //FIXME Можно использовать генератор (написать метод в Utils)
                .inputEmail("example1@mail.ru") //FIXME Можно использовать генератор (написать метод в Utils)

                .verifyGetCodeBtnDisabled() // Проверка, что на этом моменте кнопка все еще неактивна
                .inputNumber("+9324628412") //FIXME Можно использовать генератор (написать метод в Utils)
                .verifyGetCodeBtnEnabled() // Проверка активации кнопки
                .inputCode("095423")//FIXME Можно использовать генератор (написать метод в Utils)

                // Активация чекбоксов
                .enablePersonalDataChb()
                .enablePrivacyPolicy()

                .verifyContactMeBtnDisabled() // Проверка, что на этом моменте кнопка все еще неактивна
                .enableUserAgreementChb()
                .verifyContactMeBtnEnabled() // Проверка активации кнопки

                .cancelFeedBackForm(); //Выход из окна обратной связи


    }


}
