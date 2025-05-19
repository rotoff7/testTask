package pages;

import enums.MainCategories;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static selectors.pages.MainPageSelectors.lstSideBarOptions;
import static selectors.pages.MainPageSelectors.mainLogo;

public class MainPage extends BasePage {

    @Step("Ожидание загрузки главной страницы")
    public MainPage waitMainPageLoaded(){
        assertTrue(waitVisible(mainLogo), "Ошибка загрузки главной страницы сайта");
        assertTrue(waitVisible(lstSideBarOptions.first()), "Ошибка отображения основного меню");
        return this;
    }

    @Step("Клик по {0} в основном меню")
    public MainPage clickOnMainMenuItem(MainCategories category){
        lstSideBarOptions.filterBy(text(category.getName())).first().hover().click();
        return this;
    }


}
