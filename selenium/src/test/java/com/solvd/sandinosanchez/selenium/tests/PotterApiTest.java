package com.solvd.sandinosanchez.selenium.tests;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PotterApiTest extends AbstractPotterApiTest {

    @DataProvider
    public Object[][] charactersWithRoles() {
        return new Object[][] {
                {"Hannah Abbott", "student"},
                {"Bathsheda Babbling", "Professor, Ancient Runes"},
                {"Ludo Bagman", "Head, Department of Magical Games and Sports"},
                {"Bathilda Bagshot", "Author, A History Of Magic"},
                {"Katie Bell", "student"},
                {"Cuthbert Binns", "Professor, History of Magic"},
                {"Terry Boot", "student"}
        };
    }

    @Test( dataProvider = "charactersWithRoles")
    public void getCharacterAndRole(String name, String role) {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .pathParam("id", "")
                .queryParam("key", key)
                .get()
        .then()
                .assertThat()
                        .body("[0].name", equalTo(name))
                .and()
                        .body("[0].role", equalTo(role));
    }

    @Test
    public void getCharacter() {

    }

}
