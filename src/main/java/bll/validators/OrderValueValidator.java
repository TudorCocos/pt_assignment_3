package main.java.bll.validators;

import main.java.model.Orders;

public class OrderValueValidator implements Validator<Orders> {

	public void validate(Orders t) {

		if (t.getValue()<0) {
			throw new IllegalArgumentException("Can't have negative order values!");
		}

	}

}
