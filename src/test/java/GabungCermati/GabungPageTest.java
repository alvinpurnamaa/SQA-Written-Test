package GabungCermati;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GabungPageTest {
    WebDriver driver;

    private void initialize () {
        System.setProperty("webdriver.chrome.driver", "C:/Users/ASUS/AppData/Local/Google/Chrome/Application");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.cermati.com/app/gabung");
        driver.manage().window().maximize();
    }

    private void registrationWrongValues () {
        driver.findElement(By.id("mobilePhone")).sendKeys("0821");
        driver.findElement(By.id("email")).sendKeys("budi123@gmail.com");
        driver.findElement(By.id("firstName")).sendKeys("Budi");
        driver.findElement(By.id("lastName")).sendKeys("Aja");
        driver.findElement(By.name("register-new")).click();
        Assert.assertEquals(driver.findElement(By.className("m-t-4 error_rz3sn")).getText(), "Nomor handphone tidak valid");

    }

    private void registrationCorrectValues () {
        driver.findElement(By.id("mobilePhone")).sendKeys("08212839323");
        driver.findElement(By.id("email")).sendKeys("budi123@gmail.com");
        driver.findElement(By.id("firstName")).sendKeys("Budi");
        driver.findElement(By.id("lastName")).sendKeys("Aja");
        driver.findElement(By.name("register-new")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cermati.com/app/login?target=/app/gabung");

    }

}
