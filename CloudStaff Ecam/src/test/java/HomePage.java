import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends main{

    public Helpers Helpers;
    public WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        Helpers = new Helpers(driver);
    }

    public void search(String value)
    {
        driver.findElement(By.xpath("//input[@id='searchbox']")).sendKeys(value);
        driver.findElement(By.xpath("//input[@id='searchsubmit']")).click();
    }

    public void openComputer(String value)
    {
        search(value);
        driver.findElement(By.xpath("//a[text()='"+value+"']")).click();
    }

    public boolean validateAlertText(String value)
    {
        WebElement alert = driver.findElement(By.xpath("//div[@class='alert-message warning']"));
        alert.isDisplayed();

        return alert.getText().equalsIgnoreCase(value);
    }

    public boolean validateSearch(String value)
    {
        try {
            return driver.findElement(By.xpath("//a[text()='" + value + "']")).isDisplayed();
        }
        catch (Exception e)
        {
            System.out.println(value+" not found.");
            return false;
        }

    }
}

