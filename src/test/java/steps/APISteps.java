package steps;
import APITesting.logic.APILogic;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class APISteps {

    @Given("^Reqres address correct$")
    public void reqresAddressCorrect(){
        APILogic.setRegresAddress();
    }
    @And("^Adding the context \"([^\"]*)\" and value \"([^\"]*)\"$")
    public void addingTheContextAndValue(String parameter, String value){
        APILogic.addValueJSON(parameter, value);
    }

    @When("^Submitting the POST request$")
    public void submittingThePOSTRequest(){
        APILogic.submitPost();
    }

    @Then("^The response code will be \"([^\"]*)\"$")
    public void theResponseCodeWillBe(String responseCode){
        APILogic.validateCodeResponse(responseCode);
    }

    @Given("^Adding new user was successful and the Reqres address correct$")
    public void addingNewUserWasSucessfullAndTheReqresAddressCorrect() {
        APILogic.validatePreviousScenario();
    }

    @When("^Submitting the DELETE request$")
    public void submittingTheDELETERequest() {
        APILogic.submitDelete();
    }

    @Given("^Reqres register adress is correct$")
    public void reqresRegisterAdressIsCorrect() {
        APILogic.setRegresRegisterAddress();
    }

    @And("^Submitting a GET request to validate it's content$")
    public void submittingAGETRequestToValidateItSContent() {
        APILogic.validateUserContent();
    }
}
