package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.assertEquals;

public class DepositsAndSavingsPage extends BasePage {
    private static final String DEPOSITS_AND_SAVINGS = "//a[contains(@class, \"b-page-head-menu-item\") and text() = \"Вклады и сбережения\"]";
    private static final String SAVINGS_ACCOUNT = "//div[@class=\"b-sections-menu-item-text -withlink\"]//a[text()=\"Накопительный счет\"]";
    private static final String CALCULATION_OF_PROFITABILITY = "//a[@class=\"b-btn\"]";
    private static final String EXPECTED_МОЯ_ВЫГОДА = "//td[text()=\"5.5%\"]";
    private static final String EXPECTED_МОЯ_КОПИЛКА = "//td[text()=\"5%\"]";
    private static final String EXPECTED_МОЙ_СЧЕТ = "//td[text()=\"4%\"]";
    private static final String EXPECTED_УЛЬТРА = "//*[@id=\"deposit_451946\"]//following::td[text()=\"0.01%\"][1]";
    private static final String EXPECTED_ПРЕМИУМ = "//*[@id=\"deposit_451946\"]//following::td[text()=\"0.01%\"][2]";
    private static final String EXPECTED_ДО_ВОСТРЕБОВАНИЯ = "//*[@id=\"deposit_451946\"]//following::td[text()=\"0.01%\"][1]";
    private static final String ACTUAL_МОЯ_ВЫГОДА = "5.5%";
    private static final String ACTUAL_МОЯ_КОПИЛКА = "5%";
    private static final String ACTUAL_МОЙ_СЧЕТ = "4%";
    private static final String ACTUAL_УЛЬТРА = "0.01%";
    private static final String ACTUAL_ПРЕМИУМ = "0.01%";
    private static final String ACTUAL_ДО_ВОСТРЕБОВАНИЯ = "0.01%";


    public DepositsAndSavingsPage depositsAndSavingsGet() {
        click(By.xpath(DEPOSITS_AND_SAVINGS));
        Actions actions = new Actions(driver);
        WebElement savingsAccount = driver.findElement(By.xpath(SAVINGS_ACCOUNT));
        actions.moveToElement(savingsAccount).click().build().perform();
        WebElement buttonCalculation = driver.findElement(By.xpath(CALCULATION_OF_PROFITABILITY));
        actions.moveToElement(buttonCalculation).click().build().perform();
        return this;
    }

    public DepositsAndSavingsPage tableCheck() {
        Actions actions = new Actions(driver);
        WebElement мояВыгода = driver.findElement(By.xpath(EXPECTED_МОЯ_ВЫГОДА));
        actions.moveToElement(мояВыгода).click().build().perform();
        assertEquals(ACTUAL_МОЯ_ВЫГОДА, driver.findElement(By.xpath(EXPECTED_МОЯ_ВЫГОДА)).getText());
        WebElement мояКопилка = driver.findElement(By.xpath(EXPECTED_МОЯ_КОПИЛКА));
        actions.moveToElement(мояКопилка).click().build().perform();
        assertEquals(ACTUAL_МОЯ_КОПИЛКА, driver.findElement(By.xpath(EXPECTED_МОЯ_КОПИЛКА)).getText());
        WebElement мойСчет = driver.findElement(By.xpath(EXPECTED_МОЙ_СЧЕТ));
        actions.moveToElement(мойСчет).click().build().perform();
        assertEquals(ACTUAL_МОЙ_СЧЕТ, driver.findElement(By.xpath(EXPECTED_МОЙ_СЧЕТ)).getText());
        WebElement ультра = driver.findElement(By.xpath(EXPECTED_УЛЬТРА));
        actions.moveToElement(ультра).click().build().perform();
        assertEquals(ACTUAL_УЛЬТРА, driver.findElement(By.xpath(EXPECTED_УЛЬТРА)).getText());
        WebElement премиум = driver.findElement(By.xpath(EXPECTED_ПРЕМИУМ));
        actions.moveToElement(премиум).click().build().perform();
        assertEquals(ACTUAL_ПРЕМИУМ, driver.findElement(By.xpath(EXPECTED_ПРЕМИУМ)).getText());
        WebElement доВостребования = driver.findElement(By.xpath(EXPECTED_ДО_ВОСТРЕБОВАНИЯ));
        actions.moveToElement(доВостребования).click().build().perform();
        assertEquals(ACTUAL_ДО_ВОСТРЕБОВАНИЯ, driver.findElement(By.xpath(EXPECTED_ДО_ВОСТРЕБОВАНИЯ)).getText());

        return this;
    }
}
