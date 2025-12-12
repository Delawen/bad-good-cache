package org.cutecats.rest.json;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusIntegrationTest
class CatResourceIT {

	// Running just once will not be enough
	@RepeatedTest(10000)
	void newRandomCat() {
		given()
				//This must be like production, not a test
				.when().get("/cats?test=false")
				.then()
				.statusCode(200);
	}


	@Test
	void list() {
		given()
				//This must be like production, not a test
				.when().get("/list")
				.then()
				.statusCode(200);
	}
}