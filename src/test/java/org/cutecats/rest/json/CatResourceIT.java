package org.cutecats.rest.json;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusIntegrationTest
class CatResourceIT {

	// This should help profiling the method
	// (although real life requests are not always the same,
	// don't test the happy path only)
	@RepeatedTest(10000)
	void newRandomCat() {
		given()
				//This must be like production, not a test
				//This is an important difference with unit tests!
				.when().get("/cats?test=false")
				.then()
				.statusCode(200);
	}


	//This will make sure metadata gets loaded
	//It will not profile the /list entrypoint method
	@Test
	void list() {
		given()
				//This must be like production, not a test
				.when().get("/list")
				.then()
				.statusCode(200);
	}
}