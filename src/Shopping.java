import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Shopping {
    static WebDriver driver = new FirefoxDriver();
    //static WebDriver driver = new ChromeDriver();

    @BeforeMethod
    void init() {
        System.setProperty("webdriver.gecko.driver", "/Users/renumaharjan/Workspace/geckodriver");
        //System.setProperty("webdriver.chrome.driver", "/Users/renumaharjan/Workspace/chromedriver");
        driver.get("http://prestashop.rayaxis.com/index.php?controller=authentication&back=my-account");
        driver.manage().window().maximize();
        System.out.println("launching browser");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        login();
    }

    //User login
    public void login() {
        driver.findElement(By.id("email")).sendKeys("mesmerizektm@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Admin@123");
        driver.findElement(By.id("SubmitLogin")).click();
        System.out.println("Login success");
        //obj.findElement(By.cssSelector(".header_user_info .logout")).click();

    }

    //Add dress to cart
    @Test(priority = 1)
    void shopping1() {
        driver.findElement(By.cssSelector(".sf-menu > li:nth-child(2) > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#product_list li:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#product_list li:nth-child(1) .ajax_add_to_cart_button")).click();
        System.out.println("shopping1");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#layer_cart .continue.btn.btn-default.button.exclusive-medium")).click();
        System.out.println("continue shopping successful");
    }

    //Add T-shirt to cart
    @Test(priority = 2)
    void shopping2() {
        driver.findElement(By.cssSelector(".sf-menu > li:nth-child(3) > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#product_list li:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#product_list li:nth-child(1) .ajax_add_to_cart_button")).click();
        System.out.println("shopping2");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //proceed to checkout
        driver.findElement(By.cssSelector("#layer_cart .button-container a")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //summary tab
        driver.findElement(By.cssSelector("a.standard-checkout")).click();
        //sign in is skipped because user is already logged in
        //address tab
        driver.findElement(By.cssSelector("#ordermsg textarea")).sendKeys("comment about your order");
        driver.findElement(By.cssSelector("#center_column > form > p > button")).click();
        //shipping
        driver.findElement(By.cssSelector("#cgv")).click();
        driver.findElement(By.cssSelector("#form .standard-checkout")).click();
        //Payment
        driver.findElement(By.cssSelector("#HOOK_PAYMENT a.bankwire")).click();
        //confirm order
        driver.findElement(By.cssSelector("form .cart_navigation button")).click();
    }

    @AfterMethod
    void end() {
        //driver.quit();
    }

}

