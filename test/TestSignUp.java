import java.time.Duration;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSignUp {

    private WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lvha0\\OneDrive\\Máy tính\\SWT\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://localhost:9999/Happy_v1/signup");
        Thread.sleep(1000);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void fillForm(String username, String password, String repassword, String email, String fullname, String phone, String birthdate, String address, String gender) throws InterruptedException {

        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys(username);
        Thread.sleep(500);

        WebElement passwordInput = driver.findElement(By.name("pass"));
        passwordInput.sendKeys(password);
        Thread.sleep(500);

        WebElement repasswordInput = driver.findElement(By.name("repass"));
        repasswordInput.sendKeys(repassword);
        Thread.sleep(500);

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(email);
        Thread.sleep(500);

        WebElement fullnameInput = driver.findElement(By.name("fullname"));
        fullnameInput.sendKeys(fullname);
        Thread.sleep(500);

        WebElement phoneInput = driver.findElement(By.name("phone"));
        phoneInput.sendKeys(phone);
        Thread.sleep(500);

        WebElement birthdateInput = driver.findElement(By.name("birth"));
        birthdateInput.sendKeys(birthdate);
        Thread.sleep(500);

        WebElement addressInput = driver.findElement(By.name("address"));
        addressInput.sendKeys(address);
        Thread.sleep(500);

        WebElement genderInput;
        if (gender.equalsIgnoreCase("Male")) {
            genderInput = driver.findElement(By.xpath("//input[@name='gender'][@value='Male']"));
        } else if (gender.equalsIgnoreCase("Female")) {
            genderInput = driver.findElement(By.xpath("//input[@name='gender'][@value='Female']"));
        } else {
            genderInput = driver.findElement(By.xpath("//input[@name='gender'][@value='Other']"));
        }
        genderInput.click();
    }

    private void submitForm() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

    @Test
    public void testTC1() throws InterruptedException {
        fillForm("lvhanh", "lvhanh@12", "lvhanh@12", "anhlvhhe176397@gmail.com", "", "0899839102", "13/09/2003", "Ninh Binh", "Male");
        submitForm();
        Thread.sleep(5000);
        try {
            Alert alert = driver.switchTo().alert();
            assertTrue(alert.getText().contains("Alert message"));
            alert.accept();
        } catch (NoAlertPresentException e) {
        }
    }

    @Test
    public void testTC2() throws InterruptedException {
        fillForm("lvhanh", "lvhanh@12", "lvhanh@12", "anhlvhhe176397@gmail.com", "Hoàng 123", "0899839102", "13/09/2003", "Ninh Binh", "Male");
        submitForm();
        Thread.sleep(5000);
        try {
            Alert alert = driver.switchTo().alert();
            assertTrue(alert.getText().contains("Alert message"));
            alert.accept();
        } catch (NoAlertPresentException e) {
        }
    }

    @Test
    public void testTC16() throws InterruptedException {
        fillForm("lvhanh", "lvhanh@", "lvhanh@12", "anhlvhhe176397@gmail.com", "Hoàng Anh", "0899839102", "13/09/2003", "Ninh Binh", "Male");
        submitForm();
        Thread.sleep(5000);
        try {
            Alert alert = driver.switchTo().alert();
            assertTrue(alert.getText().contains("Alert message"));
            alert.accept();
        } catch (NoAlertPresentException e) {
        }
    }
}
