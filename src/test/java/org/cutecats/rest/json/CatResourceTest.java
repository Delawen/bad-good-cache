package org.cutecats.rest.json;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.junit.jupiter.api.RepeatedTest;
import static io.restassured.RestAssured.given;

@QuarkusIntegrationTest
class CatResourceTest {


	//Do not start enabled
	//@RepeatedTest(10000)
	void newRandomCat() {
		given()
				//Remember, test=false because we are generating the cache, not testing
				//this must be as close to production as possible
				.when().get("/cats?test=false")
				.then()
				.statusCode(200);
	}
}