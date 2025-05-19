package selectors.modals;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class FeedBackFormSelectors {
    public static SelenideElement
            feedBackModalTitle = $(xpath("//contact-us//h2[text()='Связаться с нами']")),
            fioField = $(xpath("//contact-us//input[@formcontrolname='fio']")),
            emailField = $(xpath("//contact-us//input[@formcontrolname='email']")),
            phoneField = $(xpath("//contact-us//input[@formcontrolname='phone']")),
            codeField = $(xpath("//contact-us//input[@formcontrolname='code']")),
            btnGetCode= $(xpath("//contact-us//span[text()=' Получить код подтверждения ']/..")),
            chbPersonalData = $(xpath("//contact-us//mat-checkbox[@formcontrolname='agreement1']//input")),
            chbPrivacyPolicy = $(xpath("//contact-us//mat-checkbox[@formcontrolname='agreement2']//input")),
            chbUserAgreement = $(xpath("//contact-us//mat-checkbox[@formcontrolname='agreement3']//input")),
            btnCancel = $(xpath("//contact-us//span[text()=' Отмена ']")),
            btnContactMe = $(xpath("//contact-us//span[text()=' Свяжитесь со мной ']/.."));


}
