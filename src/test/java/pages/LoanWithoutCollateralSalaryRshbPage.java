package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.assertEquals;

public class LoanWithoutCollateralSalaryRshbPage extends BasePage {
    private static final String CREDITS = "//a[contains(@class, \"b-page-head-menu-item-nobanner link\") and text() = \"Кредиты\"]";
    private static final String LOAN_WITHOUT_COLLATERAL = "//a[contains(@class, \"linkip\") and text() = \"Потребительский кредит без обеспечения\"]";
    private static final String BUTTON_ANNUITY = "//button[contains(@class,\"menu-switch__item menu-switch__item--selected\") and text()=\"Аннуитетный\"]";
    private static final String FIELD_CREDIT_SUM = "//input[@class=\"slider__input\"]";
    private static final String FIELD_CREDIT_PERIOD = "//div[@class=\"loan-calculator__slider-wrapper\"][2]//input[@class=\"slider__input\"]";
    private static final String FIELD_PAY = "//div[@class=\"loan-calculator-result__value loan-calculator-result__value--green\"]";
    private static final String FIELD_RATE = "//div[@class=\"loan-calculator-result__value\"]";
    private static final String COOKIE = "//button[@class=\"cookie-consent__submit-button button button__white\"]";
    private static final String FIELD_CALCULATOR = "//div[@class=\"loan__calculator-wrapper\"]";
    private static final String CHECKBOX_RSHB_SALARY = "//input[@class=\"ant-checkbox-input\"]";
    private static final String CHECKBOX_BUDGET_ORGANIZATION_SALARY = "//div[@class=\"loan-calculator__switch-block\"][2]//input[@class=\"ant-checkbox-input\"]";
    private static final String CHECKBOX_INSURANCE_PROTECTION = "//div[@class=\"loan-calculator__switch-block\"][3]//input[@class=\"ant-checkbox-input\"]";
    private static final String ACTUAL_PAY_VALUE = "56 118 ₽";
    private static final String ACTUAL_RATE_VALUE = "12.4%";
    private static final String CREDIT_SUM = "2500000";
    private static final String CREDIT_PERIOD = "60";
    private Object TakesScreenshot;


    public LoanWithoutCollateralSalaryRshbPage creditCalculation() {
        click(By.xpath(CREDITS));
        Actions actions = new Actions(driver);
        WebElement loanWithoutCollateral = driver.findElement(By.xpath(LOAN_WITHOUT_COLLATERAL));
        actions.moveToElement(loanWithoutCollateral).click().build().perform();
        if (driver.findElement(By.xpath(COOKIE)).isDisplayed())
            click(By.xpath(COOKIE));
        WebElement buttonAnnuity = driver.findElement(By.xpath(BUTTON_ANNUITY));
        actions.moveToElement(buttonAnnuity).click().build().perform();
        return this;
    }

    public LoanWithoutCollateralSalaryRshbPage creditSumSet() {
        clearInput(By.xpath(FIELD_CREDIT_SUM));
        sendKeys(By.xpath(FIELD_CREDIT_SUM), CREDIT_SUM.substring(0, (CREDIT_SUM.length() - 1)));
        click(By.xpath(FIELD_CALCULATOR));
        return this;
    }

    public LoanWithoutCollateralSalaryRshbPage creditPeriodSet() {
        Actions actions = new Actions(driver);
        WebElement fieldCreditPeriod = driver.findElement(By.xpath(FIELD_CREDIT_PERIOD));
        actions.moveToElement(fieldCreditPeriod).click().build().perform();
        clearInput(By.xpath(FIELD_CREDIT_PERIOD));
        sendKeys(By.xpath(FIELD_CREDIT_PERIOD), CREDIT_PERIOD.substring(0, (CREDIT_PERIOD.length() - 1)));
        click(By.xpath(FIELD_CALCULATOR));
        return this;
    }

    public LoanWithoutCollateralSalaryRshbPage choiceCheckboxes() {
        WebElement checkboxRshbSalary = driver.findElement(By.xpath(CHECKBOX_RSHB_SALARY));
        Actions actions = new Actions(driver);
        actions.moveToElement(checkboxRshbSalary).build().perform();
        if (!checkboxRshbSalary.isSelected())
            checkboxRshbSalary.click();
        WebElement checkboxBudgetOrganizationSalary = driver.findElement(By.xpath(CHECKBOX_BUDGET_ORGANIZATION_SALARY));
        actions.moveToElement(checkboxBudgetOrganizationSalary).build().perform();
        if (checkboxBudgetOrganizationSalary.isSelected())
            checkboxBudgetOrganizationSalary.click();
        WebElement checkboxInsuranceProtection = driver.findElement(By.xpath(CHECKBOX_INSURANCE_PROTECTION));
        actions.moveToElement(checkboxInsuranceProtection).build().perform();
        if (checkboxInsuranceProtection.isSelected())
            checkboxInsuranceProtection.click();
        return this;
    }

    public LoanWithoutCollateralSalaryRshbPage valuesCheck() {
        assertEquals(ACTUAL_RATE_VALUE, driver.findElement(By.xpath(FIELD_RATE)).getText());
        assertEquals(ACTUAL_PAY_VALUE, driver.findElement(By.xpath(FIELD_PAY)).getText());
        return this;
    }


}

