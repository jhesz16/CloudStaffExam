import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Helpers
{
    public WebDriver driver;
    public WebDriverWait wait;

    public Helpers(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 2000);
    }
    public WebElement GetElement(String xPath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        return driver.findElement(By.xpath(xPath));
    }

    public List<WebElement> GetElements(String xPath) {
        return driver.findElements(By.xpath(xPath));
    }

    public void ClickElement(String xPath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
        GetElement(xPath).click();
    }


    public boolean ValidateElementDisplayed(String xPath) {
        try
        {
            driver.findElement(By.xpath(xPath));
        }
        catch (Exception e)
        {
            return false;
        }
        return driver.findElement(By.xpath(xPath)).isDisplayed();
    }

    public WebElement ValidateElement(String xPath) {
        return GetElement(xPath);
    }

    public WebDriver DriverSetup()
    {
        WebDriverManager.chromedriver().browserVersion("77.0.3865.40").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        driver.get("http://jupiter.cloud.planittesting.com");

        return driver;
    }

    public void SetField(String xpath, String val)
    {
        GetElement(xpath).sendKeys(val);
    }

}
