package main.java.model;

public class Orders {

	private int id;
	private int customerId;
	private int productId;
	private int productQuantity;
	private int value;
	
	public Orders() {	
	}
	public Orders(int id, int customerId, int productId, int productQuantity, int value) {
		this.id = id;
		this.customerId = customerId;
		this.productId = productId;
		this.productQuantity = productQuantity;
		this.value = value;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
