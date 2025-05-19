package selectors.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class ContactsComponentSelectors {
    public static SelenideElement
            contactsComponentTitle = $(xpath("//h2[@class='contacts-title']")),
            btnContactUs =$(xpath("//span[text()=' Связаться с нами ']"));
}
