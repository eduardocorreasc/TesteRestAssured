package Teste.Eduardo;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Test;



public class TesteRest {
	@Test
	public void TesteListAllSucesso() {
		given()
		.when()
			.get("https://dog.ceo/api/breeds/list/all")
		.then()
			.statusCode(200)
			.body( Matchers.containsString("australian"))
			.body("message.australian", Matchers.hasSize(2))
			.body("message.australian", Matchers.hasItems("kelpie", "shepherd"))
			.body("status", Matchers.containsString("success"));
				
	}
	
	@Test
	public void TesteListAllErro() {
		given()
		.when()
			.post("https://dog.ceo/api/breeds/list/all")
		.then()
			.statusCode(405)
			.body("status", Matchers.is("error"))
			.body("message", Matchers.containsString("No route found"));

	}
	
	@Test
	public void TesteImageRandomSucesso() {
		given()
		.when()
			.get("https://dog.ceo/api/breeds/image/random")
		.then()
			.statusCode(200)
			.body( Matchers.containsString("images.dog.ceo"))
			.body( Matchers.containsString(".jpg"))
			.body("status", Matchers.containsString("success"));
				
	}
	
	@Test
	public void TesteImageRandomErro() {
		given()
		.when()
			.put("https://dog.ceo/api/breeds/image/random")
		.then()
			.statusCode(405)
			.body("status", Matchers.is("error"))
			.body("message", Matchers.containsString("No route found"));

	}
	
	@Test
	public void TesteBredsListSucesso() {
		given()
		.when()
			.get("https://dog.ceo/api/breed/affenpinscher/images/random")
		.then()
			.statusCode(200)
			.body( Matchers.containsString("images.dog.ceo"))
			.body( Matchers.containsString(".jpg"))
			.body( Matchers.containsString("affenpinscher"))
			.body("status", Matchers.containsString("success"));
				
	}
	
	@Test
	public void TesteBredsListSucessoOutraRaca() {
		given()
		.when()
			.get("https://dog.ceo/api/breed/pug/images/random")
		.then()
			.statusCode(200)
			.body( Matchers.containsString("images.dog.ceo"))
			.body( Matchers.containsString(".jpg"))
			.body( Matchers.containsString("pug"))
			.body("status", Matchers.containsString("success"));
	}	
	
	@Test
	public void TesteImageBredsListSNotFound() {
		given()
		.when()
			.get("https://dog.ceo/api/breed/pug1/images/random")
		.then()
			.statusCode(404)
			.body("status", Matchers.is("error"))
			.body("code", Matchers.is(404))
			.body("message", Matchers.containsString("Breed not found (master breed does not exist)"));

	}
	
	@Test
	public void TesteImageBredsListSErro() {
		given()
		.when()
			.patch("https://dog.ceo/api/breed/affenpinscher/images/random")
		.then()
			.statusCode(405)
			.body("status", Matchers.is("error"))
			.body("message", Matchers.containsString("No route found"));

	}
}
