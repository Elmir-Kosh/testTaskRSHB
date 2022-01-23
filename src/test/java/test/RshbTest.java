package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CreditsPage;
import pages.MainPage;

public class RshbTest extends BasePage {
    MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
    CreditsPage creditsPage = PageFactory.initElements(driver, CreditsPage.class);

    @Test
    public void openSiteTest() {
        mainPage.smokeMainPage();
    }

    @Test
    public void mainPagePrivatePersonTest() {
        mainPage.mainPagePrivatePerson();
        creditsPage.creditCalculation()
                .creditSumSet()
                .creditPeriodSet()
                .choiceCheckboxes()
                .valuesCheck();
    }

}
