package main.java.bll.validators;

import main.java.model.Product;

public class ProductPriceValidator implements Validator<Product> {

	public void validate(Product t) {

		if (t.getPrice()<0) {
			throw new IllegalArgumentException("Can't have negative prices!");
		}

	}

}
