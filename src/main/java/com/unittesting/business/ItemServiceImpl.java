package com.unittesting.business;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.unittesting.model.Item;

/**
 * The Class ItemServiceImpl contains various methods to provide business logics
 * as per the requests.
 * 
 * 
 * @since 21.02
 */
@Repository
@Transactional
public class ItemServiceImpl {

	/** The entity manager is the instance of EntityManager */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Insert method used to insert an item entity using entity manager
	 *
	 * @param item entity to save
	 */
	public void insert(Item item) {
		entityManager.persist(item);
		entityManager.flush();
	}
}
