package com.rk.springboot;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.matchers.Times;
import org.mockserver.model.Header;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.rk.springboot.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
class SbAopApplicationTests {

	private static ClientAndServer mockServer;

	@BeforeAll
	public static void startServer() {
		mockServer = ClientAndServer.startClientAndServer(8081);
	}

	@AfterAll
	public static void stopServer() {
		mockServer.stop();
	}
	
	@LocalServerPort
	private int port;
	private static final String API_ENDPOINT = "/account/hello";
	private TestRestTemplate restTemplate = new TestRestTemplate();
	
	
	@Test
	public void whenClientCallAPI_Hello()
	{
		new MockServerClient("localhost", 8081)
				.when(
						HttpRequest.request()
						.withMethod("GET")
						.withPath(API_ENDPOINT)
						.withHeader("Context-type","application/json")
						, Times.exactly(1)
						
					)
				.respond(HttpResponse.response()
						.withStatusCode(200)
						.withHeader(new Header("Context-type","application/json"))
						.withDelay(TimeUnit.MILLISECONDS,10)
						);
		
		String url="http://localhost:" +port+API_ENDPOINT;
		Employee emp = new Employee();
		ResponseEntity<Employee> response=restTemplate.postForEntity(url, emp, Employee.class);
		Assert.assertTrue(response.getStatusCode().is2xxSuccessful());
		Assert.assertEquals(response.getBody().getEmpID(), 0);
		
	}
	

}
