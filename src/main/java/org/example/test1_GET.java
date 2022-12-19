package org.example;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class test1_GET {
    @Test
    void Test_01() {
        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int statusCod = response.getStatusCode();
        Assert.assertEquals(statusCod, 200);
    }

    @Test
    void Test_02() {

        given()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .statusCode(200)
                .body("data[0].id",equalTo(7))
                .body("page",equalTo(2))
                .body("total",equalTo(12));
    }
}
