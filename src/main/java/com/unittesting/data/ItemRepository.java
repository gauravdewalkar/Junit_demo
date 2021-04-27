package com.unittesting.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unittesting.model.Item;

/**
 * The Class ItemRepository that extends JpaRepository which we use to perform
 * CRUD operations and store records to H2 Console
 * 
 * 
 * @since 21.02
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

	/**
	 * findByName method to get the respective item for the given name from db
	 *
	 * @param name is the name of the item
	 * @return the item
	 */
	@Query(value="select I.ID , I.NAME from ITEM I",nativeQuery = true)
	public Item findByName(String name);


	
	/*
	 * @Query(value = "SELECT i.ID, i. FROM ITEM i", nativeQuery = true) public
	 * List<Item> findItems();
	 */
}
