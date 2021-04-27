package com.unittesting.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.unittesting.UnitTestingApplication;
import com.unittesting.model.Item;

/**
 * The Class ItemBusinessService contains various methods to provide business
 * logics as per the requests
 * 
 * @author dhkannan
 * @since 21.02
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = UnitTestingApplication.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemIntegrationTest {

	/** The rest template is the instance of TestRestTemplate */
	@Autowired
	public TestRestTemplate restTemplate;

	/** The port. */
	@LocalServerPort
	private int port;

	/** The headers. */
	HttpHeaders headers = new HttpHeaders();

	/**
	 * testCreateItem to test the insertion of data into the db.
	 *
	 * @throws Exception incase of failure
	 */
	@Test
	void testCreateItem() throws Exception {
		Item item = new Item(500, "kdd", 10, 100);
		HttpEntity<Item> entity = new HttpEntity<Item>(item, headers);

		ResponseEntity<String> response = this.restTemplate.exchange(createURLWithPort("/insert-an-item"),
				HttpMethod.POST, entity, String.class);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
//		System.out.println(response);
	}

	/**
	 * contextLoads method to test fetching all datas from db working correct
	 *
	 * @throws JSONException incase of failure
	 */
	@Test
	void contextLoads() throws JSONException {
		String response = this.restTemplate.getForObject("/all-items-from-database", String.class);
		JSONAssert.assertEquals("[{id:10001},{id:10002},{id:10003},{id:500}]", response, false);
	}

	/**
	 * createURLWithPort used to set the url with respective port
	 *
	 * @param uri the uri
	 * @return the string
	 */
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
