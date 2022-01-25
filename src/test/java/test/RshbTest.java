package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.*;

public class RshbTest extends BaseTest {
    MainTest mainPage = PageFactory.initElements(driver, MainTest.class);
    LoanWithoutCollateralSalaryRshbTest lwcsr = PageFactory.initElements(driver, LoanWithoutCollateralSalaryRshbTest.class);
    LoanWithoutCollateralSalaryRshbInsuranceProtectionTest lwcsrip = PageFactory.initElements(driver, LoanWithoutCollateralSalaryRshbInsuranceProtectionTest.class);
    DepositsAndSavingsTest ds = PageFactory.initElements(driver, DepositsAndSavingsTest.class);

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
