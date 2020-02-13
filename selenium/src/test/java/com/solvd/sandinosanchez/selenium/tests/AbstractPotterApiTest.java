package com.solvd.sandinosanchez.selenium.tests;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public abstract class AbstractPotterApiTest {
    protected static final String key = "$2a$10$pVoM.xHowOo8JXvToNaipO2wBXK81OLS4NrZrqLRAZBLQHUIe/2uG";

    @BeforeSuite
    public void setupBaseUirAndResponseSpecification() {
        RestAssured.baseURI = "https://www.potterapi.com";
        RestAssured.basePath = "/v1";

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }

    @BeforeClass
    public void setupBasePath() {
        RestAssured.basePath = RestAssured.basePath + "/characters/{id}";
        RestAssured.responseSpecification.statusCode(200);
    }

}
