package com.unittesting.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.unittesting.business.ItemBusinessService;
import com.unittesting.business.ItemServiceImpl;
import com.unittesting.model.Item;

/**
 * Test class for ItemController.
 * 
 * 
 * @since 21.02
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	/** The mock mvc is the instance of MockMvc */
	@Autowired
	private MockMvc mockMvc;

	/** The business service is the instance of ItemBusinessService */
	@MockBean
	private ItemBusinessService businessService;

	/** The item service is the instance of ItemServiceImpl */
	@MockBean
	private ItemServiceImpl itemService;

	/**
	 * retreiveHardcodedItem method to test it's routing and the return status
	 *
	 * @throws Exception
	 */
	@Test
	void retreiveHardcodedItem() throws Exception {
		given(businessService.retreiveHardcodedItem()).willReturn(Arrays.asList(new Item(2, "Item2", 10, 100)));

		mockMvc.perform(MockMvcRequestBuilders.get("/item-from-business-service").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$.[0].name", is("Item2"))).andExpect(jsonPath("$.[0].id", is(2)))
				.andExpect(jsonPath("$.[0].price", is(10))).andExpect(jsonPath("$.[0].quantity", is(100)));
	}

	/**
	 * retrieveAllItemsTest method to test whether it fetches all the items from db
	 * correctly
	 *
	 * @throws Exception
	 */
	@Test
	void retrieveAllItemsTest() throws Exception {
		given(businessService.retrieveAllItems())
				.willReturn(Arrays.asList(new Item(2, "Item2", 10, 100), new Item(3, "Item3", 20, 200)));

		mockMvc.perform(MockMvcRequestBuilders.get("/all-items-from-database").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$.[0].name").value("Item2")).andExpect(jsonPath("$.[0].id", is(2)))
				.andExpect(jsonPath("$.[0].price", is(10))).andExpect(jsonPath("$.[0].quantity", is(100)))
				.andExpect(jsonPath("$.[1].name").value("Item3")).andExpect(jsonPath("$.[1].id", is(3)))
				.andExpect(jsonPath("$.[1].price", is(20))).andExpect(jsonPath("$.[1].quantity", is(200)));
	}

	/**
	 * retreive_Item_byName method tests the returned is corresponding to respective
	 * item name or not.
	 *
	 * @throws Exception
	 */
	@Test
	void retreive_Item_byName() throws Exception {
		when(businessService.retrieveByName("Item2")).thenReturn(new Item(2, "Item2", 10, 10));

		RequestBuilder request = MockMvcRequestBuilders.get("/item-by-name/Item2").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{id:2,name:Item2,price:10}")).andReturn();
		JSONAssert.assertEquals("{id:2,name:Item2,price:10}", result.getResponse().getContentAsString(), false);

	}

	/**
	 * retreive_Item_byName_not_exists method tests the result incase of the output
	 * is null
	 *
	 * @throws Exception
	 */
	@Test
	void retreive_Item_byName_not_exists() throws Exception {
		given(businessService.retrieveByName("Item420")).willReturn(null);
		MockHttpServletRequestBuilder contentType = MockMvcRequestBuilders.get("/item-by-name/Item420")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(contentType).andExpect(jsonPath("$.message").value("Item does not exist"));
	}

	/**
	 * save_an_item method to test if the record is saved to db or not.
	 *
	 * @throws Exception
	 */
	@Test
	void save_an_item() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/save-an-item").accept(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"Item2\",\"price\":10}").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	/**
	 * update_an_item method to test the respective item is getting updated
	 * correctly
	 *
	 * @throws Exception
	 */
	@Test
	void update_an_item() throws Exception {
		given(businessService.retrieveById(2)).willReturn(Optional.of(new Item(2, "Item2", 10, 10)));

		mockMvc.perform(MockMvcRequestBuilders.patch("/update-an-item").accept(MediaType.APPLICATION_JSON)
				.content("{\"id\":2,\"name\":\"Item2\",\"price\":10}").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	/**
	 * delete_an_item method to test the respective item is getting updated
	 * correctly
	 *
	 * @throws Exception
	 */
	@Test
	void delete_an_item() throws Exception {
		given(businessService.retrieveById(2)).willReturn(Optional.of(new Item(2, "Item2", 10, 10)));

		mockMvc.perform(MockMvcRequestBuilders.delete("/delete/2").accept(MediaType.APPLICATION_JSON)
				.content("{\"id\":2,\"name\":\"Item2\",\"price\":10}").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	/**
	 * update_an_item_not_exists method tests the result incase of the input is null
	 *
	 * @throws Exception
	 */
	@Test
	void update_an_item_not_exists() throws Exception {
		given(businessService.retrieveById(2)).willReturn(Optional.empty());
		MockHttpServletRequestBuilder contentType = MockMvcRequestBuilders.patch("/update-an-item")
				.accept(MediaType.APPLICATION_JSON).content("{\"id\":2,\"name\":\"Item2\",\"price\":10}")
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(contentType).andExpect(jsonPath("$.message").value("Item to update does not exist"));
	}

	/**
	 * delete_an_item_not_exists method tests the result incase of the input is null
	 *
	 * @throws Exception
	 */
	@Test
	void delete_an_item_not_exists() throws Exception {
		given(businessService.retrieveById(2)).willReturn(Optional.empty());
		MockHttpServletRequestBuilder contentType = MockMvcRequestBuilders.delete("/delete/2")
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(contentType).andExpect(jsonPath("$.message").value("Item to delete does not exist"));
	}
}
