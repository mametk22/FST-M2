package liveProject;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(PactConsumerTestExt.class)
    public class ConsumerTest {
        Map<String, String> headers = new HashMap<>();
        String userResourcepath = "/api/users";
        @Pact(consumer ="UserConsumer", provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
            headers.put("Content-Type", "application/json");
            DslPart requestResponseBody = new PactDslJsonBody()
                    .numberType("id")
                    .stringType("firstName")
                    .stringType("lastName")
                    .stringType("email");
return builder.given("A request to create user")
        .uponReceiving("A request to create user")
        .method("POST")
        .headers(headers)
        .path(userResourcepath)
        .body(requestResponseBody)
        .willRespondWith()
        .status(201)
        .body(requestResponseBody)
        .toPact();

        }
@Test
@PactTestFor(providerName = "UserProvider", port ="8282")
    public void consumerTest(){
            final String baseURI = "http://localhost:8282";
            Map<String, Object> reqBody = new HashMap<>();
            reqBody.put("id", 12);
            reqBody.put("firstName", "Madhavi");
            reqBody.put("lastName", "Metkari");
            reqBody.put("email", "madhavi@example.com");

    Response response = given().headers(headers).when().body(reqBody).post(baseURI + userResourcepath);
    response.then().statusCode(201);


}

}
