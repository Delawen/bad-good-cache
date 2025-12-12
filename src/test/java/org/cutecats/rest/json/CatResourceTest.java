package org.cutecats.rest.json;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class CatResourceTest {


	@Test
	void newRandomCat() {
		given()
				.when().get("/cats")
				.then()
				.statusCode(200);
	}
}