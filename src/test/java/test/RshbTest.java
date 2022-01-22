package test;

import Pages.BasePage;
import Pages.CreditsPage;
import Pages.MainPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class RshbTest extends BasePage {
    MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
    CreditsPage creditsPage = PageFactory.initElements(driver, CreditsPage.class);

    @Test
    public void openSiteTest() {
        mainPage.smokeMainPage();
    }

    @Test
    public void mainPagePrivatePersonTest(){
        mainPage.mainPagePrivatePerson();
        creditsPage.creditCalculation();
    }

}
