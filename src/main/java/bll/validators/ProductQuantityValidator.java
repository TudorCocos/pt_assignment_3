package main.java.bll.validators;

import main.java.model.Product;

public class ProductQuantityValidator implements Validator<Product> {

	public void validate(Product t) {

		if (t.getQuantity()<0) {
			throw new IllegalArgumentException("Can't have negative quantity!");
		}

	}

}
