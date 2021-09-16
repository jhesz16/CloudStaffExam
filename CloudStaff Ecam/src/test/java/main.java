import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class main{

    public WebDriver driver;
    public AddNewComputer addNewComputer;
    public HomePage homepage;

    @BeforeTest
    public void Init() {

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

    }

    @BeforeMethod
    public void SetUp()
    {
        driver.get("http://computer-database.gatling.io/computers");
        addNewComputer = new AddNewComputer(driver);
        homepage = new HomePage(driver);
    }

    @Test
    @Description("Validate that user can add a new computer on the Computer database")
    public void TC001() {;
        String name = "JC";
        String introduced = "2020-09-16";
        String discontinued = "2021-09-16";
        String company = "IBM";

        addNewComputer.clickAddNewComputer();
        addNewComputer.fill(name,introduced,discontinued,company);
        addNewComputer.clickSubmit();

        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Computer " + name + " has been created']")).isDisplayed());

    }


    @Test
    @Description("Validate search functionality when data is newly created")
    public void TC002() {
        String name = "JC-PC";
        TC001();
        homepage.search(name);
        Assert.assertTrue(homepage.validateSearch(name));
    }


    @Test
    @Description("Validate search functionality when data is already existing")
    public void TC003() {
        String name = "ASCI Blue Mountain";
        homepage.search(name);
        Assert.assertTrue(homepage.validateSearch(name));
    }


    @Test
    @Description("Validate edit/update functionality")
    public void TC004() {
        String name = "Amiga";
        homepage.openComputer(name);
        addNewComputer.fill(name+" EDITED","","","");
        addNewComputer.clickSave();
        Assert.assertTrue(homepage.validateAlertText("Done ! Computer "+name+" EDITED has been updated"));
    }

    @Test
    @Description("Validate delete functionality")
    public void TC005() {
        String name = "Amiga";

        homepage.openComputer(name);
        addNewComputer.clickDeleteComputer();
        Assert.assertTrue(homepage.validateAlertText("Done ! Computer "+name+" has been deleted"));
        homepage.search(name);
        Assert.assertFalse(homepage.validateSearch(name));
    }


    @Test
    @Description("Validate Alerts in javascript alerts site")
    public void TC006() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        clickButton("Click for JS Alert");
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),"You successfully clicked an alert");

        clickButton("Click for JS Confirm");
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),"You clicked: Ok");

        clickButton("Click for JS Confirm");
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),"You clicked: Cancel");


        clickButton("Click for JS Prompt");
        driver.switchTo().alert().sendKeys("Test");
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),"You entered: Test");

        clickButton("Click for JS Prompt");
        driver.switchTo().alert().sendKeys("Test");
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),"You entered: null");

    }

    public void clickButton(String text)
    {
        driver.findElement(By.xpath("//button[text()='"+text+"']")).click();
    }
    @AfterClass
    public void CleanUp()
    {
        driver.quit();
    }

}


