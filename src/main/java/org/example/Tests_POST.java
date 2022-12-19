package org.example;

import io.restassured.http.ContentType;
import org.apache.groovy.json.internal.Value;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.http.ContentType.JSON;

public class Tests_POST {
  // @Test
    public void test_1_POST() {
//        Map<String, Object> map  = new HashMap<String, Object>();
//        map.put("name", "Ahmed");
//        map.put("job", "Tester");
//
//        System.out.println(map);








        JSONObject request = new JSONObject();

        request.put("name","Ahmed");
        request.put("jop","Tester");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
           header("Content-Type","application/json").
           contentType(JSON).
           accept(ContentType.JSON).
           body(request.toJSONString()).
        when().
           post("https://reqres.in/api/users/2").
        then().
           statusCode(201);
    }

   // @Test
    public void test_2_put() {

        JSONObject request = new JSONObject();

        request.put("name","Ahmed");
        request.put("jop","Tester");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
            header("Content-Type","application/json").
                contentType(JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
            when().
                put("https://reqres.in/api/users/2").
            then().
                statusCode(200).
                log().all();
    }

    @Test
    public void test_3_patch() {

        JSONObject request = new JSONObject();

        request.put("name","Ahmed");
        request.put("jop","Tester");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
           header("Content-Type","application/json").
                contentType(JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
           when().
                patch("https://reqres.in/api/users/2").
           then().
                statusCode(200).
                log().all();
    }

    @Test
    public void test_4_Delete() {
           when().
                delete("https://reqres.in/api/users/2").
           then().
                statusCode(204).
                log().all();
    }
}
