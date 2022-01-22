package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class BasePage {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void start() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
    }

    @AfterClass
    public void finish() {
        driver.quit();
    }


    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    //openSite Method
    public void openSite(String SITE_URL){
        driver.get(SITE_URL);
    }

    //Click Method
    public void click(By elementBy){
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    //sendKeys Method
    public void sendKeys(By elementBy, String number){
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(number);
    }

    //clearInput Method
    public void clearInput(By elementBy){
//        wait.until(ExpectedConditions.elementToBeClickable(elementBy)).click();
//        driver.findElement(elementBy).clear();
        WebElement clearField = driver.findElement(elementBy);
        wait.until(ExpectedConditions.elementToBeClickable(elementBy)).click();
        clearField.sendKeys(Keys.CONTROL + "a");
        clearField.sendKeys(Keys.DELETE);
    }

    //is Element Displayed
    public void isElementDisplayed(By elementBy){
        waitVisibility(elementBy);
        assertTrue(driver.findElement(elementBy).isDisplayed());
    }


}
