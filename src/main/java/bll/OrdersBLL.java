package main.java.bll;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import main.java.bll.validators.OrderValueValidator;
import main.java.bll.validators.OrderQuantityValidator;
import main.java.bll.validators.Validator;
import main.java.dao.OrdersDAO;
import main.java.model.Orders;
public class OrdersBLL {
	private List<Validator<Orders>> validators;
	private OrdersDAO orderDAO;
	public OrdersBLL() {
		validators = new ArrayList<Validator<Orders>>();
		validators.add(new OrderValueValidator());
		validators.add(new OrderQuantityValidator());
		this.orderDAO=new OrdersDAO();
	}
	public List<Orders> findAll() {
		List<Orders> result = orderDAO.findAll();
		if(result == null) {
			System.out.println("empty");
			return null;
		}
		return result;
	}
	public Orders findOrdersById(int id) {
		Orders st = orderDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The order with id =" + id + " was not found!");
		}
		return st;
	}
	public void insertOrders(Orders order) {
		for (Validator<Orders> v : validators) {
			v.validate(order);
		}
		orderDAO.insert(order);
	}
	public void deleteOrders(Orders order) {
		for (Validator<Orders> v : validators) {
			v.validate(order);
		}
		orderDAO.delete(order);
	}
	public void updateOrders(Orders order) {
		for (Validator<Orders> v : validators) {
			v.validate(order);
		}
		orderDAO.update(order);
	}
}
