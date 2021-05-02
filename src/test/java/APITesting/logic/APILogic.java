package APITesting.logic;

import APITesting.RestConfig;
import cucumber.api.Scenario;
import org.apache.groovy.json.internal.LazyMap;
import org.junit.Assert;

public class APILogic {

    private static String url;
    private static LazyMap dados = new LazyMap();
    private static String id = "";

    //Variables
    public static String getURL() {
        return url;
    }

    public static void setURL(String URL) {
        APILogic.url = URL;
    }

    public static LazyMap getDados() {
        return dados;
    }


    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        APILogic.id = id;
    }


    //Steps
    public static void setRegresAddress() {
        setURL("https://reqres.in/api/users");
    }

    public static void addValueJSON(String parameter, String value) {
        getDados().put(parameter, value);
    }

    public static void submitPost() {
        RestConfig.executePost(getURL(),getDados());
    }

    public static void validateCodeResponse(String responseCode) {
        Assert.assertEquals(responseCode, RestConfig.getCodeStatus());
    }

    public static void validatePreviousScenario() {
       if(RestConfig.getCodeStatus().equals("201")) {
           setURL("https://reqres.in/api/users/");
           setId(RestConfig.getKeyValue("id"));
           getDados().clear();
           getDados().put("id", getURL());
       }
       else
           Assert.assertTrue(false);
    }

    public static void submitDelete() {
        RestConfig.executeDelete(getURL(),getId());
    }

    public static void setRegresRegisterAddress() {
        setURL("https://reqres.in/api/register");
    }

    public static void validateUserContent() {
        setId(RestConfig.getKeyValue("id"));
        getDados().clear();
        getDados().put("id",getId());
        RestConfig.executeGet(getURL(),getDados());
    }
}
