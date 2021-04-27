package com.unittesting.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.unittesting.data.ItemRepository;
import com.unittesting.model.Item;

/**
 * The Class ItemBusinessServiceTest contains various methods to test the
 * business logics in ItemBusinessService class
 * 
 * 
 * @since 21.02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemBusinessServiceTest {

	/** The business is the instance of ItemBusinessService */
	@InjectMocks
	private ItemBusinessService business;

	/** The repository is the instance of ItemRepository */
	@Mock
	private ItemRepository repository;

	/**
	 * retrieveHardcodedItemsTest method used to test the hardcoded values are
	 * retured correctly
	 */
	@Test
	void retrieveHardcodedItemsTest() {
		List<Item> items = business.retreiveHardcodedItem();
		assertThat(items).hasSize(1).allMatch(x -> x.getName().contains("Ball")).allMatch(x -> x.getId() == 1);
	}

	/**
	 * retrieveAllItemsTest tests the method fetch all the datas in the db.
	 */
	@Test
	void retrieveAllItemsTest() {
		when(repository.findAll())
				.thenReturn(Arrays.asList(new Item(2, "Item2", 10, 10), new Item(3, "Item3", 20, 20)));
		List<Item> items = business.retrieveAllItems();
		assertThat(items).hasSize(2).allMatch(x -> x.getName().contains("Item")).allMatch(x -> x.getId() > 1);
	}

	/**
	 * retrieveByIdTest checks the retrieveById method in service returns the
	 * respective item for the id.
	 */
	@Test
	void retrieveByIdTest() {
		given(repository.findById(2)).willReturn(Optional.of(new Item(2, "Item2", 10, 100)));

		Optional<Item> item = business.retrieveById(2);
		assertThat(item.get().getId()).isEqualTo(2);
		assertThat(item.get().getName()).contains("Item2");
		assertThat(item.get().getPrice()).isEqualTo(10);
		assertThat(item.get().getQuantity()).isEqualTo(100);
	}

	/**
	 * retrieveByNameTest checks the retrieveByName method in service returns the
	 * respective item for the name.
	 */
	@Test
	void retrieveByNameTest() {

		when(repository.findByName("Item2")).thenReturn(new Item(2, "Item2", 10, 100));

		Item item = business.retrieveByName("Item2");
		assertThat(item.getId()).isEqualTo(2);
		assertThat(item.getName()).contains("Item2");
		assertThat(item.getPrice()).isEqualTo(10);
		assertThat(item.getQuantity()).isEqualTo(100);
	}

	/**
	 * saveTest tests the data saved in the db correctly.
	 *
	 * @throws Exception incase of failure
	 */
	@Test
	void saveTest() throws Exception {
		Item item = new Item(2, "Item2", 10, 10);
		business.save(item);
		verify(repository, times(1)).save(item);
	}

	/**
	 * deleteTest tests the data saved in the db correctly.
	 *
	 * @throws Exception incase of failure
	 */
	@Test
	void deleteTest() throws Exception {
		business.delete(2);
		verify(repository, times(1)).deleteById(2);
	}
}
