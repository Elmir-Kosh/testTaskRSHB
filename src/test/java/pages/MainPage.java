package pages;

import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private static final String SITE_URL = "https://www.rshb.ru/";
    private static final String LINK_PRIVATE_PERSON = "//a[@class=\"header__section-link header__section-link_active\"]";
    private static final String COOKIE = "//button[@class=\"btn-standart\"]";


    public MainPage smokeMainPage() {
        openSite(SITE_URL);
        return this;
    }

    public MainPage mainPagePrivatePerson() {
        openSite(SITE_URL);
        if (driver.findElement(By.xpath(COOKIE)).isDisplayed()) {
            click(By.xpath(COOKIE));
        }
        click(By.xpath(LINK_PRIVATE_PERSON));
        return this;
    }
}
