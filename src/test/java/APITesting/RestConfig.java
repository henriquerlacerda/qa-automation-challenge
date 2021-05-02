package APITesting;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.groovy.json.internal.LazyMap;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestConfig {
    private static RequestSpecification rs;
    private static RequestSpecification rsAux;

    private static Response response;

    public static Response getResponse() {
        return response;
    }

    private static void setResponse(Response response) {
        RestConfig.response = response;
    }

    public static void clearRs(){ rs = null; }

    private static RequestSpecification buildBaseRequestSpecification() {
        clearRs();
        if (!(rsAux == null)) {
            rs.headers(((RequestSpecificationImpl) rsAux).getHeaders());
            rs.cookies(((RequestSpecificationImpl) rsAux).getCookies());
        }

        rs = given()
                .when()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);

        return rs;
    }

    public static void addHeader(Header h) {
        if (h != null) {
            rsAux.header(h);
        }
    }

    public static void addCookies(Map<String, String> c) {
        if (c != null) {
            rsAux.cookies(c);
        }
    }

    public static Response executeGet(String endpoint, LazyMap json) {
        response = buildBaseRequestSpecification()
                .body(json)
                .get(endpoint)
                .then()
                .extract().response();
        printLogStart("GET", endpoint, "");
        printLog("GET", response);
        return response;
    }

    public static Response executePost(String endpoint, LazyMap json) {
        response = buildBaseRequestSpecification()
                .body(json)
                .post(endpoint)
                .then()
                .extract().response();
        printLogStart("POST",endpoint, json.toString());
        printLog("POST",response);
        return response;
    }

    public static Response executeDelete(String endpoint, String json) {
       response = buildBaseRequestSpecification()
                .contentType(ContentType.JSON)
                .param("id", json)
                .when()
                .delete(endpoint)
                .then()
                .extract().response();
        printLogStart("DELETE",endpoint, "");
        printLog("DELETE",response);
        return response;
    }

    private static void printLogStart(String method, String url, String json){
        System.out.println("");
        System.out.println("====================================");
        System.out.println("");
        System.out.println("METHOD: [ "+ method + " (Request) ]");
        System.out.println("Endpoint: [ "+ url + " ]");
        System.out.println("Headers: [ "+ ((RequestSpecificationImpl) rs).getHeaders().toString() + " ]");
        System.out.println("Body - Request: [ " + json + " ]");
    }

    private static void printLog(String method, Response response){
        System.out.println("");
        System.out.println("------------------------------------");
        System.out.println("");
        System.out.println("METHOD: [ "+ method + " (Response) ]");
        System.out.println("Status Code: [ "+ String.valueOf(response.statusCode()) + " ]");
        System.out.println("Response: [ "+ response.getBody().asString() + " ]");
        System.out.println("");
        System.out.println("====================================");
    }

    public static String getKeyValue(String field) {
        return response.jsonPath().getString(field);
    }

    public static String getCodeStatus() {
        return String.valueOf(response.statusCode());
    }
}
