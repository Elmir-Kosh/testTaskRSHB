package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.assertEquals;

public class DepositsAndSavingsPage extends BasePage {
    private static final String DEPOSITS_AND_SAVINGS = "//a[contains(@class, \"b-page-head-menu-item\") and text() = \"Вклады и сбережения\"]";
    private static final String SAVINGS_ACCOUNT = "//div[@class=\"b-sections-menu-item-text -withlink\"]//a[text()=\"Накопительный счет\"]";
    private static final String CALCULATION_OF_PROFITABILITY = "//a[@class=\"b-btn\"]";
    private static final String EXPECTED_MY_BENEFIT = "//td[text()=\"5.5%\"]";
    private static final String EXPECTED_MY_PIGGY_BANK = "//td[text()=\"5%\"]";
    private static final String EXPECTED_MY_BANK_ACCOUNT = "//td[text()=\"4%\"]";
    private static final String EXPECTED_ULTRA = "//*[@id=\"deposit_451946\"]//following::td[text()=\"0.01%\"][1]";
    private static final String EXPECTED_PREMIUM = "//*[@id=\"deposit_451946\"]//following::td[text()=\"0.01%\"][2]";
    private static final String EXPECTED_BEFORE_DEMAND = "//*[@id=\"deposit_451946\"]//following::td[text()=\"0.01%\"][1]";

    private static final String ACTUAL_MY_BENEFIT = "5.5%";
    private static final String ACTUAL_MY_PIGGY_BANK = "5%";
    private static final String ACTUAL_MY_BANK_ACCOUNT = "4%";
    private static final String ACTUAL_ULTRA = "0.01%";
    private static final String ACTUAL_PREMIUM = "0.01%";
    private static final String ACTUAL_BEFORE_DEMAND = "0.01%";

    /**
     * переход на страницу "расчет доходности по сбережениям"
     */
    public DepositsAndSavingsPage depositsAndSavingsGet() {
        click(By.xpath(DEPOSITS_AND_SAVINGS));
        Actions actions = new Actions(driver);
        WebElement savingsAccount = driver.findElement(By.xpath(SAVINGS_ACCOUNT));
        actions.moveToElement(savingsAccount).click().build().perform();
        WebElement buttonCalculation = driver.findElement(By.xpath(CALCULATION_OF_PROFITABILITY));
        actions.moveToElement(buttonCalculation).click().build().perform();
        return this;
    }

    /**
     * проверка значений в таблице "Вклады и сбережения"
     */
    public DepositsAndSavingsPage tableCheck() {
        Actions actions = new Actions(driver);
        WebElement myBenefit = driver.findElement(By.xpath(EXPECTED_MY_BENEFIT));
        actions.moveToElement(myBenefit).click().build().perform();
        assertEquals(ACTUAL_MY_BENEFIT, driver.findElement(By.xpath(EXPECTED_MY_BENEFIT)).getText());
        WebElement myPiggyBank = driver.findElement(By.xpath(EXPECTED_MY_PIGGY_BANK));
        actions.moveToElement(myPiggyBank).click().build().perform();
        assertEquals(ACTUAL_MY_PIGGY_BANK, driver.findElement(By.xpath(EXPECTED_MY_PIGGY_BANK)).getText());
        WebElement myBankAccount = driver.findElement(By.xpath(EXPECTED_MY_BANK_ACCOUNT));
        actions.moveToElement(myBankAccount).click().build().perform();
        assertEquals(ACTUAL_MY_BANK_ACCOUNT, driver.findElement(By.xpath(EXPECTED_MY_BANK_ACCOUNT)).getText());
        WebElement ultra = driver.findElement(By.xpath(EXPECTED_ULTRA));
        actions.moveToElement(ultra).click().build().perform();
        assertEquals(ACTUAL_ULTRA, driver.findElement(By.xpath(EXPECTED_ULTRA)).getText());
        WebElement premium = driver.findElement(By.xpath(EXPECTED_PREMIUM));
        actions.moveToElement(premium).click().build().perform();
        assertEquals(ACTUAL_PREMIUM, driver.findElement(By.xpath(EXPECTED_PREMIUM)).getText());
        WebElement beforeDemand = driver.findElement(By.xpath(EXPECTED_BEFORE_DEMAND));
        actions.moveToElement(beforeDemand).click().build().perform();
        assertEquals(ACTUAL_BEFORE_DEMAND, driver.findElement(By.xpath(EXPECTED_BEFORE_DEMAND)).getText());

        return this;
    }
}
