package Tests.api;

import io.restassured.http.ContentType;
import org.apache.hc.core5.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Pet;

import static io.restassured.RestAssured.given;

public class PetStore {
    String id = "1";
    Pet pet;

    @Test
    public void initPet() {
        String id = "333";

        pet =
                given().log().all()
                        .header("Accept", "application/json")
                        .header("Content-Type", "application/xml")
                        .when()
                        .get(String.format("https://petstore.swagger.io/v2/pet/%s", id))
                        .as(Pet.class);
        Assert.assertEquals(pet.getId(), "333");
    }
/*
    @Test
    public void deletePet() {
        String id = "12";
        given().log().all()
                .header("Accept", "application/json")
                .when()
                .get(String.format("https://petstore.swagger.io/v2/pet/" + id))
                .then().statusCode(200).log().body();
    }

    @Test
    public void getByID() {
        int id = 33;
        given().log().all()
                .header("Accept", "application/json")
                .header("Content-Type", "application/xml")
                .when()
                .get(String.format("https://petstore.swagger.io/v2/pet/%d", id))
                .then()
                .log().body() //displays response body
                .statusCode(HttpStatus.SC_OK) //checks status code is 200
                .assertThat()
                .contentType(ContentType.JSON);
    }   */

    @Test
    void addAPet() {
        pet.setId(334);
        given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(pet)
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then().log().body()
                .statusCode(200);
    }

    @Test
    void updatePet() {
        String id = "333";
        given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(pet)
                .when()
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .log().all()
                .statusCode(200);
    }
}
