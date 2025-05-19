package selectors.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;

public class ProductComponentSelectors {
    public static SelenideElement
            productComponentTitle = $(xpath("//h2[@class='products-title']")),

    //ГИС-портал ОКЕАН
            gisPortalCard = $(xpath("//h2[text()=' ГИС-портал ОКЕАН ']/ancestor::div[contains(@class, 'product-card')]")),
            gisPortalCardDescription = $(gisPortalCard.find(xpath("descendant::div[@class='overview']"))),
            gisPortalCardVideo = $(gisPortalCard.find(xpath("descendant::video"))),

    //Smartlink
            smartLinkCard = $(xpath("//h2[text()=' Smartlink ']/ancestor::div[contains(@class, 'product-card')]")),
            smartLinkCardDescription = $(smartLinkCard.find(xpath("descendant::div[@class='overview']"))),
            smartLinkCardVideo = $(smartLinkCard.find(xpath("descendant::video")));

    public static ElementsCollection
            gisPortalCardOptions = $$(gisPortalCard.$$(xpath("descendant::div[contains(@class, 'product-feature ')]"))),
            smartLinkCardOptions = $$(smartLinkCard.$$(xpath("descendant::div[contains(@class, 'product-feature ')]")));


}
