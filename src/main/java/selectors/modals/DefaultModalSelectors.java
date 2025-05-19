package selectors.modals;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class DefaultModalSelectors {
    public static SelenideElement
            modalWindow = $(xpath("//*[contains(@class, 'dialog-component')]")),
            modalTitle = $(modalWindow.find(xpath("descendant::*[@class='id']"))),
            btnModalClose = $(modalWindow.find(xpath("descendant::*[@class='close-icon']"))),
            modalImage = $(modalWindow.find(xpath("descendant::img[1]"))),
            modalDescription = $(modalWindow.find(xpath("descendant::p[1]")));
}
