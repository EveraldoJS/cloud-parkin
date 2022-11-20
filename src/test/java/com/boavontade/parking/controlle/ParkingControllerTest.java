package com.boavontade.parking.controlle;

import com.boavontade.parking.controlle.dto.ParkingCreateDTO;
import io.restassured.RestAssured;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerTest extends AbstractContainerBase {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest(){ RestAssured.port = randomPort; }

    @Test
    void whenFindAllThenCheckResult() {
        RestAssured.given()
                .header("authorization", "Basic")
                .when()
                .get("/parking")
                .then()
                .statusCode(HttpStatus.OK.value());

    }

    @Test
    void whenCreateThenCheckCreated() {
        var createDTO = new ParkingCreateDTO();
        createDTO.setColor("AMARELO");
        createDTO.setLicense("SBA-2222");
        createDTO.setModel("BRASILIA");
        createDTO.setState("BA");

        RestAssured.given()
                .header("authorization", "Basic")
                .when()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(createDTO)
                .post("/parking")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("license", Matchers.equalTo("SBA-2222"));

    }
}