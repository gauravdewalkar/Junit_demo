package com.unittesting.data;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.unittesting.model.Item;

/**
 * The Class ItemBusinessService contains various methods to provide business
 * logics as per the requests
 * 
 * 
 * @since 21.02
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

	/** The repository is the instance of ItemRepository */
	@Mock
	private ItemRepository repository;

	/**
	 * test_FindBy_Name used to test the repository fetches the correct value for
	 * the given name
	 */
	@Test
	void test_FindBy_Name() {
		Item item = new Item(503, "Item503", 20, 500);
		when(repository.findByName("Item503")).thenReturn(item);
		Item findByName = repository.findByName(item.getName());
		assertThat(findByName.getName()).isEqualTo(item.getName());
		assertThat(findByName.getPrice()).isEqualTo(item.getPrice());
		assertThat(findByName.getQuantity()).isEqualTo(item.getQuantity());
	}
}
