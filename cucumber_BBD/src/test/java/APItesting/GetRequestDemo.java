package APItesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.path.json.JsonPath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetRequestDemo {

	public static void main(String[] args) {

        // Base URI
        RestAssured.baseURI = "https://gorest.co.in";

        System.out.println("============== GET REQUEST ==============");

        // GET Request
        Response getResponse = given().when().get("/public/v2/users/8052292");

        // Print Response
        System.out.println("Status Code : "+ getResponse.getStatusCode());

        System.out.println("Response Body : ");
        System.out.println(getResponse.getBody().asString());

        System.out.println("Response Time : "+ getResponse.getTime());

        System.out.println("Content Type : "+ getResponse.getContentType());



        System.out.println("\n============== VALIDATIONS ==============");

        // Validations
        given().when().get("/public/v2/users/8052292").then()
        .statusCode(200)
        .body("name", equalTo("Brajendra Khatri"))
        .body("email", equalTo("khatri_brajendra@baumbach.test"))
        .time(lessThan(5000L))
        .header("Content-Type", containsString("application/json"))
        .log().all();



        System.out.println("\n============== JSON EXTRACTION ==============");

        JsonPath jsonPath = getResponse.jsonPath();

        int id = jsonPath.getInt("id");
        String email = jsonPath.getString("email");
        String name = jsonPath.getString("name"); 
        String status = jsonPath.getString("status"); 
        System.out.println("ID : " + id);
        System.out.println("Email : " + email);
        System.out.println("Name : " + name);
        System.out.println("Status : " + status);



        System.out.println("\n============== POST REQUEST ==============");

        String postRequestBody = "{ \"user_id\": 8477478, \"title\": \"hello testing\", \"body\": \"hello testing\" }";

        String myToken = "1201661f866632de14dbf2553e158ae8edee4fb4e18a8fba2cab0a24b25081a5"; 

        // POST Request
        Response postResponse = given()
            .header("Authorization", "Bearer " + myToken) 
            .contentType(ContentType.JSON)
            .body(postRequestBody)
        .when()
            .post("/public/v2/posts");

        // POST Validation
        postResponse.then()
            .statusCode(201)
            .log().all();

        // Extract Generated ID
        String generatedId = postResponse.jsonPath().getString("id");
        System.out.println("Generated Post ID : " + generatedId);


        System.out.println("\n============== PUT REQUEST ==============");

        String putRequestBody = "{\n" +
            "    \"id\": 8474967,\n" +
            "    \"name\": \"Harsh Kocchar Sr.\",\n" +
            "    \"email\": \"kocchar_karan_sr@block-gislason.example\",\n" +
            "    \"gender\": \"male\",\n" +
            "    \"status\": \"inactive\"\n" +
            "}";

        // PUT Request
        given()
            .header("Authorization", "Bearer " + myToken) 
            .contentType(ContentType.JSON)
            .body(putRequestBody)
        .when()
            .put("/public/v2/users/8474967")
        .then()
            .statusCode(200) 
            .log().all();


        System.out.println("\n============== PATCH REQUEST ==============");

        String patchRequestBody = "{\n" +
            "    \"status\": \"active\"\n" +
            "}";


        int userIdToPatch = 8474967;

        // PATCH Request
        given()
            .header("Authorization", "Bearer " + myToken) 
            .contentType(ContentType.JSON)
            .body(patchRequestBody)
        .when()
            .patch("/public/v2/users/" + userIdToPatch) 
        .then()
            .statusCode(200) 
            .log().all();
        

        System.out.println("\n============== DELETE REQUEST ==============");

        int userIdToDelete = 8474968;

        // DELETE Request
        given()
            .header("Authorization", "Bearer " + myToken)
        .when()
            .delete("/public/v2/users/" + userIdToDelete) 
        .then()
            .statusCode(204) 
            .log().all();


//
//        System.out.println("\n============== PATH PARAMETER ==============");
//
//        // Path Parameter
//        given()
//
//            .pathParam("id", 2)
//
//        .when()
//
//            .get("/api/users/{id}")
//
//        .then()
//
//            .statusCode(200)
//
//            .log().all();
//
//
//
//        System.out.println("\n============== QUERY PARAMETER ==============");
//
//        // Query Parameter
//        given()
//
//            .queryParam("page", 2)
//
//        .when()
//
//            .get("/api/users")
//
//        .then()
//
//            .statusCode(200)
//
//            .log().all();
//
//
//
//        System.out.println("\n============== HEADERS ==============");
//
//        // Headers Example
//        given()
//
//            .header("Content-Type",
//                    "application/json")
//
//        .when()
//
//            .get("/api/users/2")
//
//        .then()
//
//            .statusCode(200)
//
//            .log().headers();
//
//
//
//        System.out.println("\n============== BEARER TOKEN AUTH ==============");
//
//        // Bearer Token Example
//
//        String token = "YOUR_TOKEN";
//
//        given()
//
//            .header("Authorization",
//                    "Bearer " + token)
//
//        .when()
//
//            .get("https://gorest.co.in/public/v2/users")
//
//        .then()
//
//            .statusCode(200)
//
//            .log().all();
//
//
//
//        System.out.println("\n============== REQUEST CHAINING ==============");
//
//        // POST Request
//        Response chainResponse =
//
//                given()
//
//                    .contentType(ContentType.JSON)
//
//                    .body(postRequestBody)
//
//                .when()
//
//                    .post("/api/users");
//
//        // Extract ID
//        String chainId =
//                chainResponse.jsonPath().getString("id");
//
//        System.out.println("Chain ID : "
//                + chainId);
//
//        // GET using same ID
//        given()
//
//            .pathParam("id", chainId)
//
//        .when()
//
//            .get("/api/users/{id}")
//
//        .then()
//
//            .log().all();
//
//
//
//        System.out.println("\n============== JSON SCHEMA VALIDATION ==============");
//
//        // Schema Validation
//        given()
//
//        .when()
//
//            .get("/api/users/2")
//
//        .then()
//
//            .assertThat()
//
//            .body(matchesJsonSchemaInClasspath(
//                    "schema.json"))
//
//            .log().all();
//
//
//
//        System.out.println("\n============== PRINT HEADERS ==============");
//
//        // Print Headers
//        getResponse.getHeaders().forEach(
//                System.out::println);
//
//
//
//        System.out.println("\n============== PRINT COOKIES ==============");
//
//        // Print Cookies
//        getResponse.getCookies().forEach(
//                (k,v) -> System.out.println(
//                        k + " : " + v));
//
//
//
//        System.out.println("\n============== TEST COMPLETED ==============");
    }

}
