package main.java.bll.validators;
import main.java.model.Client;
public class ClientMobileValidator implements Validator<Client> {
	public void validate(Client t) {

		if (t.getMobile().length()<10) {
			throw new IllegalArgumentException("The mobile phone number is shorter than 10 digits!");
		}
		if (t.getMobile().length()>10) {
			throw new IllegalArgumentException("The mobile phone number is longer than 10 digits!");
		}
	}
}
