package com.unittesting.model;

import javax.persistence.Id;

import lombok.Getter;

/**
 * The Class ItemModel contains getters and setters to store the datas
 * 
 * 
 *
 */
@Getter
public class ItemContents {

	/** The id. */
	@Id
	private int id;

	/** The name. */
	private String name;

	/** The price. */
	private int price;

	/** The quantity. */
	private int quantity;

}
