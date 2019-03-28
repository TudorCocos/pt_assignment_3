package main.java.model;

public class Client {

	private int id;
	private String name;
	private String address;
	private String email;
	private String mobile;
	private int age;
	
	public Client() {
		
	}
	public Client(int id, String name, String address, String email, String mobile, int age) {
		this.id=id;
		this.name=name;
		this.address=address;
		this.email=email;
		this.mobile=mobile;
		this.age=age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
