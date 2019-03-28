package main.java.bll;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import main.java.bll.validators.ClientAgeValidator;
import main.java.bll.validators.ClientMobileValidator;
import main.java.bll.validators.EmailValidator;
import main.java.bll.validators.Validator;
import main.java.dao.ClientDAO;
import main.java.model.Client;
public class ClientBLL {
	private List<Validator<Client>> validators;
	private ClientDAO clientDAO;
	
	public ClientBLL() {
		validators = new ArrayList<Validator<Client>>();
		validators.add(new EmailValidator());
		validators.add(new ClientAgeValidator());
		validators.add(new ClientMobileValidator());
		this.clientDAO=new ClientDAO();
	}
	public List<Client> findAll() {
		List<Client> result = clientDAO.findAll();
		if(result == null) {
			System.out.println("empty");
			return null;
		}
		return result;
	}
	public Client findClientById(int id) {
		Client st = clientDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The client with id =" + id + " was not found!");
		}
		return st;
	}
	public void insertClient(Client client) {
		for (Validator<Client> v : validators) {
			v.validate(client);
		}
		clientDAO.insert(client);
	}
	public void deleteClient(Client client) {
		for (Validator<Client> v : validators) {
			v.validate(client);
		}
		clientDAO.delete(client);
	}
	public void updateClient(Client client) {
		clientDAO.update(client);
	}
}
