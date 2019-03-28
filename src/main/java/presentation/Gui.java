package main.java.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JButton btnClientsTable;
	private JButton btnProductsTable;
	private JButton btnOrdersTable;
	private JTable tableClient;
	private JTable tableProduct;
	private JTable tableOrder;
	private JScrollPane scrollPaneClient;
	private JScrollPane scrollPaneProduct;
	private JScrollPane scrollPaneOrder;
	private JTextField idField;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	
	private JTextField clientsName;
	private JTextField clientsAddress;
	private JTextField clientsMobile;
	private JTextField clientsEmail;
	private JTextField clientsAge;
	private JLabel cName;
	private JLabel cAddress;
	private JLabel cEmail;
	private JLabel cMobile;
	private JLabel cAge;
	
	private JTextField productName;
	private JTextField productQuantity;
	private JTextField productPrice;
	private JLabel pName;
	private JLabel pQuantity;
	private JLabel pPrice;
	private JTextField orderCustomer;
	private JTextField orderProduct;
	private JTextField orderQuantity;
	private JLabel oCustomer;
	private JLabel oProduct;
	private JLabel oQuantity;
	private JTextField textField;
	public JTextField getTextField() {
		return textField;
	}
	public JButton getClientsBtn() {
		return btnClientsTable;
	}
	public JButton getProductsBtn() {
		return btnProductsTable;
	}
	public JButton getOrdersBtn() {
		return btnOrdersTable;
	}
	public JButton getInsertBtn() {
		return btnInsert;
	}
	public JButton getUpdateBtn() {
		return btnUpdate;
	}
	public JButton getDeleteBtn() {
		return btnDelete;
	}
	public int getIdField() {
		return Integer.parseInt(idField.getText());
	}
	public String getClientsName() {
		return clientsName.getText();
	}
	public String getClientsAddress() {
		return clientsAddress.getText();
	}
	public String getClientsMobile() {
		return clientsMobile.getText();
	}
	public String getClientsEmail() {
		return clientsEmail.getText();
	}
	public int getClientsAge() {
		if(clientsAge.getText().compareTo("")!=0)
			return Integer.parseInt(clientsAge.getText());
		return -1;
	}
	public String getProductName() {
		return productName.getText();
	}
	public int getProductQuantity() {
		if(productQuantity.getText().compareTo("")!=0)
			return Integer.parseInt(productQuantity.getText());
		return -1;
	}
	public int getProductPrice() {
		if(productPrice.getText().compareTo("")!=0)
			return Integer.parseInt(productPrice.getText());
		return -1;
	}
	public int getOrderCustomer() {
		if(orderCustomer.getText().compareTo("")!=0)
			return Integer.parseInt(orderCustomer.getText());
		return -1;
	}
	public int getOrderProduct() {
		if(orderProduct.getText().compareTo("")!=0)
			return Integer.parseInt(orderProduct.getText());
		return -1;
	}
	public int getOrderQuantity() {
		if(orderQuantity.getText().compareTo("")!=0)
			return Integer.parseInt(orderQuantity.getText());
		return -1;
	}
	public void showTable(int page, Object[][] data, String[] columns) {
		switch(page) {
		case 1:{
			tableClient=new JTable(data,columns);
			scrollPaneClient = new JScrollPane(tableClient);
			scrollPaneClient.setBounds(20, 400, 755, 355);
			contentPane.add(scrollPaneClient);
			scrollPaneClient.setVisible(true);
			scrollPaneProduct.setVisible(false);
			scrollPaneOrder.setVisible(false);
		}break;
		case 2:{
			tableProduct=new JTable(data,columns);
			scrollPaneProduct = new JScrollPane(tableProduct);
			scrollPaneProduct.setBounds(20, 400, 755, 355);
			contentPane.add(scrollPaneProduct);
			scrollPaneProduct.setVisible(true);
			scrollPaneClient.setVisible(false);
			scrollPaneOrder.setVisible(false);
		}break;
		default:{
			tableOrder=new JTable(data,columns);
			scrollPaneOrder = new JScrollPane(tableOrder);
			scrollPaneOrder.setBounds(20, 400, 755, 355);
			contentPane.add(scrollPaneOrder);
			scrollPaneProduct.setVisible(false);
			scrollPaneClient.setVisible(false);
			scrollPaneOrder.setVisible(true);
		}break;
		}
	}
	public void showClientElements() {
		productName.setVisible(false);
		productQuantity.setVisible(false);
		productPrice.setVisible(false);
		pName.setVisible(false);
		pQuantity.setVisible(false);
		pPrice.setVisible(false);
		
		orderCustomer.setVisible(false);
		orderProduct.setVisible(false);
		orderQuantity.setVisible(false);
		oCustomer.setVisible(false);
		oProduct.setVisible(false);
		oQuantity.setVisible(false);
		
		clientsName.setVisible(true);
		clientsAddress.setVisible(true);
		clientsMobile.setVisible(true);
		clientsEmail.setVisible(true);
		clientsAge.setVisible(true);
		cName.setVisible(true);
		cAddress.setVisible(true);
		cEmail.setVisible(true);
		cMobile.setVisible(true);
		cAge.setVisible(true);
	}
	public void showProductElements() {
		orderCustomer.setVisible(false);
		orderProduct.setVisible(false);
		orderQuantity.setVisible(false);
		oCustomer.setVisible(false);
		oProduct.setVisible(false);
		oQuantity.setVisible(false);
		
		clientsName.setVisible(false);
		clientsAddress.setVisible(false);
		clientsMobile.setVisible(false);
		clientsEmail.setVisible(false);
		clientsAge.setVisible(false);
		cName.setVisible(false);
		cAddress.setVisible(false);
		cEmail.setVisible(false);
		cMobile.setVisible(false);
		cAge.setVisible(false);
		
		productName.setVisible(true);
		productQuantity.setVisible(true);
		productPrice.setVisible(true);
		pName.setVisible(true);
		pQuantity.setVisible(true);
		pPrice.setVisible(true);
	}
	public void showOrderElements() {
		clientsName.setVisible(false);
		clientsAddress.setVisible(false);
		clientsMobile.setVisible(false);
		clientsEmail.setVisible(false);
		clientsAge.setVisible(false);
		cName.setVisible(false);
		cAddress.setVisible(false);
		cEmail.setVisible(false);
		cMobile.setVisible(false);
		cAge.setVisible(false);
		
		productName.setVisible(false);
		productQuantity.setVisible(false);
		productPrice.setVisible(false);
		pName.setVisible(false);
		pQuantity.setVisible(false);
		pPrice.setVisible(false);
		
		orderCustomer.setVisible(true);
		orderProduct.setVisible(true);
		orderQuantity.setVisible(true);
		oCustomer.setVisible(true);
		oProduct.setVisible(true);
		oQuantity.setVisible(true);
	}
	public Gui() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnClientsTable = new JButton("Clients Table");
		btnClientsTable.setBounds(20, 25, 150, 30);
		contentPane.add(btnClientsTable);
		
		btnProductsTable = new JButton("Products Table");
		btnProductsTable.setBounds(325, 25, 150, 30);
		contentPane.add(btnProductsTable);
		
		btnOrdersTable = new JButton("Orders Table");
		btnOrdersTable.setBounds(625, 25, 150, 30);
		contentPane.add(btnOrdersTable);
		
		idField = new JTextField();
		idField.setBounds(20, 100, 150, 30);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(20, 80, 150, 20);
		contentPane.add(lblNewLabel);
		
		btnInsert = new JButton("Insert");
		btnInsert.setBounds(625, 100, 150, 30);
		contentPane.add(btnInsert);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(625, 180, 150, 30);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(625, 260, 150, 30);
		contentPane.add(btnDelete);
		
		clientsName = new JTextField();
		clientsName.setBounds(325,100,150,30);
		
		cName =  new JLabel("Client Name");
		cName.setBounds(325,80,150,20);
		
		clientsAddress = new JTextField();
		clientsAddress.setBounds(325,160,150,30);
		
		cAddress =  new JLabel("Client Address");
		cAddress.setBounds(325,140,150,20);
		
		clientsEmail = new JTextField();
		clientsEmail.setBounds(325,220,150,30);
		
		cEmail =  new JLabel("Client Email");
		cEmail.setBounds(325,200,150,20);
		
		clientsMobile = new JTextField();
		clientsMobile.setBounds(325,280,150,30);
		
		cMobile =  new JLabel("Client Mobile");
		cMobile.setBounds(325,260,150,20);
		
		clientsAge = new JTextField();
		clientsAge.setBounds(325,340,150,30);
		
		cAge =  new JLabel("Client Age");
		cAge.setBounds(325,320,150,20);
		
		productName = new JTextField();
		productName.setBounds(325,100,150,30);
		
		pName =  new JLabel("Product Name");
		pName.setBounds(325,80,150,20);
		
		productQuantity = new JTextField();
		productQuantity.setBounds(325,180,150,30);
		
		pQuantity =  new JLabel("Product Quantity");
		pQuantity.setBounds(325,160,150,20);
		
		productPrice = new JTextField();
		productPrice.setBounds(325,260,150,30);
		
		pPrice =  new JLabel("Product Price");
		pPrice.setBounds(325,240,150,20);
		
		orderCustomer = new JTextField();
		orderCustomer.setBounds(325,100,150,30);
		
		oCustomer = new JLabel("Customer ID");
		oCustomer.setBounds(325,80,150,20);
		
		orderProduct = new JTextField();
		orderProduct.setBounds(325,180,150,30);
		
		oProduct = new JLabel("Product ID");
		oProduct.setBounds(325,160,150,20);
		
		orderQuantity = new JTextField();
		orderQuantity.setBounds(325,260,150,30);
		
		oQuantity = new JLabel("Quantity");
		oQuantity.setBounds(325,240,150,20);
		
		contentPane.add(orderCustomer);
		contentPane.add(orderProduct);
		contentPane.add(orderQuantity);
		contentPane.add(oCustomer);
		contentPane.add(oProduct);
		contentPane.add(oQuantity);
		
		contentPane.add(productName);
		contentPane.add(productPrice);
		contentPane.add(productQuantity);
		contentPane.add(pName);
		contentPane.add(pPrice);
		contentPane.add(pQuantity);
		
		contentPane.add(clientsAddress);
		contentPane.add(clientsAge);
		contentPane.add(clientsEmail);
		contentPane.add(clientsName);
		contentPane.add(clientsMobile);
		contentPane.add(cAddress);
		contentPane.add(cAge);
		contentPane.add(cEmail);
		contentPane.add(cMobile);
		contentPane.add(cName);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setForeground(Color.RED);
		textField.setEnabled(false);
		textField.setBounds(625, 340, 150, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		clientsName.setVisible(false);
		clientsAddress.setVisible(false);
		clientsMobile.setVisible(false);
		clientsEmail.setVisible(false);
		clientsAge.setVisible(false);
		cName.setVisible(false);
		cAddress.setVisible(false);
		cEmail.setVisible(false);
		cMobile.setVisible(false);
		cAge.setVisible(false);
		
		productName.setVisible(false);
		productQuantity.setVisible(false);
		productPrice.setVisible(false);
		pName.setVisible(false);
		pQuantity.setVisible(false);
		pPrice.setVisible(false);
		
		orderCustomer.setVisible(false);
		orderProduct.setVisible(false);
		orderQuantity.setVisible(false);
		oCustomer.setVisible(false);
		oProduct.setVisible(false);
		oQuantity.setVisible(false);
		
		tableClient = new JTable();
		tableClient.setVisible(false);
		tableClient.setAutoCreateRowSorter(true);
		tableProduct = new JTable();
		tableProduct.setVisible(false);
		tableProduct.setAutoCreateRowSorter(true);
		tableOrder = new JTable();
		tableOrder.setVisible(false);
		tableOrder.setAutoCreateRowSorter(true);
		
		scrollPaneClient = new JScrollPane();
		scrollPaneProduct = new JScrollPane();
		scrollPaneOrder = new JScrollPane();
		
	}
}
