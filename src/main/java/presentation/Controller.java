package main.java.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import main.java.bll.ClientBLL;
import main.java.bll.OrdersBLL;
import main.java.bll.ProductBLL;
import main.java.model.Client;
import main.java.model.Orders;
import main.java.model.Product;

public class Controller {
	
	private Gui gui;
	private List<Client> clientList = new ArrayList<Client>();
	private List<Product> productList = new ArrayList<Product>();
	private List<Orders> orderList = new ArrayList<Orders>();
	private ClientBLL clientBll = new ClientBLL();
	private ProductBLL productBll = new ProductBLL();
	private OrdersBLL orderBll = new OrdersBLL();
	private int currentPage;
	
	public Controller() {
		this.currentPage=1;
		gui = new Gui();
		clientList = clientBll.findAll();
		productList=productBll.findAll();
		orderList=orderBll.findAll();
		run();
	}
	private Object[][] makeData(List<?> ol){
		Object[][] data = new Object[ol.size()][ol.getClass().getDeclaredFields().length];
		int line=0,column=0;
		for(Object o: ol) {
			Field[] fields = o.getClass().getDeclaredFields();
			column=0;
			for(Field f : fields) {
				f.setAccessible(true);
				Object value;
				try {
					value = f.get(o);
					data[line][column]=value;
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				column++;
			}
			line++;
		}
		return data;
	}
	private String[] makeColumns(Class c) {
		Object obj=null;
		try {
			obj = c.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		Field[] fields = obj.getClass().getDeclaredFields();
		String[] string = new String[fields.length];
		int column=0;
		for (Field f : fields) {
			f.setAccessible(true);
			string[column]=f.getName();
			column++;
		}
		return string;
	}
	private void printTable() {
		clientList=clientBll.findAll();
		productList=productBll.findAll();
		orderList=orderBll.findAll();
		gui.getTextField().setText("");
		switch(currentPage) {
		case 1: {
			gui.showTable(currentPage,makeData(clientList), makeColumns(Client.class));
		}break;
		case 2:{
			gui.showTable(currentPage,makeData(productList), makeColumns(Product.class));
		}break;
		default:{
			gui.showTable(currentPage,makeData(orderList), makeColumns(Orders.class));
		}break;
		}
	}
	private void run() {
		gui.getClientsBtn().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentPage=1;
				gui.showClientElements();
				printTable();
			}
		});
		gui.getProductsBtn().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentPage=2;
				gui.showProductElements();
				printTable();
			}
		});
		gui.getOrdersBtn().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentPage=3;
				gui.showOrderElements();
				printTable();
			}
		});
		gui.getInsertBtn().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch(currentPage) {
				case 1:{
					Client c = new Client(gui.getIdField(),gui.getClientsName(),gui.getClientsAddress(),gui.getClientsEmail(),gui.getClientsMobile(),gui.getClientsAge());
					clientBll.insertClient(c);
					printTable();
				}break;
				case 2:{
					Product p = new Product(gui.getIdField(),gui.getProductName(),gui.getProductQuantity(),gui.getProductPrice());
					productBll.insertProduct(p);
					printTable();
				}break;
				default:{
					int value,quantity;
					quantity=gui.getOrderQuantity();
					Product p = productBll.findProductById(gui.getOrderProduct());
					if(p.getQuantity()>gui.getOrderQuantity()) {
						value=p.getPrice()*quantity;
						Orders o = new Orders(gui.getIdField(),gui.getOrderCustomer(),p.getId(),quantity,value);
						orderBll.insertOrders(o);
						p.setQuantity(p.getQuantity()-quantity);
						productBll.updateProduct(p);
						printTable();
						
						Path filePath = Paths.get(System.getProperty("user.home") + "/Desktop"+"/receipt"+o.getId()+".txt"); 
						List<String> sb = new ArrayList<String>();
						sb.add("---------Receipt No. "+o.getId()+"---------\n");
						sb.add(p.getName()+"			  Total\n");
						sb.add(o.getProductQuantity()+"x"+p.getPrice()+"Lei                   "+o.getValue()+"Lei\n");
						sb.add("\nCustomer ID: "+o.getCustomerId()+"\n");
						sb.add("-------------------------------");
						try {
							Files.write(filePath, sb, Charset.forName("UTF-8"));
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					else {
						gui.getTextField().setText("UNDER STOCK");
					}
				}break;
				}
			}
		});
		gui.getUpdateBtn().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch(currentPage) {
				case 1:{
					Client old = clientBll.findClientById(gui.getIdField());
					if(gui.getClientsName().length()>0)
						old.setName(gui.getClientsName());
					if(gui.getClientsAddress().length()>0)
						old.setAddress(gui.getClientsAddress());
					if(gui.getClientsMobile().length()>0)
						old.setMobile(gui.getClientsMobile());
					if(gui.getClientsEmail().length()>0)
						old.setEmail(gui.getClientsEmail());
					if(gui.getClientsAge()>0)
						old.setAge(gui.getClientsAge());
					clientBll.updateClient(old);
					printTable();
				}break;
				case 2:{
					Product old = productBll.findProductById(gui.getIdField());
					if(gui.getProductName().length()>0)
						old.setName(gui.getProductName());
					if(gui.getProductQuantity()>0)
						old.setQuantity(gui.getProductQuantity());
					if(gui.getProductPrice()>0)
						old.setPrice(gui.getProductPrice());
					productBll.updateProduct(old);
					printTable();
				}break;
				default:{
					//ORDER - an order should not be updated 
				}break;
				}
			}
		});
		gui.getDeleteBtn().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch(currentPage) {
				case 1:{
					Client c = clientBll.findClientById(gui.getIdField());
					clientBll.deleteClient(c);
					printTable();
				}break;
				case 2:{
					Product p = productBll.findProductById(gui.getIdField());
					productBll.deleteProduct(p);
					printTable();
				}break;
				default:{
					Orders o = orderBll.findOrdersById(gui.getIdField());
					Product p = productBll.findProductById(o.getProductId());
					p.setQuantity(p.getQuantity()+o.getProductQuantity());
					productBll.updateProduct(p);
					orderBll.deleteOrders(o);
					printTable();
				}break;
				}
			}
		});
	}
	public static void main(String[] args) {
		Controller ctrl = new Controller();
		ctrl.gui.setVisible(true);
	}
}
