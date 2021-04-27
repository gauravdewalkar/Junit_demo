package com.unittesting.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

/**
 * The Class Item contains getters and setters to store and retrieve the entity
 * from the db
 * 
 * 
 * @since 21.02
 */
@Entity
@Getter
@Table(name = "ITEM")
public class Item {

	/** The id. */
	@Id
	private int id;

	/** The name. */
	private String name;

	/** The price. */
	private int price;

	/** The quantity. */
	private int quantity;

	/**
	 * Instantiates a new item.
	 */
	public Item() {
		super();
	}

	/**
	 * this is the parameterized constructor to create instance of this class by
	 * directly passing the values of the fields
	 * 
	 * @param id
	 * @param name
	 * @param price
	 * @param quantity
	 */
	public Item(int id, String name, int price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

}
