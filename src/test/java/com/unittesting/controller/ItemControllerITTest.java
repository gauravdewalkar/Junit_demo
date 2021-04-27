package com.unittesting.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.unittesting.UnitTestingApplication;

/**
 * The Class ItemBusinessService contains various methods to provide business
 * logics as per the requests
 * 
 * 
 * @since 21.02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = UnitTestingApplication.class)
public class ItemControllerITTest {

	/** The mock mvc is the instance of MockMvc */
	private MockMvc mockMvc;

	/** The wac is the instance of WebApplicationContext */
	@Autowired
	private WebApplicationContext wac;

	/**
	 * Setup method to set the webApplication Context in MockMvc
	 */
	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	/**
	 * retreive_Hardcoded_Item to test the hard coded list returned successfully.
	 *
	 * @throws Exception in case of failure
	 */
	@Test
	void retreive_Hardcoded_Item() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/item-from-business-service").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$").exists())
				.andExpect(jsonPath("$.[0].name").exists()).andExpect(jsonPath("$.[0].name", is("Ball")));
	}

	/**
	 * insert_an_item tests the insertion of data into the database
	 *
	 * @throws Exception
	 */
	@Test
	void insert_an_item() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/save-an-item").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"Item2\",\"price\":10}").accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn();
		;
//		System.out.println(result.getResponse().getContentAsString());
	}

}
