import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserRegistration {
    static WebDriver driver = new FirefoxDriver();
    //static WebDriver driver = new ChromeDriver();

    //Launching browser
    @BeforeMethod
    void init() {
        System.setProperty("webdriver.gecko.driver", "/Users/renumaharjan/Workspace/geckodriver");
        //System.setProperty("webdriver.chrome.driver", "/Users/renumaharjan/Workspace/chromedriver");
        driver.get("http://automationpractice.com/index.php?controller=my-account");
        driver.manage().window().maximize();
        System.out.println("launching browser");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    //User registration
    @Test
    void registration() {
        for (int i = 100; i <102 ; i++) {
            String email = "mesmerizektm" + i + "@gmail.com";
            //enter email address
            driver.findElement(By.cssSelector("#email_create")).sendKeys(email);

            //click create account button
            driver.findElement(By.cssSelector("#SubmitCreate")).click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            //select gender(#id_gender1=Mr and #id_gender2=Mrs)
            driver.findElement(By.cssSelector("#id_gender2")).click();

            //enter firstname
            driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("Renu");
            //enter lastname
            driver.findElement(By.cssSelector("#customer_lastname")).sendKeys("Maharjan");
            //enter email
            //obj.findElement(By.cssSelector("#email")).sendKeys("mesmerizektm@gmail.com");
            //enter password
            driver.findElement(By.cssSelector("#passwd")).sendKeys("Admin@123");
            //select DOB - Days
            Select days_obj = new Select(driver.findElement(By.name("days")));
            days_obj.selectByValue("15");
            //select DOB - Month
            Select months_obj = new Select(driver.findElement(By.name("months")));
            months_obj.selectByVisibleText("June ");
            //select DOB - year
            Select years_obj = new Select(driver.findElement(By.name("years")));
            years_obj.selectByIndex(30);

            // click newsletter checkbox
            driver.findElement(By.cssSelector("#newsletter")).click();
            //click partner checkbox
            driver.findElement(By.cssSelector("#optin")).click();

            driver.findElement(By.cssSelector("#company")).sendKeys("sevacompany");
            driver.findElement(By.cssSelector("#address1")).sendKeys("Nagpokhari");
            driver.findElement(By.cssSelector("#address2")).sendKeys("Naxal");
            driver.findElement(By.cssSelector("#city")).sendKeys("Kathmandu");

            Select state_obj = new Select(driver.findElement(By.name("id_state")));
            state_obj.selectByValue("5");
            driver.findElement(By.cssSelector("#postcode")).sendKeys("23450");
            //select country
            Select country_obj = new Select(driver.findElement(By.name("id_country")));
            country_obj.selectByValue("21");
            driver.findElement(By.cssSelector("#other")).sendKeys("This is test for additional information");
            driver.findElement(By.cssSelector("#phone")).sendKeys("012233444");
            driver.findElement(By.cssSelector("#phone_mobile")).sendKeys("9812308887");
            driver.findElement(By.cssSelector("#alias")).sendKeys(" My address");
            driver.findElement(By.cssSelector("#submitAccount")).click();
            //Thread.sleep(10);
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            System.out.println("Registration success");
            //user logout
            //driver.findElement(By.cssSelector(".header_user_info .logout")).click();

        }
    }

    @AfterMethod
    void end(){
        //driver.quit();
    }
}
