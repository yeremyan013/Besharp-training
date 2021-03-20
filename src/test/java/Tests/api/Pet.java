package Tests.api;

import io.restassured.http.ContentType;
import org.apache.hc.core5.http.HttpStatus;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Pet {

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
        int id = 39;
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
    }

    @Test
    void addAPet() {
        given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 33,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200);
    }

    @Test
    void updatePet() {
        given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 39,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"aaa\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .log().all()
                .statusCode(200);
    }
}
