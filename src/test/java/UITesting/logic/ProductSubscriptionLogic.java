package UITesting.logic;

import UITesting.config.ChromeDriver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import UITesting.pages.ProductSubscriptionPage;

import java.io.IOException;

public class ProductSubscriptionLogic {

    private final static String  PRODUCTWEBSITE = "https://qa-automation-challenge.github.io/sandbox/";

    //Steps
    public static void goToProductWebSite() throws IOException {
        ChromeDriver.createAndStartService();
        ChromeDriver.createDriver();
        ChromeDriver.accessWebPage(PRODUCTWEBSITE);
    }

    public static void selectTypePlanMonths(String type, String plan, String months){
        Select supportType = new Select(ProductSubscriptionPage.type);
        supportType.selectByVisibleText(type);
        ChromeDriver.waitPageLoad(2000);
        Select supportPlan = new Select(ProductSubscriptionPage.plan);
        supportPlan.selectByVisibleText(plan);
        ChromeDriver.waitPageLoad(2000);
        ProductSubscriptionPage.months.sendKeys(months);
        ChromeDriver.waitPageLoad(2000);

    }

    public static void clickCalculate() {
        ProductSubscriptionPage.calculate.click();
        ChromeDriver.waitPageLoad(7000);
    }

    public static void validatePrice(String price) {
        JavascriptExecutor jse = (JavascriptExecutor) ChromeDriver.getChromeDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", ProductSubscriptionPage.price);
        Assert.assertEquals(price, ProductSubscriptionPage.price.getText());
        ChromeDriver.waitPageLoad(2000);
        ChromeDriver.quitDriver();
        ChromeDriver.stopService();
    }
}
