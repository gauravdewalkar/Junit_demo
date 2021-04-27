package com.unittesting.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.NestedServletException;

import com.unittesting.business.ItemBusinessService;
import com.unittesting.business.ItemServiceImpl;
import com.unittesting.exception.UserNotFoundException;
import com.unittesting.model.Item;
import com.unittesting.model.ItemContents;

/**
 * The Class ItemController routes the different requests to their corresponding
 * methods and returns the respective responses back to the user.
 * 
 * 
 * @since 21.02
 */
@RestController
public class ItemController {

	/** The business service is the instance of ItemBusinessService */
	@Autowired
	private ItemBusinessService businessService;

	/** The item service is the instance of ItemServiceImpl */
	@Autowired
	private ItemServiceImpl itemService;

	/**
	 * itemFromBusinessService method is used to get the hardcoded items.
	 *
	 * @return the list of items
	 */
	@GetMapping("/item-from-business-service")
	public List<Item> itemFromBusinessService() {
		return businessService.retreiveHardcodedItem();
	}

	/**
	 * retrieveAllItems method is used to get all the items in the db.
	 *
	 * @return the list of all items
	 */
	@GetMapping("/all-items-from-database")
	public List<Item> retrieveAllItems() {
		return businessService.retrieveAllItems();
	}

	/**
	 * retrieveItemByName method is used to get the item by its name.
	 *
	 * @param name of item
	 * @return the respective item
	 * @throws NestedServletException
	 */
	@GetMapping("/item-by-name/{name}")
	public Item retrieveItemByName(@PathVariable String name) throws NestedServletException {
		Item retrieveByName = businessService.retrieveByName(name);
		if (Objects.isNull(retrieveByName)) {
			throw new UserNotFoundException("Item does not exist");
		}
		return retrieveByName;
	}

	/**
	 * insertItem used to insert an item using persistence context to the database.
	 *
	 * @param item is the item entity to store
	 * @return the response entity
	 */
	@PostMapping("/insert-an-item")
	public ResponseEntity<Boolean> insertItem(@RequestBody ItemContents item) {
		itemService.insert(doMapping(item));
		return ResponseEntity.ok(true);
	}

	/**
	 * saveItem method is used to save an item entity to the db.
	 *
	 * @param item is the item entity to store
	 * @return the response entity
	 */
	@PostMapping("/save-an-item")
	public ResponseEntity<Boolean> saveItem(@RequestBody ItemContents item) {
		businessService.save(doMapping(item));
		return ResponseEntity.ok(true);
	}

	/**
	 * updateItem method is used to update the corresponding item in db
	 *
	 * @param item is the item entity to update
	 * @return the response entity
	 * @throws NestedServletException
	 */
	@PatchMapping("/update-an-item")
	public ResponseEntity<Boolean> updateItem(@RequestBody ItemContents item) throws NestedServletException {
		Item itemMapped = doMapping(item);
		Optional<Item> itemToDo = businessService.retrieveById(itemMapped.getId());
		if (!itemToDo.isPresent()) {
			throw new UserNotFoundException("Item to update does not exist");
		}
		businessService.save(itemMapped);
		return ResponseEntity.ok(true);
	}

	/**
	 * deleteItem method is used to delete the corresponding item in db using its id
	 *
	 * @param item is the item entity to update
	 * @return the response entity
	 * @throws NestedServletException
	 */

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteItem(@PathVariable int id) throws NestedServletException {
		Optional<Item> itemToDo = businessService.retrieveById(id);
		if (!itemToDo.isPresent()) {
			throw new UserNotFoundException("Item to delete does not exist");
		}
		businessService.delete(id);
		return ResponseEntity.ok(true);
	}

	/**
	 * doMapping method to set the input contents values to item entity
	 *
	 * @param itemModel
	 * @return the item
	 */
	private Item doMapping(ItemContents itemModel) {
		return new Item(itemModel.getId(), itemModel.getName(), itemModel.getPrice(), itemModel.getQuantity());
	}

}
