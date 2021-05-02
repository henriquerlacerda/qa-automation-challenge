package UITesting.pages;

import UITesting.config.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductSubscriptionPage {

    public static WebElement type = ChromeDriver.getChromeDriver().findElement(By.id("type"));
    public static WebElement plan = ChromeDriver.getChromeDriver().findElement(By.id("support"));
    public static WebElement months = ChromeDriver.getChromeDriver().findElement(By.id("duration"));
    public static WebElement comments = ChromeDriver.getChromeDriver().findElement(By.id("comments"));
    public static WebElement calculate = ChromeDriver.getChromeDriver().findElement(By.id("calculate"));
    public static WebElement price = ChromeDriver.getChromeDriver().findElement(By.id("price"));
}
