package selectors.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class MainPageSelectors {
     public static SelenideElement
             mainLogo = $(xpath("//h1[@class='main-title' and text()='Русская морская команда']"));
               //Сразу вшиваем корректный текст заголовка

     public static ElementsCollection
             lstSideBarOptions = $$(xpath("//main-menu//nav//a"));
}
