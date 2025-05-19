package pages;

import io.qameta.allure.Step;

public class MainPage extends BasePage {

    @Step("Ожидание загрузки главной страницы")
    public MainPage waitMainPageLoaded(){

        return this;
    }



}
