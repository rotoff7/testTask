package enums;

public enum MainCategories {
    ABOUT_US("О нас"),
    PRODUCTS("Продукты"),
    TECH_STACK("Стек технологий"),
    SOCIAL_LIFE("Социальная жизнь"),
    NEWS("Новости"),
    CAREER("Карьера"),
    CONTACTS("Контакты");

    private String name;
    public String getName() {
        return name;
    }
    MainCategories(String name) {
        this.name = name;
    }


}
