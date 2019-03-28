package main.java.bll;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import main.java.bll.validators.ProductPriceValidator;
import main.java.bll.validators.ProductQuantityValidator;
import main.java.bll.validators.Validator;
import main.java.dao.ProductDAO;
import main.java.model.Product;
public class ProductBLL {
	private List<Validator<Product>> validators;
	private ProductDAO productDAO;
	public ProductBLL() {
		validators = new ArrayList<Validator<Product>>();
		validators.add(new ProductPriceValidator());
		validators.add(new ProductQuantityValidator());
		this.productDAO=new ProductDAO();
	}
	public List<Product> findAll() {
		List<Product> result = productDAO.findAll();
		if(result == null) {
			System.out.println("empty");
			return null;
		}
		return result;
	}
	public Product findProductById(int id) {
		Product st = productDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The product with id =" + id + " was not found!");
		}
		return st;
	}
	public void insertProduct(Product product) {
		for (Validator<Product> v : validators) {
			v.validate(product);
		}
		productDAO.insert(product);
	}
	public void deleteProduct(Product product) {
		for (Validator<Product> v : validators) {
			v.validate(product);
		}
		productDAO.delete(product);
	}
	public void updateProduct(Product product) {
		for (Validator<Product> v : validators) {
			v.validate(product);
		}
		productDAO.update(product);
	}
}
