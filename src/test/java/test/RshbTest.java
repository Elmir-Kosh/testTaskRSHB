package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.*;

public class RshbTest extends BasePage {
    MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
    LoanWithoutCollateralSalaryRshbPage loanWithoutCollateralSalaryRshbPage = PageFactory.initElements(driver, LoanWithoutCollateralSalaryRshbPage.class);
    LoanWithoutCollateralSalaryRshbInsuranceProtectionPage loanWithoutCollateralSalaryRshbInsuranceProtectionPage = PageFactory.initElements(driver, LoanWithoutCollateralSalaryRshbInsuranceProtectionPage.class);
    DepositsAndSavingsPage depositsAndSavingsPage = PageFactory.initElements(driver, DepositsAndSavingsPage.class);
    @Test
    public void openSiteTest() {
        mainPage.smokeMainPage();
    }

    //Test case №1
    @Test
    public void loanWithoutCollateralSalaryRshbTest() {
        mainPage.mainPagePrivatePerson();
        loanWithoutCollateralSalaryRshbPage.creditCalculation()
                .creditSumSet()
                .creditPeriodSet()
                .choiceCheckboxes()
                .valuesCheck();
    }

    //Test case №2
    @Test
    public void loanWithoutCollateralSalaryRshbInsuranceProtectionTest(){
        mainPage.mainPagePrivatePerson();
        loanWithoutCollateralSalaryRshbInsuranceProtectionPage.creditCalculation()
                .creditSumSet()
                .creditPeriodSet()
                .choiceCheckboxes()
                .valuesCheck();
    }

    //Test case №3
    @Test
    public void depositAndSavingsTest(){
        mainPage.mainPagePrivatePerson();
        depositsAndSavingsPage.depositsAndSavingsGet()
                .tableCheck();
    }

}
