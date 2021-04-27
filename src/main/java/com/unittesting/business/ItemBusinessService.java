package com.unittesting.business;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unittesting.data.ItemRepository;
import com.unittesting.model.Item;

/**
 * The Class ItemBusinessService contains various methods to provide business
 * logics as per the requests
 * 
 * @author dhkannan
 * @since 21.02
 */
@Service
public class ItemBusinessService {

	/** The repository is the instance of ItemRepository */
	@Autowired
	private ItemRepository repository;

	/**
	 * retreiveHardcodedItem method is used to get the hardcoded items.
	 *
	 * @return the list of items
	 */
	public List<Item> retreiveHardcodedItem() {
		return Arrays.asList(new Item(1, "Ball", 10, 100));
	}

	/**
	 * retrieveAllItems method is used to get all the items stored in the db
	 *
	 * @return the list of items
	 */
	public List<Item> retrieveAllItems() {
		return repository.findAll();
	}

	/**
	 * retrieveById method to get an item using its id.
	 *
	 * @param name of the item to be retrieve
	 * @return the item
	 */
	public Optional<Item> retrieveById(int id) {
		return repository.findById(id);
		
	}

	/**
	 * retrieveByName method to get an item using its name.
	 *
	 * @param name of the item to be retrieve
	 * @return the item
	 */
	public Item retrieveByName(String name) {
		return repository.findByName(name);
	}

	/**
	 * Save method used to save an item entity into the db.
	 *
	 * @param item the item
	 */
	public void save(Item item) {
		repository.save(item);
	}

	/**
	 * delete method is used to delete an item entity in the db using its id.
	 *
	 * @param id
	 */
	public void delete(int id) {
		repository.deleteById(id);
	}


}
