package pages.modals;

import io.qameta.allure.Step;
import pages.BasePage;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.*;
import static selectors.modals.FeedBackFormSelectors.*;

public class FeedBackFormPage extends BasePage {

    //ACTIONS
    @Step("Заполнение ФИО")
    public FeedBackFormPage inputFio(String fio){
        fioField.sendKeys(fio);
        return this;
    }
    @Step("Заполнение почты")
    public FeedBackFormPage inputEmail(String email){
        emailField.sendKeys(email);
        return this;
    }
    @Step("Заполнение номера телефона")
    public FeedBackFormPage inputNumber(String number){
        phoneField.sendKeys(number);
        return this;
    }
    @Step("Заполнение кода подтверждения")
    public FeedBackFormPage inputCode(String code){
        codeField.sendKeys(code);
        return this;
    }

    @Step("Активация чек-бокса персональных данных")
    public FeedBackFormPage enablePersonalDataChb(){
        if(!chbPersonalData.isSelected()) chbPersonalData.click();
        return this;
    }
    @Step("Активация чек-бокса политики конфиденциальности")
    public FeedBackFormPage enablePrivacyPolicy(){
        if(!chbPrivacyPolicy.isSelected()) chbPrivacyPolicy.click();
        return this;
    }
    @Step("Активация чек-бокса пользовательского соглашения")
    public FeedBackFormPage enableUserAgreementChb(){
        if(!chbUserAgreement.isSelected()) chbUserAgreement.click();
        return this;
    }

    @Step("Отмена и закрытие формы обратной связи")
    public MainPage cancelFeedBackForm(){
        btnCancel.click();
        assertTrue(waitDisappear(feedBackModalTitle), "Ошибка закрытия формы обратной связи");
        return new MainPage();
    }

    //ASSERTS
    @Step("Проверка открытия МО")
    public FeedBackFormPage verifyFeedBackFormOpened(){
        assertTrue(waitVisible(feedBackModalTitle), "Ошибка открытия формы обратной связи");
        return this;
    }

    @Step("Проверка, что кнопка 'Получить код подтверждения' неактивна")
    public FeedBackFormPage verifyGetCodeBtnDisabled(){
        assertTrue(waitDisable(btnGetCode, 1), "Кнопка 'Получить код подтверждения' активна");
        return this;
    }

    @Step("Проверка, что кнопка 'Получить код подтверждения' активна")
    public FeedBackFormPage verifyGetCodeBtnEnabled(){
        assertTrue(waitEnable(btnGetCode), "Кнопка 'Получить код подтверждения' неактивна");
        return this;
    }

    @Step("Проверка, что кнопка 'Свяжитесь со мной' неактивна")
    public FeedBackFormPage verifyContactMeBtnDisabled(){
        assertTrue(waitDisable(btnContactMe, 1), "Кнопка 'Свяжитесь со мной' активна");
        return this;
    }

    @Step("Проверка, что кнопка 'Свяжитесь со мной' активна")
    public FeedBackFormPage verifyContactMeBtnEnabled(){
        assertTrue(waitEnable(btnContactMe), "Кнопка 'Свяжитесь со мной' неактивна");
        return this;
    }
}
