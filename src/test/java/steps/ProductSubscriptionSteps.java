package steps;

import UITesting.config.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import UITesting.logic.ProductSubscriptionLogic;

import java.io.IOException;

public class ProductSubscriptionSteps {

    @Given("^Product Subscription Configurator's home page is open$")
    public void productSubscriptionConfiguratorSHomePageIsOpen() throws IOException {
        ProductSubscriptionLogic.goToProductWebSite();
    }

    @When("^assigned \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
    public void assignedAnd(String type, String plan, String months) throws Throwable {
        ProductSubscriptionLogic.selectTypePlanMonths(type, plan, months);
    }

    @And("^click Calculate$")
    public void clickCalculate() {
        ProductSubscriptionLogic.clickCalculate();
    }

    @Then("^the \"([^\"]*)\" for this support plan will show on the screen$")
    public void theForThisSupportPlanWillShowOnTheScreen(String price) throws Throwable {
        ProductSubscriptionLogic.validatePrice(price);
    }

}
