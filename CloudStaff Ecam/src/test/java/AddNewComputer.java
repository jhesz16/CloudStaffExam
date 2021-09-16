import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddNewComputer extends main{

    public Helpers Helpers;
    public WebDriver driver;

    public AddNewComputer(WebDriver driver)
    {
        this.driver = driver;
        Helpers = new Helpers(driver);
    }

    public void clickAddNewComputer()
    {
        WebElement addNewComputer =  driver.findElement(By.xpath("//a[text()='Add a new computer']"));
        addNewComputer.click();
    }

    public void fill(String name,String introduced,String discontinued,String company)
    {
        if(!name.equals(""))
        {
            driver.findElement(By.xpath("//input[@id='name']")).clear();
            driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
        }

        if(!introduced.equals(""))
        {
            driver.findElement(By.xpath("//input[@id='introduced']")).sendKeys(introduced);
        }

        if(!discontinued.equals(""))
        {
            driver.findElement(By.xpath("//input[@id='discontinued']")).sendKeys(discontinued);
        }

        if(!company.equals(""))
        {
            Select companyDropdown = new Select(driver.findElement(By.xpath("//select[@id='company']")));
            companyDropdown.selectByVisibleText(company);
        }



    }

    public void clickSubmit()
    {
        driver.findElement(By.xpath("//*[@value='Create this computer']")).click();
    }

    public void clickSave()
    {
        driver.findElement(By.xpath("//*[@value='Save this computer']")).click();
    }
    public void clickDeleteComputer()
    {
        driver.findElement(By.xpath("//input[@value='Delete this computer']")).click();
    }

}

