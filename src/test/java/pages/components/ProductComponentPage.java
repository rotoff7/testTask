package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.TextData;
import io.qameta.allure.Step;
import pages.BasePage;
import pages.modals.DefaultModalPage;

import static com.codeborne.selenide.Condition.text;
import static org.junit.jupiter.api.Assertions.*;
import static selectors.components.ProductComponentSelectors.*;

public class ProductComponentPage extends BasePage {

    //ACTIONS
    @Step("Клик по показателю {0} в карточке продукта")
    public DefaultModalPage clickOnProductIndicator(String productName, String name){
        ElementsCollection options = gisPortalCardOptions;
        if (productName.trim().equalsIgnoreCase("Smartlink")) options = smartLinkCardOptions;

        options.filter(text(name)).first().click();
        return new DefaultModalPage();
    }

    // ASSERTS
    @Step("Проверка отображения раздела 'Продукты'")
    public ProductComponentPage verifyProductsBlockDisplayed(){
        verifyProductTitle();
        assertAll(
                () -> assertTrue(waitVisible(gisPortalCard), "Ошибка отображения карточки ГИС-портал ОКЕАН"),
                () -> assertTrue(waitVisible(smartLinkCard), "Ошибка отображения карточки Smartlink")
        );
        return this;
    }

    private void verifyProductTitle(){
        assertTrue(waitVisible(productComponentTitle),
                "Ошибка отображения заголовка блока 'Продукты'");
        assertTrue(isElementInViewport(productComponentTitle, 1), "Элемент вне видимости окна пользователя");
    }

    @Step("Валидация карточки ГИС-портал ОКЕАН")
    public ProductComponentPage verifyGisPortalCard(){
        assertEquals(TextData.GIS_PORTAL_DESCRIPTION.getMainText(), gisPortalCardDescription.getText(),
                "Некорректное описание");
        assertTrue(waitVisible(gisPortalCardVideo), "Не отображается видеоролик");
        verifyCardsOptions(gisPortalCardOptions);
        return this;
    }

    @Step("Валидация карточки Smartlink")
    public ProductComponentPage verifySmartlinkCard(){
        assertEquals(TextData.SMARTLINK_DESCRIPTION.getMainText(), smartLinkCardDescription.getText(),
                "Некорректное описание");
        assertTrue(waitVisible(smartLinkCardVideo), "Не отображается видеоролик");
        verifyCardsOptions(smartLinkCardOptions);
        return this;
    }

    private void verifyCardsOptions(ElementsCollection options){
        assertEquals(4, options.size(), "Некорректное отображаемое кол-во показателей продукта");
        for (SelenideElement element : options) {
            assertTrue(element.isDisplayed(), "Ошибка отображения показателя");
        }
    }

}
