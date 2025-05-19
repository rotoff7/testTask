package selectors;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class MainPageSelectors {
     public static SelenideElement
             mainLogo = $(".main-title");

     public static ElementsCollection
               lstCategoryCard = $$(xpath("//main-menu//nav//a"));
}
