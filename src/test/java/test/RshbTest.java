package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.*;

public class RshbTest extends BasePage {
    MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
    LoanWithoutCollateralSalaryRshbPage lwcsr = PageFactory.initElements(driver, LoanWithoutCollateralSalaryRshbPage.class);
    LoanWithoutCollateralSalaryRshbInsuranceProtectionPage lwcsrip = PageFactory.initElements(driver, LoanWithoutCollateralSalaryRshbInsuranceProtectionPage.class);
    DepositsAndSavingsPage ds = PageFactory.initElements(driver, DepositsAndSavingsPage.class);

    @Test
    public void openSiteTest() {
        mainPage.smokeMainPage();
    }

    @Test
    public void loanWithoutCollateralSalaryRshbTest() {
        mainPage
                .mainPagePrivatePerson();
        lwcsr
                .creditCalculation()
                .creditSumSet()
                .creditPeriodSet()
                .choiceCheckboxes()
                .valuesCheck();
    }

    @Test
    public void loanWithoutCollateralSalaryRshbInsuranceProtectionTest() {
        mainPage
                .mainPagePrivatePerson();
        lwcsrip
                .creditCalculation()
                .creditSumSet()
                .creditPeriodSet()
                .choiceCheckboxes()
                .valuesCheck();
    }

    @Test
    public void depositAndSavingsTest() {
        mainPage
                .mainPagePrivatePerson();
        ds
                .depositsAndSavingsGet()
                .tableCheck();
    }

}
