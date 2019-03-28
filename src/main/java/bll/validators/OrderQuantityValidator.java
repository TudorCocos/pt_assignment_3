package main.java.bll.validators;

import main.java.model.Orders;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class OrderQuantityValidator implements Validator<Orders> {

	public void validate(Orders t) {

		if (t.getProductQuantity()<0) {
			throw new IllegalArgumentException("Can't have negative product quantity!");
		}

	}

}
