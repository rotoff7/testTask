package selectors.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class ProductComponent {
    public static SelenideElement
    title = $(xpath("//h2[@class='products-title']"));

}
